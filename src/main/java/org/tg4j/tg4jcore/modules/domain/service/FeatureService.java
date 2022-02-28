package org.tg4j.tg4jcore.modules.domain.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tg4j.tg4jcore.model.ExecutionContext;
import org.tg4j.tg4jcore.modules.adapter.EnvironmentStore;
import org.tg4j.tg4jcore.modules.adapter.FeatureStore;
import org.tg4j.tg4jcore.modules.cases.check_feature.dto.CheckFeatureDto;
import org.tg4j.tg4jcore.modules.cases.check_feature.dto.Context;
import org.tg4j.tg4jcore.modules.domain.model.Environment;
import org.tg4j.tg4jcore.modules.domain.model.Feature;
import org.tg4j.tg4jcore.modules.domain.model.FeatureConfiguration;
import org.tg4j.tg4jcore.modules.domain.model.Property;
import org.tg4j.tg4jcore.strategy.Strategy;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class FeatureService {
    private final FeatureStore featureStore;
    private final EnvironmentStore environmentStore;
    Map<String, Strategy> strategies = new HashMap<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(FeatureService.class);

    public FeatureService(FeatureStore featureStore, EnvironmentStore environmentStore, List<Strategy> strategyList) {
        this.featureStore = featureStore;
        this.environmentStore = environmentStore;
        strategyList.forEach(e -> strategies.put(e.getName(), e));
    }


    public boolean  compute(CheckFeatureDto checkFeatureDto, Context context){
        Feature feature = this.featureStore.getFeature(checkFeatureDto.getName());

        Strategy featureStrategy;
        final ExecutionContext executionResult= new ExecutionContext();



        if(StringUtils.isNotEmpty(feature.getDefaultStrategy())){
                featureStrategy = strategies.get(feature.getDefaultStrategy());
                if(featureStrategy == null){
                    LOGGER.error("Either the strategy or the implementation of %s is not found ".formatted(feature.getDefaultStrategy()));
                    return false;
                }
        }else{
            LOGGER.warn("default strategy not defined, switching to default");
            featureStrategy = strategies.get("default");
        }

        featureStrategy.execute(feature, context, executionResult);

        if(StringUtils.isNotEmpty(checkFeatureDto.getEnv())){
            List<FeatureConfiguration> featureConfigurations = feature.getFeatureConfigurations()
                    .stream().filter(
                            fc -> checkFeatureDto.getEnv().matches(fc.getEnv().replaceAll("\\*", "\\\\w*"))
                    ).toList();

            List<String> envIds = featureConfigurations.stream().map(FeatureConfiguration::getEnv).toList();
            List<Environment> environments = environmentStore.getEnvironmentsByIds(envIds);

            if(featureConfigurations.size()> 1){
                LOGGER.info("detecting more than env, trying to filter generic '*' if exists");
                featureConfigurations=featureConfigurations.stream().filter(e-> !e.getEnv().equals("*")).toList();
                if(featureConfigurations.size()> 1) {
                    throw new RuntimeException("config have more than target");
                }
            }
            featureConfigurations.forEach(fc-> this.computeFeatureConfiguration(fc,environments, context, executionResult));
        }

        return executionResult.getStatus();
    }

    private void computeFeatureConfiguration(FeatureConfiguration featureConfiguration, List<Environment> environments, Context context, ExecutionContext executionResult) {
        LOGGER.info("compute feature configuration %s".formatted(featureConfiguration.getEnv()));
        Strategy configurationStrategy;
        if(StringUtils.isNotEmpty(featureConfiguration.getStrategy())){
            configurationStrategy = strategies.get(featureConfiguration.getStrategy());
            if(configurationStrategy == null){
                LOGGER.error("Either the strategy or the implementation of %s is not found ".formatted(featureConfiguration.getStrategy()));
            }
        }else{
            LOGGER.warn("default strategy in configuration not defined, switching to env strategy");
            configurationStrategy = strategies.get("default");
        }
        List<Property> properties = environments.stream()
                .filter(e -> e.getName().equals(featureConfiguration.getEnv()))
                .map(Environment::getProperties).flatMap(Collection::stream).toList();
        context.getFeatureProperties().addAll(properties);

        // todo load env properties and merge them in the context
        configurationStrategy.execute(featureConfiguration, context, executionResult);
    }
}

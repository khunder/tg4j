package org.tg4j.tg4jcore.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.tg4j.tg4jcore.modules.adapter.EnvironmentStore;
import org.tg4j.tg4jcore.modules.adapter.FeatureStore;
import org.tg4j.tg4jcore.infrastructure.impl.FileEnvironmentStoreImpl;
import org.tg4j.tg4jcore.infrastructure.impl.FileFeatureStoreImpl;

@Configuration
public class StoreFactory {
    private final Environment env;

    public StoreFactory(Environment env) {
        this.env = env;
    }


    @Bean
    @ConditionalOnMissingBean
    FeatureStore getDefaultFileFeatureStore(){
        return new FileFeatureStoreImpl(env.getProperty("tg4j.features-file"));
    }

    @Bean
    @ConditionalOnMissingBean
    EnvironmentStore getDefaultEnvironmentStore(){
        return new FileEnvironmentStoreImpl(env.getProperty("tg4j.features-file"));
    }

}

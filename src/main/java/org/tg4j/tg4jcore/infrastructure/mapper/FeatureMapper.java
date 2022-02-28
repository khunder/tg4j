package org.tg4j.tg4jcore.infrastructure.mapper;

import org.tg4j.tg4jcore.infrastructure.entities.FileFeature;
import org.tg4j.tg4jcore.infrastructure.entities.FileFeatureEnvironment;
import org.tg4j.tg4jcore.modules.domain.model.Feature;
import org.tg4j.tg4jcore.modules.domain.model.FeatureConfiguration;

public class FeatureMapper {

    public static Feature toDomain(FileFeature fileFeature){
        final var feature  = new Feature();
        feature.setName(fileFeature.getName());
        feature.setDefaultStrategy(fileFeature.getDefaultStrategy());
        if(fileFeature.isGlobalStatus() != null)
            feature.setStatus(fileFeature.isGlobalStatus());
        if(fileFeature.getProperties() != null)
            feature.setProperties(fileFeature.getProperties().stream().map(PropertyMapper::toDomain).toList());
        if(fileFeature.getEnvironment() != null)
            feature.setFeatureConfigurations(fileFeature.getEnvironment().stream().map(FeatureMapper::toDomainFeatureConfiguration).toList());

        return feature;
    };

    static FeatureConfiguration toDomainFeatureConfiguration(FileFeatureEnvironment fileFeatureEnvironment){
        final var featureConfiguration =  new FeatureConfiguration();
        featureConfiguration.setStatus(fileFeatureEnvironment.isStatus());
        featureConfiguration.setStrategy(fileFeatureEnvironment.getStrategy());
        featureConfiguration.setEnv(fileFeatureEnvironment.getName());
        return featureConfiguration;
    }
}

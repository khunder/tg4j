package org.tg4j.tg4jcore.modules.domain.model;

import java.util.List;

public class Feature extends EntityWithStatus{
    String name;
    String defaultStrategy;
    List<Property> properties;
    List<FeatureConfiguration> featureConfigurations;

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<FeatureConfiguration> getFeatureConfigurations() {
        return featureConfigurations;
    }

    public void setFeatureConfigurations(List<FeatureConfiguration> featureConfigurations) {
        this.featureConfigurations = featureConfigurations;
    }

    public String getDefaultStrategy() {
        return defaultStrategy;
    }

    public void setDefaultStrategy(String defaultStrategy) {
        this.defaultStrategy = defaultStrategy;
    }
}

package org.tg4j.tg4jcore.model;

import org.tg4j.tg4jcore.modules.domain.model.FeatureConfiguration;
import org.tg4j.tg4jcore.modules.domain.model.Feature;
import org.tg4j.tg4jcore.strategy.Strategy;

public class FeatureEnvironmentRecord {

    Feature feature;
    FeatureConfiguration environment;
    Strategy[] strategies;


    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public FeatureConfiguration getEnvironment() {
        return environment;
    }

    public void setEnvironment(FeatureConfiguration environment) {
        this.environment = environment;
    }

    public Strategy[] getStrategies() {
        return strategies;
    }

    public void setStrategies(Strategy[] strategies) {
        this.strategies = strategies;
    }

    boolean compute(){
        return feature.isStatus();
    }

}

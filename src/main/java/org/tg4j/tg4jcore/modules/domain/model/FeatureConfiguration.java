package org.tg4j.tg4jcore.modules.domain.model;

public class FeatureConfiguration extends EntityWithStatus {


    String env;
    String strategy;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }


    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }
}

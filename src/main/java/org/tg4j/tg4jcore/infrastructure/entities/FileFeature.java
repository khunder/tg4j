package org.tg4j.tg4jcore.infrastructure.entities;

import java.util.List;

public class FileFeature {
    String name;
    String defaultStrategy;
    Boolean globalStatus;
    List<FileProperty> properties;
    List<FileFeatureEnvironment> environment;

    public List<FileProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<FileProperty> properties) {
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isGlobalStatus() {
        return globalStatus;
    }

    public void setGlobalStatus(Boolean  globalStatus) {
        this.globalStatus = globalStatus;
    }

    public List<FileFeatureEnvironment> getEnvironment() {
        return environment;
    }

    public void setEnvironment(List<FileFeatureEnvironment> environment) {
        this.environment = environment;
    }

    public String getDefaultStrategy() {
        return defaultStrategy;
    }

    public void setDefaultStrategy(String defaultStrategy) {
        this.defaultStrategy = defaultStrategy;
    }
}

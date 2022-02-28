package org.tg4j.tg4jcore.infrastructure.entities;

public class FileFeatureEnvironment {
    String name;
    Boolean status;
    String strategy;
    FileProperty[] properties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public FileProperty[] getProperties() {
        return properties;
    }

    public void setProperties(FileProperty[] properties) {
        this.properties = properties;
    }
}

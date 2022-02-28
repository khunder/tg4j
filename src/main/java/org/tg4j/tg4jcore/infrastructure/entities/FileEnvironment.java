package org.tg4j.tg4jcore.infrastructure.entities;

import java.util.List;

public class FileEnvironment {
    String name;
    String globalStrategy;
    List<FileProperty> properties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGlobalStrategy() {
        return globalStrategy;
    }

    public void setGlobalStrategy(String globalStrategy) {
        this.globalStrategy = globalStrategy;
    }

    public List<FileProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<FileProperty> properties) {
        this.properties = properties;
    }
}

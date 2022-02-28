package org.tg4j.tg4jcore.modules.domain.model;

import java.util.List;

public class Environment {
    String name;
    boolean status;
    String globalStrategy;
    List<Property> properties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getGlobalStrategy() {
        return globalStrategy;
    }

    public Environment setGlobalStrategy(String globalStrategy) {
        this.globalStrategy = globalStrategy;
        return this;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}

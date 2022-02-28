package org.tg4j.tg4jcore.modules.cases.check_feature.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import org.tg4j.tg4jcore.modules.domain.model.Property;

import java.util.List;

public class CheckFeatureDto {


    @Schema(name = "name", type = "String", implementation = String.class, defaultValue = "feature1")
    private String name;

    List<Property> properties;

    @Schema(name = "env", type = "String", implementation = String.class, defaultValue = "dev")
    String env;

    Object extension;

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public CheckFeatureDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Object getExtension() {
        return extension;
    }

    public void setExtension(Object extension) {
        this.extension = extension;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }
}

package org.tg4j.tg4jcore.modules.domain.model;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.RequestBody;

public class Property {

    @Schema(name = "name", type = "String", implementation = String.class)
    String name;
    @Schema(name = "value", type = "String", implementation = String.class)
    String value;

    public Property() {
    }

    public Property(String strProperty) {
        try {
            this.name = strProperty.split("=")[0];
            this.value = strProperty.split("=")[1];
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Property(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

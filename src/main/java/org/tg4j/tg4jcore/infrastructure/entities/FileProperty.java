package org.tg4j.tg4jcore.infrastructure.entities;

import io.swagger.v3.oas.annotations.media.Schema;


public class FileProperty {

    String name;
    String value;

    public FileProperty() {
    }

    public FileProperty(String strProperty) {
        try {
            this.name = strProperty.split("=")[0];
            this.value = strProperty.split("=")[1];
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public FileProperty(String name, String value) {
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

package org.tg4j.tg4jcore.modules.cases.check_feature.dto;

import org.springframework.http.HttpHeaders;
import org.tg4j.tg4jcore.modules.domain.model.Property;

import java.util.ArrayList;
import java.util.List;

public class Context {

    CheckFeatureDto checkFeatureDto;
    HttpHeaders headers;

    List<Property> featureProperties = new ArrayList<>();
    List<Property> envProperties = new ArrayList<>();
    Object extension;


    public CheckFeatureDto getCheckFeatureDto() {
        return checkFeatureDto;
    }

    public Context setCheckFeatureDto(CheckFeatureDto checkFeatureDto) {
        this.checkFeatureDto = checkFeatureDto;
        return this;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public Context setHeaders(HttpHeaders headers) {
        this.headers = headers;
        return this;
    }

    public List<Property> getFeatureProperties() {
        return featureProperties;
    }

    public void setFeatureProperties(List<Property> featureProperties) {
        this.featureProperties = featureProperties;
    }

    public List<Property> getEnvProperties() {
        return envProperties;
    }

    public void setEnvProperties(List<Property> envProperties) {
        this.envProperties = envProperties;
    }

    public Object getExtension() {
        return extension;
    }

    public void setExtension(Object extension) {
        this.extension = extension;
    }
}

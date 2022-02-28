package org.tg4j.tg4jcore.modules.adapter;

import org.tg4j.tg4jcore.modules.domain.model.Feature;
import org.tg4j.tg4jcore.modules.cases.get_features.dto.FindFeaturesDto;

import java.io.IOException;
import java.util.List;

public interface FeatureStore {

    public Feature addFeature(String name, boolean status);
    public Feature deleteFeature(String name);
    public void updateFeatureStatus(String name);
    public void addProperty(String name, String value);
    public void removeProperty(String name);
    public void attachEnvironment(String name);
    public void detachEnvironment(String name);
    public Feature getFeature(String name);
    public List<Feature> getFeatures(FindFeaturesDto searchCriteria, int page, int size);
}

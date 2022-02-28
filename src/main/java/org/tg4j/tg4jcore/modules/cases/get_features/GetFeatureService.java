package org.tg4j.tg4jcore.modules.cases.get_features;

import org.springframework.stereotype.Service;
import org.tg4j.tg4jcore.modules.domain.model.Feature;
import org.tg4j.tg4jcore.modules.adapter.FeatureStore;
import org.tg4j.tg4jcore.modules.cases.get_features.dto.FindFeaturesDto;

import java.util.List;

@Service
public class GetFeatureService {

    private final FeatureStore featureStore;


    public GetFeatureService(FeatureStore featureStore) {
        this.featureStore = featureStore;
    }

    public List<Feature> getFeatures(FindFeaturesDto searchCriteria){
        return featureStore.getFeatures(searchCriteria, 50 , 50);
    }


}

package org.tg4j.tg4jcore.modules.cases.check_feature;

import org.springframework.stereotype.Service;
import org.tg4j.tg4jcore.modules.adapter.FeatureStore;
import org.tg4j.tg4jcore.modules.domain.model.Feature;
import org.tg4j.tg4jcore.modules.cases.check_feature.dto.CheckFeatureDto;
import org.tg4j.tg4jcore.modules.cases.check_feature.dto.Context;
import org.tg4j.tg4jcore.modules.cases.get_features.dto.FindFeaturesDto;
import org.tg4j.tg4jcore.modules.domain.service.FeatureService;

import java.util.List;

@Service
public class CheckFeatureService {



    FeatureService featureService;

    public CheckFeatureService(FeatureService featureService) {
        this.featureService = featureService;
    }

    public boolean check(CheckFeatureDto checkFeatureDto, Context context) {
        return this.featureService.compute(checkFeatureDto, context);
    }
}

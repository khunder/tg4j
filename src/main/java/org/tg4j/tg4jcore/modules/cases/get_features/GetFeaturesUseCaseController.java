package org.tg4j.tg4jcore.modules.cases.get_features;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.tg4j.tg4jcore.modules.domain.model.Feature;
import org.tg4j.tg4jcore.modules.cases.get_features.dto.FindFeaturesDto;

import java.util.List;

@RestController()
@RequestMapping("features")
@Tag(name="Features")
public class GetFeaturesUseCaseController {

    private final GetFeatureService getFeatureService;

    public GetFeaturesUseCaseController(GetFeatureService getFeatureService) {
        this.getFeatureService = getFeatureService;
    }

    @GetMapping()
    public List<Feature> features(@RequestParam(required = false, defaultValue = "") String name) {
        return this.getFeatureService.getFeatures(new FindFeaturesDto().setName(name));
    }

}

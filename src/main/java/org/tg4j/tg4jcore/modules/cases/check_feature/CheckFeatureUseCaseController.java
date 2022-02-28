package org.tg4j.tg4jcore.modules.cases.check_feature;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tg4j.tg4jcore.modules.cases.check_feature.dto.CheckFeatureDto;
import org.tg4j.tg4jcore.modules.cases.check_feature.dto.Context;


@RestController()
@RequestMapping("features")
@Tag(name="Features")
public class CheckFeatureUseCaseController {

    private final CheckFeatureService featureService;

    public CheckFeatureUseCaseController(CheckFeatureService featureService) {
        this.featureService = featureService;
    }

    @PostMapping(path="/check", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Boolean> features(@RequestBody CheckFeatureDto feature, @RequestHeader HttpHeaders headers) throws Exception  {
        boolean check = featureService.check(feature, new Context().setCheckFeatureDto(feature).setHeaders(headers));
        return new ResponseEntity<>(check, HttpStatus.OK);
    }

}

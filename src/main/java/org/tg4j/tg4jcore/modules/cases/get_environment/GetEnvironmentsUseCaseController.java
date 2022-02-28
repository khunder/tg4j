package org.tg4j.tg4jcore.modules.cases.get_environment;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tg4j.tg4jcore.modules.cases.get_environment.dto.FindEnvironmentsDto;
import org.tg4j.tg4jcore.modules.domain.model.Environment;

import java.util.List;

@RestController()
@RequestMapping("environment")
@Tag(name="Environment")
public class GetEnvironmentsUseCaseController {

    private final GetEnvironmentService getEnvironmentService;

    public GetEnvironmentsUseCaseController(GetEnvironmentService getEnvironmentService) {
        this.getEnvironmentService = getEnvironmentService;
    }

    @GetMapping()
    public List<Environment> getEnvironments(@RequestParam(required = false, defaultValue = "") String name) {
        return this.getEnvironmentService.getEnvironments(new FindEnvironmentsDto().setName(name));
    }

}

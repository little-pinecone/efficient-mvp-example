package in.keepgrowing.efficientmvpexample.landingpage.presentation.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/landing", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Landing page")
public class LandingPageController {

    @GetMapping
    @Operation(summary = "Get test data for landing page")
    public String getLandingPageData() {
        return "Landing page works!";
    }
}

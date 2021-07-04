package in.keepgrowing.efficientmvpexample.landingpage.presentation.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/home", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Home page")
public class HomePageController {

    @GetMapping
    @Operation(summary = "Get test data for home page")
    public String getHomePageData() {
        return "Home page works!";
    }
}

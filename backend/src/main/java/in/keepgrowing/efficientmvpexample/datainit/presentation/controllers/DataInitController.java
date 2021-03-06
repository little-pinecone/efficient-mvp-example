package in.keepgrowing.efficientmvpexample.datainit.presentation.controllers;

import in.keepgrowing.efficientmvpexample.datainit.services.DataInitializer;
import in.keepgrowing.efficientmvpexample.shared.presentation.controllers.ApiControllerPaths;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Data init", description = "Initializes db with random fake data, requires the 'init' profile")
@RestController
@RequestMapping(value = ApiControllerPaths.API + DataInitControllerPaths.INIT,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Profile("init")
public class DataInitController {

    private final DataInitializer dataInitializer;

    public DataInitController(DataInitializer dataInitializer) {
        this.dataInitializer = dataInitializer;
    }

    @Operation(summary = "Generates random data and saves it in db")
    @GetMapping
    public ResponseEntity<Long> init(
            @RequestParam(value = "seed", required = false, defaultValue = "987") Long seed,
            @RequestParam(value = "how-many-books", required = false, defaultValue = "20") Integer howManyBooks) {
        return ResponseEntity.ok(dataInitializer.init(seed, howManyBooks));
    }
}

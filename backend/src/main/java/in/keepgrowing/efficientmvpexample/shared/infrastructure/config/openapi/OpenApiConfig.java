package in.keepgrowing.efficientmvpexample.shared.infrastructure.config.openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@OpenAPIDefinition
@AllArgsConstructor
public class OpenApiConfig {

    private static final String CODE_GENERATION_PROFILE = "angular";
    private static final String SCHEME_NAME = "basicAuth";
    private static final String SCHEME = "basic";

    private final Environment environment;

    @Bean
    public OpenAPI customOpenAPI(OpenApiProperties properties) {
        var openApi = new OpenAPI()
                .info(getInfo(properties));

        if (Arrays.asList(environment.getActiveProfiles()).contains(CODE_GENERATION_PROFILE)) {
            var server = getLocalhostServer();
            openApi.setServers(Collections.singletonList(server));
        }

        addSecurityItem(openApi);

        return openApi;
    }

    private Info getInfo(OpenApiProperties properties) {
        return new Info()
                .title(properties.getProjectTitle())
                .description(properties.getProjectDescription())
                .version(properties.getProjectVersion())
                .license(getLicense());
    }

    private License getLicense() {
        return new License()
                .name("Unlicense")
                .url("https://unlicense.org/");
    }

    private Server getLocalhostServer() {
        var server = new Server();
        server.setUrl("http://localhost:8080");
        return server;
    }

    private void addSecurityItem(OpenAPI openApi) {
        var securityItem = new SecurityRequirement().addList(SCHEME_NAME);
        var components = createComponents();

        openApi
                .addSecurityItem(securityItem)
                .components(components);
    }

    private Components createComponents() {
        var components = new Components();
        components.addSecuritySchemes(SCHEME_NAME, createSecurityScheme());

        return components;
    }

    private SecurityScheme createSecurityScheme() {
        return new SecurityScheme()
                .name(SCHEME_NAME)
                .type(SecurityScheme.Type.HTTP)
                .scheme(SCHEME);
    }
}

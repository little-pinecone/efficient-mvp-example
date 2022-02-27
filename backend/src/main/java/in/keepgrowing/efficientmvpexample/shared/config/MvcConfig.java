package in.keepgrowing.efficientmvpexample.shared.config;

import in.keepgrowing.efficientmvpexample.EfficientMvpExampleApplication;
import lombok.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.io.IOException;
import java.util.function.Predicate;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public static final String API_PREFIX = "api";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .resourceChain(true)
                .addResolver(new PathResourceResolver() {
                    @Override
                    protected Resource getResource(@NonNull String resourcePath, @NonNull Resource location)
                            throws IOException {
                        Resource requestedResource = location.createRelative(resourcePath);

                        return requestedResource.exists() && requestedResource.isReadable() ? requestedResource
                                : new ClassPathResource("/static/index.html");
                    }
                });
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix(API_PREFIX, createPredicateForControllers());
    }

    private Predicate<Class<?>> createPredicateForControllers() {
        String packageName = EfficientMvpExampleApplication.class.getPackageName();

        return HandlerTypePredicate
                .forBasePackage(packageName)
                .and(HandlerTypePredicate.forAnnotation(RestController.class));
    }
}

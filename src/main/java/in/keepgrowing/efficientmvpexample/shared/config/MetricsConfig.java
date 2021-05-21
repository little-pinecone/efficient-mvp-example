package in.keepgrowing.efficientmvpexample.shared.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import org.springframework.boot.actuate.metrics.data.MetricsRepositoryMethodInvocationListener;
import org.springframework.boot.actuate.metrics.data.RepositoryTagsProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class MetricsConfig {

    /**
     * Temporary fix for the 2.5.0 - spring-boot-starter-data-jpa breaks metrics #26630 issue
     *
     * @see <a href="https://github.com/spring-projects/spring-boot/issues/26630">Issue #26630</a>
     */
    @Bean
    public static MetricsRepositoryMethodInvocationListener metricsRepositoryMethodInvocationListener(
            MetricsProperties metricsProperties, @Lazy MeterRegistry registry, RepositoryTagsProvider tagsProvider) {
        MetricsProperties.Data.Repository properties = metricsProperties.getData().getRepository();
        return new MetricsRepositoryMethodInvocationListener(registry, tagsProvider, properties.getMetricName(),
                properties.getAutotime());
    }
}

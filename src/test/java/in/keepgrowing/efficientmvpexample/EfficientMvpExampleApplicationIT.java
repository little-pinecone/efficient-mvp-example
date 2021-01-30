package in.keepgrowing.efficientmvpexample;

import in.keepgrowing.efficientmvpexample.containers.PostgresContainerWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
class EfficientMvpExampleApplicationIT {

    @Container
    public static PostgresContainerWrapper postgres = PostgresContainerWrapper.getContainer();

    @DynamicPropertySource
    static void postgreSQLProperties(DynamicPropertyRegistry registry) {
        postgres.setPostgreSQLProperties(registry);
    }

    @Test
    void contextLoads() {
    }
}

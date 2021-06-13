package in.keepgrowing.efficientmvpexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class EfficientMvpExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(EfficientMvpExampleApplication.class, args);
    }

}

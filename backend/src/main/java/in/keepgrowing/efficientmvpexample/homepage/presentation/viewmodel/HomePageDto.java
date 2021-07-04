package in.keepgrowing.efficientmvpexample.homepage.presentation.viewmodel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "Home")
public class HomePageDto {

    private String body;
}

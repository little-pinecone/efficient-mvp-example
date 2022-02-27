package in.keepgrowing.efficientmvpexample.books.adapters.driving.api.http.model.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "Book")
public class BookResponse {

    private Long id;
    private String title;
}

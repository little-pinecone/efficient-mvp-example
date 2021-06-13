package in.keepgrowing.efficientmvpexample.book.presentation.viewmodel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "Book")
public class BookDto {

    private Long id;
    private String title;
}

package in.keepgrowing.efficientmvpexample.book.presentation.viewmodel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
@Schema(name = "Book")
public class BookDto {

    private String title;
}

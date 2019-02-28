package bookStore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;
@AllArgsConstructor
@Getter
public class Book {
    public int id;
    public String title;
    public int isbn;
    public int year;
    public String bazel;
    public List<Author> authorsOfBook;
    public Category category;
    public static final String FILE = "A:\\java\\books1.csv";

    @Override
    public String toString() {
        return "<><><><><><><><><><><><><>><><><><><><>"+
                "\n Book: " +
                "\n id: " + id +
                "\n title: " + title +
                "\n isbn: " + isbn +
                "\n year: " + year +
                "\n bazel: " + bazel +
                "\n authorsOfBook:" + authorsOfBook +
                "\n category: " + category +
                "<><><><><><><><><><><><><>><><><><><><>";
    }
}

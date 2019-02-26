package bookStore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Book {
    int id;
    String title;
    int isbn;
    int year;
    String bazel;
    List<Author> authorsOfBook;
    Category category;
    public static final String FILE = "A:\\java\\books1.csv";

    public Book(int id, String title, int isbn, int year, String bazel, List<Author> authorsOfBook, Category category) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.year = year;
        this.bazel = bazel;
        this.authorsOfBook = authorsOfBook;
        this.category = category;
    }


}

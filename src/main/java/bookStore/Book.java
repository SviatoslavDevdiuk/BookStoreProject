package bookStore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {

    String title;
    int isbn;
    int year;
    static String file = "A:\\java\\\\books.csv";

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn=" + isbn +
                ", year=" + year +
                '}';
    }

    public Book(String title, int isbn, int year) {
        this.title = title;
        this.isbn = isbn;
        this.year = year;
    }

}

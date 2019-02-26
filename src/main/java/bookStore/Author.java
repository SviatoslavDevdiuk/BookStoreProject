package bookStore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Author {
    int id;
    String fullName;
    int age;
    public static final String FILE = "A:\\java\\\\authors.csv";

    public Author(int id, String fullName, int age) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
    }

}

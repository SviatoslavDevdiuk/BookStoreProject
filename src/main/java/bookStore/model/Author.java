package bookStore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Author {
   public int id;
   public String fullName;
   public int age;
    public static final String FILE = "A:\\java\\authors.csv";

    @Override
    public String toString() {
        return  "<><><><><><><><><><><><><>><><><><><><>" +
                "\n<> Author:" +
                "\n<> id: " + id +
                "\n<> fullName: " + fullName +
                "\n<> age: " + age +
                "\n<><><><><><><><><><><><><>><><><><><><>\n";

    }
}

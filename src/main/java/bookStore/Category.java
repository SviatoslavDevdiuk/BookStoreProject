package bookStore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Category {
    int id;
    String name;
    int priority;
    public static final String FILE = "A:\\java\\categories.csv";

    public Category(int id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

}

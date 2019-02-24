package bookStore;

import lombok.ToString;

@ToString
public class Category {
    int id;
    String name;
    int priority;
    public static String file = "A:\\java\\\\categories.csv";

    public Category(int id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

}

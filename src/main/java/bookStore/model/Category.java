package bookStore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Category {
    public int id;
    public String name;
    public int priority;
    public static final String FILE = "A:\\java\\categories.csv";

}

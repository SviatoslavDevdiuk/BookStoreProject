package bookStore;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SCVUtility {

    private static SCVUtility instance;

    private SCVUtility() {

    }

    public static SCVUtility getInstance() {
        if (instance == null) {
            synchronized (SCVUtility.class) {
                if (instance == null) {
                    instance = new SCVUtility();
                }
            }
        }
        return instance;
    }

    List<String[]> data = new ArrayList<>();
    List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        for (Book book : books)
            System.out.println(book);
    }

    public List<String[]> read(String file) {

        String dataRaw;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((dataRaw = br.readLine()) != null) {
                String[] dataInProces = dataRaw.split(";");
                data.add(dataInProces);
                Book book = new Book(dataInProces[0], Integer.parseInt(dataInProces[1]), Integer.parseInt(dataInProces[2]));
                addBook(book);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }


}

package bookStore;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SCVUtility {

    private static SCVUtility instance;
    List<Book> books = new ArrayList<>();
    List<Author> authors = new ArrayList<>();
    List<Category> categories = new ArrayList<>();

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

    public Category getCategoryById(int idFromFile) {
        for (Category category : categories) {
            if (category.id == idFromFile) {
                return category;
            }
        }
        return null;
    }

    public List<Author> getAuthorsById(List<Integer> authorsId) {
        List<Author> authorsOfBook = new ArrayList<>();
        for (Integer integer : authorsId) {
            for (Author author : authors) {
                if (author.id == integer) {
                    authorsOfBook.add(author);
                }
            }
        }
        return authorsOfBook;
    }

    public void showAutors() {
        for (Author author : authors)
            System.out.println(author);
    }

    public void showBooks() {
        for (Book book : books)
            System.out.println(book);
    }

    public void showCategories() {
        for (Category category : categories)
            System.out.println(category);
    }

    public void readAutors(String file) {
        String dataRaw;

        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                while ((dataRaw = br.readLine()) != null) {
                    String[] dataInProces = dataRaw.split(";");
                    Author author = new Author(Integer.parseInt(dataInProces[0]), dataInProces[1], Integer.parseInt(dataInProces[2]));
                    authors.add(author);

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void reafFiles(DataType dataType, String file) {
        switch (dataType) {
            case AUTHOR:
                readAutors(Author.file);
                break;
            case CATEGORY:
                readCategories(Category.file);
                break;
            case BOOK:
                readBooks(Book.file);
                break;
        }

    }

    public void readCategories(String file) {
        String dataRaw;

        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                while ((dataRaw = br.readLine()) != null) {
                    String[] dataInProces = dataRaw.split(";");
                    Category category = new Category(Integer.parseInt(dataInProces[0]),
                            dataInProces[1], Integer.parseInt(dataInProces[2]));
                    categories.add(category);

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readBooks(String file) {
        String dataRaw;

        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                while ((dataRaw = br.readLine()) != null) {
                    List<Integer> authorsId = new ArrayList<>();
                    String[] dataInProces = dataRaw.split(";");

                    for (String i : dataInProces[5].split(",")) {
                        authorsId.add(Integer.parseInt(i));
                    }

                    Book book = new Book(Integer.parseInt(dataInProces[0]), dataInProces[1],
                            Integer.parseInt(dataInProces[2]), Integer.parseInt(dataInProces[3]),
                            dataInProces[4], getAuthorsById(authorsId),
                            getCategoryById((Integer.parseInt(dataInProces[6]))));
                    books.add(book);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

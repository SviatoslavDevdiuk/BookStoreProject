package bookStore;

import bookStore.model.Author;
import bookStore.model.Book;
import bookStore.model.Category;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SCVUtility {

    private static SCVUtility instance;
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    private String dataRaw;
    Logger logger = LogManager.getLogger(SCVUtility.class.getName());

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

    private Category getCategoryById(int idFromFile) {
        for (Category category : categories) {
            if (category.id == idFromFile) {
                return category;
            }
        }
        return null;
    }

    private List<Author> getAuthorsById(List<Integer> authorsId) {
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

    public void readFiles(DataType dataType, String file) {


            switch (dataType) {
                case AUTHOR:
                    org.apache.log4j.BasicConfigurator.configure();
                    readAuthors(file);
                    break;
                case CATEGORY:
                    readCategories(file);
                    break;
                case BOOK:
                    readBooks(file);
                    break;
            }


    }

    public void showAuthors() {

        for (Author author : authors) {
            System.out.println(author.id + " " + author.fullName);
        }
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println(book.id + " " + book.title);
        }
    }

    public void showCategories() {
        for (Category category : categories) {
            System.out.println(category.id + " " + category.name);
        }
    }

    private void readAuthors(String file) {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((dataRaw = br.readLine()) != null) {
                String[] dataInProces = dataRaw.split(";");
                Author author = new Author(Integer.parseInt(dataInProces[0]), dataInProces[1], Integer.parseInt(dataInProces[2]));
                authors.add(author);
            }
        } catch (IOException e) {
            logger.log(Level.ERROR,"There is a problem with reading AUTHORS file");
        }
    }

    private void readCategories(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((dataRaw = br.readLine()) != null) {
                String[] dataInProces = dataRaw.split(";");
                Category category = new Category(Integer.parseInt(dataInProces[0]),
                        dataInProces[1], Integer.parseInt(dataInProces[2]));
                categories.add(category);
            }
        } catch (IOException e) {
            logger.log(Level.ERROR,"There is a problem with reading CATEGORY file");
        }
    }

    private void readBooks(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((dataRaw = br.readLine()) != null) {
                List<Integer> authorsId = new ArrayList<>();
                String[] dataInProces = dataRaw.split(";");
                for (String authorIDs : dataInProces[5].split(",")) {
                    authorsId.add(Integer.parseInt(authorIDs));
                }
                Book book = new Book(Integer.parseInt(dataInProces[0]), dataInProces[1],
                        Integer.parseInt(dataInProces[2]), Integer.parseInt(dataInProces[3]),
                        dataInProces[4], getAuthorsById(authorsId),
                        getCategoryById((Integer.parseInt(dataInProces[6]))));
                books.add(book);
            }
        } catch (IOException e) {
            logger.log(Level.ERROR,"There is a problem with reading BOOK file");
        }
    }

    public void filterByAuthor(int authorId) {
        List<Book> booksOfTheAuthor = new ArrayList<>();
        for (Book book : books) {
            for (Author author : book.authorsOfBook) {
                if (author.id == authorId) {
                    booksOfTheAuthor.add(book);
                }
            }
        }
        booksOfTheAuthor.forEach(book -> System.out.println(book.title));
    }

    public void filterByCategory(int categoryId) {
        List<Book> booksOfTheCategory = new ArrayList<>();
        for (Book book : books) {
            if (book.category.id == categoryId) {
                booksOfTheCategory.add(book);
            }
        }
        booksOfTheCategory.forEach(book -> System.out.println(book.title));
    }
}

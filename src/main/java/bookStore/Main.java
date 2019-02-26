package bookStore;


public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        SCVUtility scvUtility = SCVUtility.getInstance();
        scvUtility.readFiles(DataType.AUTHOR, Author.FILE);
        scvUtility.readFiles(DataType.CATEGORY, Category.FILE);
        scvUtility.readFiles(DataType.BOOK, Book.FILE);
        scvUtility.showBooks();
        menu.showMenu();
        menu.userInput();
    }
}

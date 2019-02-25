package bookStore;


public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        SCVUtility scvUtility = SCVUtility.getInstance();
        scvUtility.reafFiles(DataType.AUTHOR, Author.file);
        scvUtility.reafFiles(DataType.CATEGORY, Category.file);
        scvUtility.reafFiles(DataType.BOOK, Book.file);
//        scvUtility.showCategories();
//        scvUtility.readCategories(Category.file);
        scvUtility.showAutors();
        scvUtility.showCategories();
        scvUtility.showBooks();
        menu.showMenu();
        menu.userInput();
    }
}

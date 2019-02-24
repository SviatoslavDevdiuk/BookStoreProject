package bookStore;


public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        SCVUtility scvUtility = SCVUtility.getInstance();
//        scvUtility.readBooks(Book.file);
        scvUtility.readAutors(Author.file);
        scvUtility.readCategories(Category.file);
        scvUtility.readBooks(Book.file);

        menu.showMenu();
        menu.userInput();
    }
}

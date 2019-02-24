package bookStore;


public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
       SCVUtility scvUtility =  SCVUtility.getInstance();
        scvUtility.read(Book.file);
        menu.showMenu();
        menu.userInput();
    }
}

package bookStore;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    SCVUtility scvUtility = SCVUtility.getInstance();

    public void showMenu() {
        System.out.println("####################\n" +
                "1.Contact us\n2.Show available books\n3.Exit App\n####################");
    }


    public void showContact() {
        System.out.println("contactBookstore@mail.com");
    }

    public void userInput() {
        scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        while (true) {
            if (i == 1) {
                showContact();
            } else if (i == 2){
                scvUtility.showBooks();
            }
            else if (i ==3){
                System.out.println("Good bye!");
                break;
            }
            i = scanner.nextInt();
        }

    }
}



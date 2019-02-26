package bookStore;

import java.util.Scanner;

public class Menu {
    SCVUtility scvUtility = SCVUtility.getInstance();

    public void showMenu() {
        System.out.println("#########################\n" +
                "1.Contact us\n2.Show available books\n3.Show books by author\n4.Show books by category" +
                "\n5.Exit App\n#########################");
    }


    public void showContact() {
        System.out.println("contactBookstore@mail.com");
    }

    public void userInput() {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        while (true) {
            if (i == 1) {
                showContact();
            } else if (i == 2) {
                scvUtility.showBooks();
            } else if (i == 3) {
                System.out.println("Choose author");
                scvUtility.showAuthors();
                int j = scanner.nextInt();
                scvUtility.getBookByAuthorId(j);
            } else if (i == 4) {
                System.out.println("Choose category");
                scvUtility.showCategories();
                int j = scanner.nextInt();
                scvUtility.sortByCategory(j);
            } else if (i == 5) {
                System.out.println("Good bye!");
                break;
            }
            i = scanner.nextInt();
        }

    }
}



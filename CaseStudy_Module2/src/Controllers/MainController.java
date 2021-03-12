package Controllers;

import java.util.Scanner;

public class MainController {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();


    }

    private static void displayMainMenu() {
        System.out.println("     \n" +
                "        1.  Add New Services\n" +
                "        2. Show Services\n" +
                "        3. Add New Customer\n" +
                "        4. Show Information of Customer\n" +
                "        5. Add New Booking\n" +
                "        6. Show Information of Employee\n" +
                "        7. Exit");
        System.out.println("Enter a number :");
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                System.exit(0);
                break;
        }
    }
}

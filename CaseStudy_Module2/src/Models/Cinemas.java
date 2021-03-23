package Models;

import Commoms.CheckClass;
import Commoms.FileUtils;
import Controllers.MainController;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Cinemas {
    static Scanner sc = new Scanner(System.in);
    static Queue<String> listCustomerCineams = new LinkedList<>();
    static int ticket = 5;

    public static void bookingCinemas() throws IOException {
        System.out.println("1.Chọn customer muốn book vé. \n" +
                "2.Danh sách customer đã book. \n" +
                "3.Back to Menu. \n" +
                "4.Exit.");
        int choose = CheckClass.checkNumber(4);
        switch (choose) {
            case 1:
                List<String> listCustomer = FileUtils.readFile("CaseStudy_Module2/src/Data/Customer.csv");
                if (listCustomer.size() > 0) {
                    for (int index = 0; index < listCustomer.size(); index++) {
                        String[] array = listCustomer.get(index).split(",");
                        System.out.println("Tên Customer: " + array[0] +
                                " , CMND: " + array[3] +
                                " , SĐT: " + array[4]);
                    }
                    System.out.println("Nhập CMND Customer muốn book vé");
                    String IDCustomer = sc.nextLine();

                    int index;
                    for (index = 0; index < listCustomer.size(); index++) {
                        String[] array = listCustomer.get(index).split(",");
                        if (IDCustomer.equals(array[3])) {
                            listCustomerCineams.add(IDCustomer);
                            ticket--;
                            break;
                        }
                    }
                    if (index == listCustomer.size()) {
                        System.out.println("--------------------------------------");
                        System.out.println("CMND Không tồn tại , vui lòng chọn lại");
                        System.out.println("--------------------------------------");
                    }
                } else {
                    if (ticket == 0) {
                        System.out.println(" Vé đã hết ");
                    } else {
                        System.out.println("Chưa có customer trong danh sách !");
                    }
                }
                bookingCinemas();
                break;
            case 2:
                showBooking();
                bookingCinemas();
                break;
            case 3:
                MainController.displayMainMenu();
                break;
            case 4:
                System.exit(0);
                break;
        }
    }

    public static void showBooking() {
        if (listCustomerCineams.size() > 0) {
            System.out.println("-------------------------------------------");
            System.out.println("ID Customer đã book " + listCustomerCineams);
            System.out.println("-------------------------------------------");
        } else {
            System.out.println("-------------------------------------------");
            System.out.println("Chưa có Customer book vé !");
            System.out.println("-------------------------------------------");
        }
    }
}

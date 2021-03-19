package Controllers;

import Commoms.CheckClass;
import Commoms.FileUtils;
import Models.House;
import Models.Room;
import Models.ServicesManager;
import Models.Villa;
import Models.customer.CustomerManager;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        displayMainMenu();


    }

    public static void displayMainMenu() throws IOException {
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
                ServicesManager.addNewService();
                break;
            case 2:
                ServicesManager.showService();
                break;
            case 3:
                CustomerManager.addNewCustomer();
                break;
            case 4:
                CustomerManager.showInformationCustomer();
                displayMainMenu();
                break;
            case 5:
                addNewBooking();
                break;
            case 6:
                break;
            case 7:
                System.exit(0);
                break;
        }
    }

    public static void addNewBooking() throws IOException {
        System.out.println("1.Danh sách Customer Booking \n" +
                "2.Back to Menu \n" +
                "3.Exit");
        int chooseNumber = CheckClass.checkNumber(3);
        switch (chooseNumber) {
            case 1:
                List<String> listNameCustomer = FileUtils.readFile("CaseStudy_Module2/src/Data/Customer.csv");
                int count = 1;
                String idBookingCustomer = null;
                if (listNameCustomer.size() > 0) {
                    for (int index = 0; index < listNameCustomer.size(); index++) {
                        String[] array = listNameCustomer.get(index).split(",");
                        System.out.println(count + " . Tên Customer: " + array[0] +
                                ", ID : " + array[3]);
                        count++;
                    }
                    int chooseCustomerNumber = CheckClass.checkNumber(count - 1);
                    String[] arrayChooseCustomer = listNameCustomer.get(chooseCustomerNumber - 1).split(",");
                    idBookingCustomer = arrayChooseCustomer[3];
                } else {
                    System.out.println("------------------------------------------");
                    System.out.println("Chưa có Customer , vui lòng thêm Customer");
                    System.out.println("------------------------------------------");
                    displayMainMenu();
                }
                System.out.println("    1. Booking Villa\n" +
                        "    2. Booking House\n" +
                        "    3. Booking Room");
                int chooseBooking = CheckClass.checkNumber(3);
                switch (chooseBooking) {
                    case 1:
                        int countVilla = 1;
                        List<String> listVilla = FileUtils.readFile("CaseStudy_Module2/src/Data/Villa.csv");
                        if (listVilla.size() > 0) {
                            for (String elementVilla : listVilla) {
                                String[] villaArray = elementVilla.split(",");
                                Villa villa = new Villa(villaArray[0], villaArray[1], Double.parseDouble(villaArray[2]), Double.parseDouble(villaArray[3]), Integer.parseInt(villaArray[4]),
                                        villaArray[5], villaArray[6], Integer.parseInt(villaArray[7]), Double.parseDouble(villaArray[8]));
                                System.out.println(countVilla + " " + villa.showInfo());

                                countVilla++;
                            }
                            int chooseVilla = CheckClass.checkNumber(countVilla - 1);
                            String[] array = listVilla.get(chooseVilla - 1).split(",");
                            String idBookingVilla = idBookingCustomer + " , " + array[0];
                            FileUtils.writeFileBooking("CaseStudy_Module2/src/Data/Booking.csv", (idBookingVilla));
                            displayMainMenu();
                        } else {
                            System.out.println("----------------------------------------");
                            System.out.println("Hiện chưa có Villa nào trong danh sách!");
                            System.out.println("----------------------------------------");
                        }
                        displayMainMenu();
                        break;

                    case 2:
                        int countHouse = 1;
                        List<String> listHouse = FileUtils.readFile("CaseStudy_Module2/src/Data/House.csv");
                        if (listHouse.size() > 0) {
                            for (String elemntHouse : listHouse) {
                                String[] houseArray = elemntHouse.split(",");
                                House house = new House(houseArray[0], houseArray[1], Double.parseDouble(houseArray[2]),
                                        Integer.parseInt(houseArray[3]), Integer.parseInt(houseArray[4]), houseArray[5],
                                        houseArray[6], Integer.parseInt(houseArray[7]));
                                System.out.println(countHouse + " " + house.showInfo());
                                countHouse++;
                            }
                            int chooseHouse = CheckClass.checkNumber(countHouse - 1);
                            String arrayHouse[] = listHouse.get(chooseHouse - 1).split(",");
                            String idBookingHouse = idBookingCustomer + " , " + arrayHouse[0];
                            FileUtils.writeFileBooking("CaseStudy_Module2/src/Data/Booking.csv", (idBookingHouse));
                            displayMainMenu();
                        } else {
                            System.out.println("----------------------------------------");
                            System.out.println("Hiện chưa có Villa nào trong danh sách!");
                            System.out.println("----------------------------------------");
                        }
                        displayMainMenu();
                        break;
                    case 3:
                        int countRoom = 1;
                        List<String> listRoom = FileUtils.readFile("CaseStudy_Module2/src/Data/Room.csv");
                        if (listRoom.size() > 0) {
                            for (String elementRoom : listRoom) {
                                String[] roomArray = elementRoom.split(",");
                                Room room = new Room(roomArray[0], roomArray[1], Double.parseDouble(roomArray[2]), Double.parseDouble(roomArray[3]),
                                        Integer.parseInt(roomArray[4]), roomArray[5], roomArray[6]);
                                System.out.println(countRoom + " " + room.showInfo());
                                countRoom++;
                            }
                            int chooseRoom = CheckClass.checkNumber(countRoom - 1);
                            String[] roomArray = listRoom.get(chooseRoom - 1).split(",");
                            String idBookingRoom = idBookingCustomer + " ' " + roomArray[0];
                            FileUtils.writeFileBooking("CaseStudy_Module2/src/Data/Booking.csv", (idBookingRoom));
                            displayMainMenu();
                        } else {
                            System.out.println("----------------------------------------");
                            System.out.println("Hiện chưa có Villa nào trong danh sách!");
                            System.out.println("----------------------------------------");
                        }
                        displayMainMenu();
                        break;
                }
            case 2:
                displayMainMenu();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
}

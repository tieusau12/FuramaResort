package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicesManager {
    public static Scanner sc = new Scanner(System.in);

    public static void addNewService() {
        System.out.println("\n" +
                "    1. Add New Villa\n" +
                "    2. Add New House\n" +
                "    3. Add New Room\n" +
                "    4. Back to menu\n" +
                "    5. Exit");
        System.out.println(" Enter a number : ");
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
                System.exit(0);
                break;
        }
    }

    public List<String> addNewServices() {
        List<String> servicesList = new ArrayList<>();
        String idServices;
        String nameServices;
        String areaServices;
        String priceServices;
        String accompanyPeople;
        String typeOfRental;
        System.out.println("Enter services ID : ");
        idServices = sc.nextLine();
        servicesList.add(idServices);
        System.out.println("Enter services name : ");
        nameServices = sc.nextLine();
        servicesList.add(nameServices);
        System.out.println("Enter area of using : ");
        areaServices = sc.nextLine();
        servicesList.add(areaServices);
        System.out.println("Enter price of rental :");
        priceServices = sc.nextLine();
        servicesList.add(priceServices);
        System.out.println("Enter max of accompany people :");
        accompanyPeople = sc.nextLine();
        servicesList.add(accompanyPeople);
        System.out.println("Enter type of rental :");
        typeOfRental = sc.nextLine();
        servicesList.add(typeOfRental);
        return servicesList;
    }

    private void addNewVilla() {
        List<String> newVillaList = addNewServices();
    String typeOfRoom;
    String roomAmenities;
    String areaOfPool;
    String floors;
        System.out.println("Enter type of room : ");
        typeOfRoom= sc.nextLine();
        newVillaList.add(typeOfRoom);
        System.out.println("Enter a amenities of room :");
        roomAmenities =sc.nextLine();
        newVillaList.add(roomAmenities);
        System.out.println("Enter area of pool :");
        areaOfPool =sc.nextLine();
        newVillaList.add(areaOfPool);
        System.out.println("Enter floors of room");
        floors = sc.nextLine();
        newVillaList.add(floors);
        String[] villaInfo = newVillaList.toArray(new String[0]);
//        Villa villa = new Villa(villaInfo);
    }
}

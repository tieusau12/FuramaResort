package Models;

import Controllers.MainController;
import commom.CheckClass;
import commom.FileUtils;
import commom.ValidateService;

import java.io.IOException;
import java.util.*;

public class ServicesManager {
    public static Scanner scanner = new Scanner(System.in);

    public static void addNewService() throws IOException {
        System.out.println("\n" +
                "    1. Add New Villa\n" +
                "    2. Add New House\n" +
                "    3. Add New Room\n" +
                "    4. Back to menu\n" +
                "    5. Exit");
        System.out.println(" Enter a number : ");
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                addNewVilla();
                break;
            case 2:
                addNewHouse();
                break;
            case 3:
                addNewRoom();
                break;
            case 4:
                MainController.displayMainMenu();
                break;
            case 5:
                System.exit(0);
                break;
        }
    }

    private static void addNewRoom() throws IOException {
        List<String> checkIDRoom = FileUtils.readFile("E:\\FuramaResort\\CaseStudy_Module2\\src\\Data\\Room.csv");
        ValidateService validateServiceRoom = new ValidateService();
        boolean flag;
        String idRoom;
        String nameRoom;
        double areaOfRoom;
        int accompanyPeopleRoom;
        double priceRoom;
        String typeOfRentalRoom;
        String freeService;

        System.out.println("ID Room muốn tạo(ví dụ SVRO-YYYY (Y là số 0-9): ");

        do {
            flag = true;
            idRoom = scanner.nextLine();
            if (!validateServiceRoom.validateIdRoom(idRoom)) {
                System.out.println("Nhập đúng định dạng SVRO-YYYY (Y là số 0-9)");
                flag = false;
            }

            for (int index = 0; index < checkIDRoom.size(); index++) {
                String[] arrayVilla = checkIDRoom.get(index).split(",");
                if (arrayVilla[0].equals(idRoom)) {
                    System.out.println("ID đã tồn tại , vui lòng nhập lại ID!");
                    flag = false;
                }
            }
        } while (!flag);

        System.out.println("Tên Room: ");

        do {
            flag = true;
            nameRoom = scanner.nextLine();
            if (!validateServiceRoom.validateNameService(nameRoom)) {
                System.out.println("Chữ cái đầu phải viết hoa , chỉ chứa ký tự bình thường!");
                flag = false;
            }
        } while (!flag);

        System.out.println("Diện tích Room: ");

        do {
            flag = true;
            areaOfRoom = CheckClass.checkNumber(150);
            if (areaOfRoom < 30 || areaOfRoom > 150) {
                System.out.println("Diện tích Room phải lớn hơn 30m2 và nhỏ hơn 150m2");
                flag = false;
            }
        } while (!flag);


        System.out.println("Kiểu cho thuê: ");
        do {
            typeOfRentalRoom = scanner.nextLine();
            flag = CheckClass.checkTypeRental(typeOfRentalRoom);
        } while (!flag);


        System.out.println("Sức chứa Room: ");
        accompanyPeopleRoom = CheckClass.checkNumber(7);
        System.out.println("Dịch vụ miễn phí(Ăn sáng hoặc ăn tối): ");
        do {
            freeService = scanner.nextLine();
            if (freeService.equals("Ăn sáng") || freeService.equals("Ăn tối")) {
                flag = true;
            } else {
                System.out.println("Chọn miễn phí Ăn sáng hoặc Ăn tối");
                flag = false;
            }
        } while (!flag);

        priceRoom = CheckClass.checkPrice();

        Room room = new Room(idRoom, nameRoom, areaOfRoom, priceRoom, accompanyPeopleRoom, typeOfRentalRoom, freeService);
        FileUtils.writeFile("E:\\FuramaResort\\CaseStudy_Module2\\src\\Data\\Room.csv", room);
        addNewService();
    }

    private static void addNewHouse() throws IOException {
        List<String> checkIDHouse = FileUtils.readFile("E:\\FuramaResort\\CaseStudy_Module2\\src\\Data\\House.csv");
        ValidateService validateServiceHouse = new ValidateService();
        boolean flag;
        String idHouse;
        String nameHouse;
        double areaOfHouse;
        int floorsOfHouse;
        int accompanyPeopleHouse;
        double priceHouse;
        String typeOfRentalHouse;
        String typeOfRoomHouse;

        System.out.println("ID House muốn tạo(ví dụ SVHO-YYYY (Y là số 0-9): ");

        do {
            flag = true;
            idHouse = scanner.nextLine();
            if (!validateServiceHouse.validateIdHouse(idHouse)) {
                System.out.println("Nhập đúng định dạng SVHO-YYYY (Y là số 0-9)");
                flag = false;
            }

            for (int index = 0; index < checkIDHouse.size(); index++) {
                String[] arrayVilla = checkIDHouse.get(index).split(",");
                if (arrayVilla[0].equals(idHouse)) {
                    System.out.println("ID đã tồn tại , vui lòng nhập lại ID!");
                    flag = false;
                }
            }
        } while (!flag);

        System.out.println("Tên House: ");

        do {
            flag = true;
            nameHouse = scanner.nextLine();
            if (!validateServiceHouse.validateNameService(nameHouse)) {
                System.out.println("Chữ cái đầu phải viết hoa , chỉ chứa ký tự bình thường!");
                flag = false;
            }
        } while (!flag);

        System.out.println("Diện tích House: ");

        do {
            flag = true;
            areaOfHouse = CheckClass.checkNumber(400);
            if (areaOfHouse < 30 || areaOfHouse > 400) {
                System.out.println("Diện tích House phải lớn hơn 30m2 và nhỏ hơn 400m2");
                flag = false;
            }
        } while (!flag);


        System.out.println("Số tầng House: ");
        floorsOfHouse = CheckClass.checkNumber(5);

        System.out.println("Kiểu cho thuê: ");
        do {
            typeOfRentalHouse = scanner.nextLine();
            flag = CheckClass.checkTypeRental(typeOfRentalHouse);
        } while (!flag);

        System.out.println("Loại phòng: ");
        do {
            typeOfRoomHouse = scanner.nextLine();
            flag = CheckClass.checkTypeRoom(typeOfRoomHouse);
        } while (!flag);

        System.out.println("Sức chứa House: ");
        accompanyPeopleHouse = CheckClass.checkNumber(30);

        priceHouse = CheckClass.checkPrice();
        House house = new House(idHouse, nameHouse, areaOfHouse, priceHouse, accompanyPeopleHouse, typeOfRentalHouse, typeOfRoomHouse, floorsOfHouse);
        FileUtils.writeFile("E:\\FuramaResort\\CaseStudy_Module2\\src\\Data\\House.csv", house);
        addNewService();
    }

    private static void addNewVilla() throws IOException {
        ValidateService validateService = new ValidateService();
        List<String> checkIDVilla = FileUtils.readFile("E:\\FuramaResort\\CaseStudy_Module2\\src\\Data\\Villa.csv");
        boolean flag;
        String idVilla;
        String nameVilla;
        double areaOfVilla;
        double areaPoolVilla;
        int floorsOfVilla;
        int accompanyPeople;
        double priceVilla;
        String typeOfRental;
        String typeOfRoomVilla;
        System.out.println("ID Villa muốn tạo(ví dụ SVVL-YYYY (Y là số 0-9): ");

        do {
            flag = true;
            idVilla = scanner.nextLine();
            if (!validateService.validateIdVilla(idVilla)) {
                System.out.println("Nhập đúng định dạng SVVL-YYYY (Y là số 0-9)");
                flag = false;
            }

            for (int index = 0; index < checkIDVilla.size(); index++) {
                String[] arrayVilla = checkIDVilla.get(index).split(",");
                if (arrayVilla[0].equals(idVilla)) {
                    System.out.println("ID đã tồn tại , vui lòng nhập lại ID!");
                    flag = false;
                }
            }
        } while (!flag);

        System.out.println("Tên Villa: ");

        do {
            flag = true;
            nameVilla = scanner.nextLine();
            if (!validateService.validateNameService(nameVilla)) {
                System.out.println("Chữ cái đầu phải viết hoa , chỉ chứa ký tự bình thường!");
                flag = false;
            }
        } while (!flag);

        System.out.println("Diện tích Villa: ");

        do {
            flag = true;
            areaOfVilla = CheckClass.checkNumber(1000);
            if (areaOfVilla < 30 || areaOfVilla > 1000) {
                System.out.println("Diện tích Villa phải lớn hơn 30m2 và nhỏ hơn 1000m2");
                flag = false;
            }
        } while (!flag);

        System.out.println("Diện tích hồ bơi: ");

        do {
            flag = true;
            areaPoolVilla = CheckClass.checkNumber(100);
            if (areaPoolVilla < 10 || areaPoolVilla > 100) {
                System.out.println("Diện tích Villa phải lớn hơn 10m2 và nhỏ hơn 100m2");
                flag = false;
            }
        } while (!flag);

        System.out.println("Số tầng Villa: ");
        floorsOfVilla = CheckClass.checkNumber(5);

        System.out.println("Kiểu cho thuê: ");
        do {
            typeOfRental = scanner.nextLine();
            flag = CheckClass.checkTypeRental(typeOfRental);
        } while (!flag);

        System.out.println("Loại phòng: ");
        do {
            typeOfRoomVilla = scanner.nextLine();
            flag = CheckClass.checkTypeRoom(typeOfRoomVilla);
        } while (!flag);

        System.out.println("Sức chứa villa: ");
        accompanyPeople = CheckClass.checkNumber(30);

        priceVilla = CheckClass.checkPrice();
        Villa villa = new Villa(idVilla, nameVilla, areaOfVilla, priceVilla, accompanyPeople, typeOfRental, typeOfRoomVilla, floorsOfVilla, areaPoolVilla);
        FileUtils.writeFile("E:\\FuramaResort\\CaseStudy_Module2\\src\\Data\\Villa.csv", villa);
        addNewService();
    }

    public static void showService() throws IOException {
        System.out.println("1. Show all Villa" + "\n"
                + "2. Show all House" + "\n"
                + "3. Show all Room" + "\n"
                + "4. Show all ID Villa Not Duplicate" + "\n"
                + "5. Show all ID House Not Duplicate" + "\n"
                + "6. Show all ID Room Not Duplicate" + "\n"
                + "7. Back to Menu" + "\n"
                + "8. Exit");
        int chooseNumber = CheckClass.checkNumber(8);
        switch (chooseNumber) {
            case 1:
                List<String> listVilla = FileUtils.readFile("src/data/Villa.csv");
                if (listVilla.size() > 0) {
                    for (String index : listVilla) {
                        String[] villaArray = index.split(",");
                        Villa villa = new Villa(villaArray[0], villaArray[1], Double.parseDouble(villaArray[2]), Double.parseDouble(villaArray[3]), Integer.parseInt(villaArray[4]),
                                villaArray[5], villaArray[6], Integer.parseInt(villaArray[7]), Double.parseDouble(villaArray[8]));
                        villa.showInfo();
                    }
                } else {
                    System.out.println("-----------------------------------------------");
                    System.out.println("Hiện chưa có dịch vụ Villa , vui lòng thêm vào !");
                    System.out.println("-----------------------------------------------");
                }
                MainController.displayMainMenu();
                break;
            case 2:
                List<String> listHouse = FileUtils.readFile("src/data/House.csv");
                if (listHouse.size() > 0) {
                    for (String index : listHouse) {
                        String[] houseArray = index.split(",");
                        House house = new House(houseArray[0], houseArray[1], Double.parseDouble(houseArray[2]), Integer.parseInt(houseArray[3]), Integer.parseInt(houseArray[4]), houseArray[5], houseArray[6], Integer.parseInt(houseArray[7]));
                        house.showInfo();
                    }
                } else {
                    System.out.println("-----------------------------------------------");
                    System.out.println("Hiện chưa có dịch vụ House , vui lòng thêm vào !");
                    System.out.println("-----------------------------------------------");
                }
                MainController.displayMainMenu();
                break;
            case 3:
                List<String> listRoom = FileUtils.readFile("src/data/Room.csv");
                if (listRoom.size() > 0) {
                    for (String index : listRoom) {
                        String[] roomArray = index.split(",");
                        Room room = new Room(roomArray[0], roomArray[1], Double.parseDouble(roomArray[2]), Double.parseDouble(roomArray[3]), Integer.parseInt(roomArray[4]), roomArray[5], roomArray[6]);
                        room.showInfo();
                    }
                } else {
                    System.out.println("-----------------------------------------------");
                    System.out.println("Hiện chưa có dịch vụ Room , vui lòng thêm vào !");
                    System.out.println("-----------------------------------------------");
                }
                MainController.displayMainMenu();
                break;
            case 4:
                Set<String> nameVilla = new TreeSet<>();
                List<String> listDisplayNameVilla = FileUtils.readFile("src/data/Villa.csv");
                if (listDisplayNameVilla.size() > 0) {
                    for (String element : listDisplayNameVilla) {
                        String[] array = element.split(",");
                        nameVilla.add(array[1]);
                    }
                    System.out.println("Tên các Villa: " + nameVilla.toString());
                } else {
                    System.out.println("-----------------------------------------------");
                    System.out.println("Hiện chưa có dịch vụ Villa , vui lòng thêm vào !");
                    System.out.println("-----------------------------------------------");
                }
                MainController.displayMainMenu();
                break;
            case 5:
                Set<String> nameHouse = new TreeSet<>();
                List<String> listDisplayNameHouse = FileUtils.readFile("src/data/House.csv");
                if (listDisplayNameHouse.size() > 0) {
                    for (String element : listDisplayNameHouse) {
                        String[] array = element.split(",");
                        nameHouse.add(array[1]);
                    }
                    System.out.println("Tên các House: " + nameHouse.toString());
                } else {
                    System.out.println("-----------------------------------------------");
                    System.out.println("Hiện chưa có dịch vụ House , vui lòng thêm vào !");
                    System.out.println("-----------------------------------------------");
                }
                MainController.displayMainMenu();
                break;
            case 6:
                Set<String> nameRoom = new TreeSet<>();
                List<String> listDisplayNameRoom = FileUtils.readFile("src/data/Room.csv");
                if (listDisplayNameRoom.size() > 0) {
                    for (String element : listDisplayNameRoom) {
                        String[] array = element.split(",");
                        nameRoom.add(array[1]);
                    }
                    System.out.println("Tên các Room: " + nameRoom.toString());
                } else {
                    System.out.println("-----------------------------------------------");
                    System.out.println("Hiện chưa có dịch vụ Room , vui lòng thêm vào !");
                    System.out.println("-----------------------------------------------");
                }
                MainController.displayMainMenu();
                break;
            case 7:
                MainController.displayMainMenu();
                break;
            default:
                break;
        }
    }
}



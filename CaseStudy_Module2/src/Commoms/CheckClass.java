package Commoms;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckClass {
    static Scanner scanner = new Scanner(System.in);

    public static int checkNumber(int maxNumber) {
        boolean flag;
        int chooseNumber = 0;
        do {
            System.out.print("Nhập số muốn chọn (không được quá " + maxNumber + ")" + " : ");
            try {
                flag = true;
                chooseNumber = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Không được nhập chữ!");
                scanner.nextLine();
                flag = false;
            }
        } while (!flag || chooseNumber < 1 || chooseNumber > maxNumber);
        return chooseNumber;

    }

    public static int checkPrice() {
        boolean flag;
        int price = 1;
        do {
            System.out.println("Nhập giá thuê: ");
            try {
                flag = true;
                price = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Không được nhập chữ");
                scanner.nextLine();
                flag = false;
            }
            if (price < 1) {
                System.out.println("Giá cho thuê phải là số dương");
            }
        } while (!flag || price < 1);
        return price;
    }

    public static boolean checkTypeRental(String typeRental){
        boolean flag;
        if((typeRental.equals("Ngày")) || (typeRental.equals("Tháng")) || (typeRental.equals("Năm"))){
            flag = true;
        }else {
            System.out.println("Định dạng thuê phải là Ngày,Tháng hoặc Năm");
            flag = false;
        }
        return flag;
    }

    public static boolean checkTypeRoom(String typeRoom){
        boolean flag;
        if((typeRoom.equals("Vip")) || (typeRoom.equals("Delux")) || (typeRoom.equals("Medium"))){
            flag = true;
        }else {
            System.out.println("Định dạng thuê phải là Vip,Delux hoặc Medium");
            flag = false;
        }
        return flag;
    }
}

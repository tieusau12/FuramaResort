package Models.customer;

import Commoms.CheckClass;
import Commoms.FileUtils;
import Commoms.ValidateCustomer;
import Commoms.exceptionCustomer.*;
import Controllers.MainController;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CustomerManager {
    public static void showInformationCustomer() throws IOException {
        List<String> listString = FileUtils.readFile("CaseStudy_Module2/src/Data/Customer.csv");
        Set<Customer> listCustomer = new TreeSet<>();
        for (int indexList = 0; indexList < listString.size(); indexList++) {
            String[] array = listString.get(indexList).split(",");
            Customer customer = new Customer(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7]);
            listCustomer.add(customer);
        }

        for (Customer info : listCustomer) {
            System.out.println("Tên Customer: " + info.getNameCustomer() +
                    " , Ngày sinh: " + info.getDateOfBirth() +
                    " , CMND: " + info.getIdCustomer() +
                    " , Email: " + info.getEmailCustomer() +
                    " , Số điện thoại: " + info.getPhoneNumberCustomer() +
                    " , Địa chỉ: " + info.getAddressCustomer());
        }
    }


    public static void addNewCustomer() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Thêm customer \n" +
                "2.Xoá customer \n" +
                "3.Chỉnh sửa thông tin \n" +
                "4.Back to menu \n" +
                "5.Exit");

        int chooseNumber = CheckClass.checkNumber(5);
        boolean flag;
        switch (chooseNumber) {
            case 1:
                String nameCustomer;
                String birthDayCustomer;
                String genderCustomer;
                String idCardCustomer;
                String phoneNumberCustomer;
                String levelCardCustomer;
                String addressCustomer;
                String emailCustomer;

                System.out.println("Nhập tên Customer: ");
                do {
                    nameCustomer = scanner.nextLine();
                    try {
                        ValidateCustomer.validateName(nameCustomer);
                        flag = true;
                    } catch (ExceptionName exceptionName) {
                        System.out.println(exceptionName.getMessage());
                        flag = false;
                    }
                } while (!flag);

                System.out.println("Ngày sinh:");
                do {
                    birthDayCustomer = scanner.nextLine();
                    try {
                        ValidateCustomer.validateBirthDay(birthDayCustomer);
                        flag = true;
                    } catch (ExceptionBirthDay exceptionBirthDay) {
                        System.out.println(exceptionBirthDay.getMessage());
                        ;
                        flag = false;
                    }
                } while (!flag);

                System.out.println("Giới tính (Male,Female,Unknown): ");
                do {
                    genderCustomer = scanner.nextLine();
                    StringBuilder stringGender = new StringBuilder(genderCustomer.toLowerCase());
                    String newUpperChar = String.valueOf(stringGender.charAt(0)).toUpperCase();
                    stringGender.replace(0, 1, newUpperChar);
                    genderCustomer = stringGender.toString();
                    try {
                        ValidateCustomer.validateGender(genderCustomer);
                        flag = true;
                    } catch (ExceptionGender exceptionGender) {
                        System.out.println(exceptionGender.getMessage());
                        flag = false;
                    }
                } while (!flag);


                System.out.println("Nhập CMND(Định dạng XXX-XXX-XXX):");
                do {
                    List<String> listIdCustomer = FileUtils.readFile("CaseStudy_Module2/src/Data/Customer.csv");
                    idCardCustomer = scanner.nextLine();
                    try {
                        ValidateCustomer.validateIdCard(idCardCustomer);
                        flag = true;
                    } catch (ExceptionIdCard exceptionIdCard) {
                        System.out.println(exceptionIdCard.getMessage());
                        flag = false;
                    }

                    for (int index = 0; index < listIdCustomer.size(); index++) {
                        String[] arrayIdCustomer = listIdCustomer.get(index).split(",");
                        if (arrayIdCustomer[3].equals(idCardCustomer)) {
                            System.out.println("CMND đã bị trùng , vui lòng nhập lại !");
                            flag = false;
                        }
                    }
                } while (!flag);


                System.out.println("Nhập SĐT(Định dạng 0XXX-XXX-XXX)");
                do {
                    phoneNumberCustomer = scanner.nextLine();
                    flag = true;
                    if (!ValidateCustomer.validatePhoneNumber(phoneNumberCustomer)) {
                        System.out.println("Đúng định dạng 0XXX-XXX-XXX(X là số)");
                        flag = false;
                    }
                } while (!flag);

                System.out.println("Nhập Email:");
                do {
                    emailCustomer = scanner.nextLine();
                    try {
                        ValidateCustomer.validateEmail(emailCustomer);
                        flag = true;
                    } catch (ExceptionEmail exceptionEmail) {
                        System.out.println(exceptionEmail.getMessage());
                        flag = false;
                    }
                } while (!flag);


                System.out.println("Thẻ thành viên:");
                do {
                    levelCardCustomer = scanner.nextLine();
                    flag = true;
                    if (ValidateCustomer.validateCardCustomer(levelCardCustomer) == null) {
                        System.out.println("Lựa chọn Diamond , Platinum , Gold , Silver hoặc Member!");
                        flag = false;
                    } else {
                        levelCardCustomer = ValidateCustomer.validateCardCustomer(levelCardCustomer);
                    }
                } while (!flag);


                System.out.println("Địa chỉ:");
                addressCustomer = scanner.nextLine();

                Customer customer = new Customer(nameCustomer, birthDayCustomer, genderCustomer, idCardCustomer, phoneNumberCustomer, emailCustomer, levelCardCustomer, addressCustomer);
                FileUtils.writeFile("CaseStudy_Module2/src/Data/Customer.csv", customer.toString());
                MainController.displayMainMenu();
                break;
            case 2:
                List<Customer> customerList = FileUtils.readFileCustomer();
                showInformationCustomer();
                System.out.println("Nhập ID Customer muốn xoá:");
                String idCustomer = scanner.nextLine();
                boolean check = false;
                for (int index = 0; index < customerList.size(); index++) {
                    if (idCustomer.equals(customerList.get(index).getIdCustomer())) {
                        customerList.remove(index);
                        check = true;
                        break;
                    }
                }

                if (!check) {
                    System.out.println("ID Không tồn tại");
                    addNewCustomer();
                } else {
                    FileUtils.writeCustomerUpdate(customerList);
                }
                addNewCustomer();
                break;
            case 3:
                List<Customer> customerList1 = FileUtils.readFileCustomer();
                CustomerManager.showInformationCustomer();
                System.out.println("Nhập ID Customer muốn sửa thông tin:");
                String idCustomer2 = scanner.nextLine();
                int index1;
                for (index1 = 0; index1 < customerList1.size(); index1++) {
                    if (idCustomer2.equals(customerList1.get(index1).getIdCustomer())) {
                        System.out.println(customerList1.get(index1).toString());
                        System.out.println("1.Sửa tên khách hàng \n" +
                                "2.Sửa ngày sinh \n" +
                                "3.Sửa giới tính \n" +
                                "4.Sửa CMND \n" +
                                "5.Sửa SĐT \n" +
                                "6.Sửa Email \n" +
                                "7.Sửa thẻ khách hàng \n" +
                                "8.Sửa địa chỉ \n" +
                                "9.Back to Menu");
                        int choose = CheckClass.checkNumber(8);
                        switch (choose) {
                            case 1:
                                System.out.println("Nhập tên mới: ");
                                String newName;
                                do {
                                    newName = scanner.nextLine();
                                    try {
                                        ValidateCustomer.validateName(newName);
                                        flag = true;
                                    } catch (ExceptionName exceptionName) {
                                        System.out.println(exceptionName.getMessage());
                                        flag = false;
                                    }
                                } while (!flag);
                                customerList1.get(index1).setNameCustomer(newName);
                                break;
                            case 2:
                                System.out.println("Nhập lại ngày sinh: ");
                                String newBirthDay;
                                do {
                                    newBirthDay = scanner.nextLine();
                                    try {
                                        ValidateCustomer.validateBirthDay(newBirthDay);
                                        flag = true;
                                    } catch (ExceptionBirthDay exceptionBirthDay) {
                                        System.out.println(exceptionBirthDay.getMessage());
                                        flag = false;
                                    }
                                } while (!flag);
                                customerList1.get(index1).setDateOfBirth(newBirthDay);
                                break;
                            case 3:
                                System.out.println("Nhập lại giới tính: ");
                                String newGender;

                                do {
                                    newGender = scanner.nextLine();
                                    StringBuilder stringGender = new StringBuilder(newGender.toLowerCase());
                                    String newUpperChar = String.valueOf(stringGender.charAt(0)).toUpperCase();
                                    stringGender.replace(0, 1, newUpperChar);
                                    newGender = stringGender.toString();
                                    try {
                                        ValidateCustomer.validateGender(newGender);
                                        flag = true;
                                    } catch (ExceptionGender exceptionGender) {
                                        System.out.println(exceptionGender.getMessage());
                                        flag = false;
                                    }
                                } while (!flag);
                                customerList1.get(index1).setGenderCustomer(newGender);
                                break;
                            case 4:
                                System.out.println("Nhập lại CMND: ");
                                String newCMND;
                                do {
                                    List<String> listIdCustomer = FileUtils.readFile("CaseStudy_Module2/src/Data/Customer.csv");
                                    newCMND = scanner.nextLine();
                                    try {
                                        ValidateCustomer.validateIdCard(newCMND);
                                        flag = true;
                                    } catch (ExceptionIdCard exceptionIdCard) {
                                        System.out.println(exceptionIdCard.getMessage());
                                        flag = false;
                                    }

                                    for (int index2 = 0; index2 < listIdCustomer.size(); index2++) {
                                        String[] arrayIdCustomer = listIdCustomer.get(index2).split(",");
                                        if (arrayIdCustomer[3].equals(newCMND)) {
                                            System.out.println("CMND đã bị trùng , vui lòng nhập lại !");
                                            flag = false;
                                        }
                                    }
                                } while (!flag);
                                customerList1.get(index1).setIdCustomer(newCMND);
                                break;
                            case 5:
                                System.out.println("Nhập lại sđt: ");
                                String newPhone;
                                do {
                                    newPhone = scanner.nextLine();
                                    flag = true;
                                    if (!ValidateCustomer.validatePhoneNumber(newPhone)) {
                                        System.out.println("Đúng định dạng 0XXX-XXX-XXX(X là số)");
                                        flag = false;
                                    }
                                } while (!flag);
                                customerList1.get(index1).setPhoneNumberCustomer(newPhone);
                                break;
                            case 6:
                                System.out.println("Nhập lại email: ");
                                String newEmail;
                                do {
                                    newEmail = scanner.nextLine();
                                    try {
                                        ValidateCustomer.validateEmail(newEmail);
                                        flag = true;
                                    } catch (ExceptionEmail exceptionEmail) {
                                        System.out.println(exceptionEmail.getMessage());
                                        flag = false;
                                    }
                                } while (!flag);
                                customerList1.get(index1).setEmailCustomer(newEmail);
                                break;
                            case 7:
                                System.out.println("Nhập lại thẻ thành viên: ");
                                String newType;
                                do {
                                    newType = scanner.nextLine();
                                    flag = true;
                                    if (ValidateCustomer.validateCardCustomer(newType) == null) {
                                        System.out.println("Lựa chọn Diamond , Platinum , Gold , Silver hoặc Member!");
                                        flag = false;
                                    } else {
                                        levelCardCustomer = ValidateCustomer.validateCardCustomer(newType);
                                    }
                                } while (!flag);
                                customerList1.get(index1).setLevelCustomer(newType);
                                break;
                            case 8:
                                System.out.println("Nhập lại địa chỉ: ");
                                String newAddress = scanner.nextLine();
                                customerList1.get(index1).setAddressCustomer(newAddress);
                                break;
                        }
                    }
                }
                FileUtils.writeCustomerUpdate(customerList1);
                addNewCustomer();
            case 4:
                MainController.displayMainMenu();
            case 5:
                break;
        }
    }
}

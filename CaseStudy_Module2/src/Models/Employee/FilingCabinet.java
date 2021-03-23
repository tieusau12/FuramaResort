package Models.Employee;

import Commoms.FileUtils;
import Controllers.MainController;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class FilingCabinet {
    public static void searchEmployee() throws IOException {
        Stack<String> employeeCabinet = FileUtils.readFileEmployee();
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;

        System.out.println(" Nhập ID nhân viên muốn tìm kiếm ! ");
        String employeeID = scanner.nextLine();
        for (String employee : employeeCabinet) {
            String[] array = employee.split(",");
            if (employeeID.equals(array[3])) {
                System.out.println("Tên nhân viên:" + array[0] +
                        " , Tuổi: " + array[1] +
                        " , Đia chỉ: " + array[2]);
                flag = true;
                break;
            }
        }
        if (flag == false) {
            System.out.println(" Không tìm thấy ID nhân viên ");
        }
        MainController.displayMainMenu();
    }
}

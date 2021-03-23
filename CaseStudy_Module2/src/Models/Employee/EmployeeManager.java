package Models.Employee;

import Commoms.FileUtils;
import Controllers.MainController;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class EmployeeManager {
    public static void showEmployer() throws IOException {
        Map<String, Employee> listEmployee = new TreeMap<>();
        List<String> fileEmployee = FileUtils.readFile("CaseStudy_Module2/src/Data/Employee.csv");

        for (int index = 0; index < fileEmployee.size(); index++) {
            String[] array = fileEmployee.get(index).split(",");
            Employee employee = new Employee(array[0], Integer.parseInt(array[1]), array[2]);
            listEmployee.put(array[3], employee);
        }
        Set<String> keySet = listEmployee.keySet();
        for (String key : keySet) {
            System.out.println(key + " -" + listEmployee.get(key));
        }
        MainController.displayMainMenu();
    }
}

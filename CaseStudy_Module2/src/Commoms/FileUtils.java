package Commoms;

import Models.customer.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FileUtils {
    public static void writeFile(String pathFile, Object line) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(line + "\n");

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile(String pathFile) throws IOException {
        List<String> listLine = new ArrayList<>();
        FileReader fileReader = new FileReader(pathFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            listLine.add(line);
        }
        return listLine;
    }

    public static List<Customer> readFileCustomer() throws IOException {
        List<Customer> customerList = new ArrayList<>();

        File file = new File("CaseStudy_Module2/src/Data/Customer.csv");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        while ((line != null)) {
            String[] array = line.split(",");
            Customer customer = new Customer(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7]);
            customerList.add(customer);
            line = bufferedReader.readLine();
        }
        return customerList;
    }

    public static void writeCustomerUpdate(List<Customer> customerList) throws IOException {
        File file = new File("CaseStudy_Module2/src/Data/Customer.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for (Customer customer : customerList) {
            bufferedWriter.write(customer.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    public static void writeFileBooking(String pathFile, String line) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line + "\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Stack<String> readFileEmployee() throws IOException {
        Stack<String> listline = new Stack<>();
        File file = new File("CaseStudy_Module2/src/Data/Employee.csv");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            listline.add(line);
        }
        return listline;
    }
}

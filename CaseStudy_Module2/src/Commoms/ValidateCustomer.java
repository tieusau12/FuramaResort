package Commoms;

import Commoms.exceptionCustomer.*;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCustomer {
    private static final String REGEX_NAME_CUSTOMER = "([\\p{Lu}][\\p{Ll}]{0,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){1,10}$";
    private static final String REGEX_EMAIL_CUSTOMER = "^[a-z]*[0-9]*+@[a-z]+([.][a-z]{2,})+$";
    private static final String REGEX_GENDER_CUSTOMER = "^(Female|Male|Unknown)$";
    private static final String REGEX_ID_CARD = "^[0-9]{3}[-][0-9]{3}[-][0-9]{3}$";
    private static final String REGEX_BIRTHDAY_CUSTOMER = "^\\d{2}[/]\\d{2}[/]\\d{4}$";
    private static final String REGEX_PHONE_CUSTOMER = "^[0][0-9]{3}[-][0-9]{3}[-][0-9]{3}$";
    private static final String REGEX_CARD_CUSTOMER = "(Diamond|Platinum|Gold|Silver|Member)";

    public static void validateName(String regex) throws ExceptionName {
        if (!regex.matches(REGEX_NAME_CUSTOMER)) {
            throw new ExceptionName("Tên đúng định dạng Nguyễn Văn A");
        }
    }

    public static void validateEmail(String regex) throws ExceptionEmail {
        if (!regex.matches(REGEX_EMAIL_CUSTOMER)) {
            throw new ExceptionEmail("Email đúng định dạng abcxxx@abcxxx.abcxxx");
        }
    }

    public static void validateIdCard(String regex) throws ExceptionIdCard {
        if (!regex.matches(REGEX_ID_CARD)) {
            throw new ExceptionIdCard("CMND đúng định dạng xxx-xxx-xxx");
        }
    }

    public static void validateGender(String regex) throws ExceptionGender {
        if (!regex.matches(REGEX_GENDER_CUSTOMER)) {
            throw new ExceptionGender("Male,Female hoặc Unknown");
        }
    }

    public static boolean validatePhoneNumber(String regex) {
        return regex.matches(REGEX_PHONE_CUSTOMER);
    }

    public static String validateCardCustomer(String regex) {
        StringBuilder stringCardCustomer = new StringBuilder(regex.toLowerCase());
        String newUpperChar = String.valueOf(stringCardCustomer.charAt(0)).toUpperCase();
        stringCardCustomer.replace(0, 1, newUpperChar);
        regex = stringCardCustomer.toString();

        if (regex.matches(REGEX_CARD_CUSTOMER)) {
            return regex;
        } else {
            return null;
        }
    }

    public static void validateBirthDay(String regex) throws ExceptionBirthDay {
        //Lấy năm hiện tại!!
        Calendar calendar = Calendar.getInstance();
        int yearNow = calendar.get(Calendar.YEAR);

        Pattern pattern = Pattern.compile(REGEX_BIRTHDAY_CUSTOMER);
        Matcher matcher = pattern.matcher(regex);
        if (matcher.matches()) {
            String[] array = regex.split("/");
            if (Integer.parseInt(array[0]) > 31 || Integer.parseInt(array[1]) > 12 || Integer.parseInt(array[2]) < 1901 || Integer.parseInt(array[2]) > yearNow) {
                throw new ExceptionBirthDay("Ngày tháng năm phải đúng thực tế !");
            } else if (Integer.parseInt(array[1]) == 2) {
                if (Integer.parseInt(array[2]) % 4 == 0 && Integer.parseInt(array[0]) > 29) {
                    throw new ExceptionBirthDay("Tháng 2 năm nhuận chỉ có 29 ngày");
                } else if (Integer.parseInt(array[2]) % 4 != 0 && Integer.parseInt(array[0]) > 28) {
                    throw new ExceptionBirthDay("Tháng 2 chỉ có 28 ngày");
                }
            } else if (checkDate(Integer.parseInt(array[1])) && Integer.parseInt(array[0]) > 31) {
                throw new ExceptionBirthDay("Tháng 1,3,5,7,8,10,12 chỉ có 31 ngày");
            } else if (!checkDate(Integer.parseInt(array[1])) && Integer.parseInt(array[0]) > 30) {
                throw new ExceptionBirthDay("Tháng 4,6,9,11 chỉ có 30 ngày");
            }
        } else {
            throw new ExceptionBirthDay("Đúng định dạng dd/MM/YYYY");
        }
    }

    public static boolean checkDate(int Month) {
        switch (Month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return true;
            default:
                return false;
        }
    }
}

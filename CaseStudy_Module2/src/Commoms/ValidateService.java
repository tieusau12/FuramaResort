package Commoms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateService {
    private static final String ID_VILLA_REGEX = "^[S][V][V][L][-]\\d{4}$";
    private static final String ID_HOUSE_REGEX = "^[S][V][H][O][-]\\d{4}$";
    private static final String ID_ROOM_REGEX = "^[S][V][R][O][-]\\d{4}$";

    private static final String NAME_SERVICE_REGEX = "^[A-Z][a-z]{2,10}$";

    public boolean validateIdVilla(String regex) {
        Pattern pattern = Pattern.compile(ID_VILLA_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean validateIdHouse(String regex) {
        Pattern pattern = Pattern.compile(ID_HOUSE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean validateIdRoom(String regex) {
        Pattern pattern = Pattern.compile(ID_ROOM_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean validateNameService(String regex) {
        Pattern pattern = Pattern.compile(NAME_SERVICE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

}

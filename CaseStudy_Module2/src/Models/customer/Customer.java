package Models.customer;

import Models.Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer implements Comparable<Customer> {
    private String nameCustomer;
    private String dateOfBirth;
    private String genderCustomer;
    private String idCustomer;
    private String phoneNumberCustomer;
    private String emailCustomer;
    private String levelCustomer;
    private String addressCustomer;
    private Services service;

    public Customer(String nameCustomer, String dateOfBirth, String genderCustomer, String idCustomer,
                    String phoneNumberCustomer, String emailCustomer, String levelCustomer, String addressCustomer) {
        this.nameCustomer = nameCustomer;
        this.dateOfBirth = dateOfBirth;
        this.genderCustomer = genderCustomer;
        this.idCustomer = idCustomer;
        this.phoneNumberCustomer = phoneNumberCustomer;
        this.emailCustomer = emailCustomer;
        this.levelCustomer = levelCustomer;
        this.addressCustomer = addressCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGenderCustomer() {
        return genderCustomer;
    }

    public void setGenderCustomer(String genderCustomer) {
        this.genderCustomer = genderCustomer;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getPhoneNumberCustomer() {
        return phoneNumberCustomer;
    }

    public void setPhoneNumberCustomer(String phoneNumberCustomer) {
        this.phoneNumberCustomer = phoneNumberCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getLevelCustomer() {
        return levelCustomer;
    }

    public void setLevelCustomer(String levelCustomer) {
        this.levelCustomer = levelCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return getNameCustomer() + "," +
                getDateOfBirth() + "," +
                getGenderCustomer() + "," +
                getIdCustomer() + "," +
                getPhoneNumberCustomer() + "," +
                getEmailCustomer() + "," +
                getLevelCustomer() + "," +
                getAddressCustomer();
    }

    @Override
    public int compareTo(Customer o) {
        Date date1 = null;
        Date date2 = null;
        if (this.getNameCustomer().compareTo(o.getNameCustomer()) != 0) {
            return this.getNameCustomer().compareTo(o.getNameCustomer());
        } else {
            try {
                date1 = new SimpleDateFormat("dd/MM/yyyy").parse(this.getDateOfBirth());
                date2 = new SimpleDateFormat("dd/MM/yyyy").parse(o.getDateOfBirth());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date1.compareTo(date2);
        }
    }
}


package Models;

public abstract class Services {
    String idServices;
    String nameServices;
    double areaServices;
    double priceServices;
    int accompanyPeople;
    String typeOfRental;

    public Services(String idServices, String nameServices, double areaServices, double priceServices, int accompanyPeople, String typeOfRental) {
        this.idServices = idServices;
        this.nameServices = nameServices;
        this.areaServices = areaServices;
        this.priceServices = priceServices;
        this.accompanyPeople = accompanyPeople;
        this.typeOfRental = typeOfRental;
    }

    public String getIdServices() {
        return idServices;
    }

    public void setIdServices(String id) {
        this.idServices = idServices;
    }

    public String getNameServices() {
        return nameServices;
    }

    public void setNameServices(String nameServices) {
        this.nameServices = nameServices;
    }

    public double getAreaServices() {
        return areaServices;
    }

    public void setAreaServices(double areaServices) {
        this.areaServices = areaServices;
    }

    public double getPriceServices() {
        return priceServices;
    }

    public void setPriceServices(double priceServices) {
        this.priceServices = priceServices;
    }

    public int getAccompanyPeople() {
        return accompanyPeople;
    }

    public void setAccompany(int accompanyPeople) {
        this.accompanyPeople = accompanyPeople;
    }

    public String getTypeOfRental() {
        return typeOfRental;
    }

    public void setTypeOfRental(String typeOfRental) {
        this.typeOfRental = typeOfRental;
    }

    @Override
    public String toString() {
        return idServices + "," +
                nameServices + ","
                + areaServices + ","
                + priceServices + ","
                + accompanyPeople + ","
                + typeOfRental;
    }

    public abstract String showInfo();
}

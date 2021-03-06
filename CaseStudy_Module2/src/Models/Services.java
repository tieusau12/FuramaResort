package Models;

public abstract class Services {
    String id;

    String nameServices;
    double areaServices;
    double priceServices;
    int accompanyPeople ;
    String typeOfRental;

    public Services(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    abstract void showInfor();
}

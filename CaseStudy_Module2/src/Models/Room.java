package Models;

public class Room extends Services {
    private String freeServices;

    public Room(String id, String nameServices, double areaServices, double priceServices,
                int accompanyPeople, String typeOfRental, String freeServices) {
        super(id, nameServices, areaServices, priceServices, accompanyPeople, typeOfRental);
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServicesces) {
        this.freeServices = freeServices;
    }

    @Override
    public String showInfo() {
        return "ID Villa: " + super.getIdServices() +
                " , Tên Villa: " + super.getNameServices() +
                " , Diện tích: " + super.getAreaServices() + "m2" +
                " , Số người tối đa: " + super.getAccompanyPeople() +
                " , Dịch vụ miễn phí: " + getFreeServices() +
                " , Kiểu thuê: " + super.getTypeOfRental() +
                " , Chi phí thuê: " + super.getPriceServices();
    }

    @Override
    public String toString() {
        return super.toString() +","+freeServices;
    }
}

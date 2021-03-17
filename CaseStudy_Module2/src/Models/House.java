package Models;

public class House extends Services {
    private String typeOfRoom;
    private int floors;


    public House(String id, String nameServices, double areaServices, double priceServices, int accompanyPeople,
                 String typeOfRental, String typeOfRoom, int floors) {
        super(id, nameServices, areaServices, priceServices, accompanyPeople, typeOfRental);
        this.typeOfRoom = typeOfRoom;
        this.floors = floors;
    }

    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String showInfo() {
        return "ID Villa: " + super.getIdServices() +
                " , Tên Villa: " + super.getNameServices() +
                " , Diện tích: " + super.getAreaServices() + "m2" +
                " , Số người tối đa: " + super.getAccompanyPeople() +
                " , Số tầng: " + getFloors() +
                " , Tiêu chuẩn phòng: " + getTypeOfRoom() +
                " , Kiểu thuê: " + super.getTypeOfRental() +
                " , Chi phí thuê: " + super.getPriceServices() + "USD";
    }

    @Override
    public String toString() {
        return super.toString() + "," + typeOfRoom + ","
                + floors;
    }
}

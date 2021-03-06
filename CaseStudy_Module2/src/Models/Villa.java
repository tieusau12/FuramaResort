package Models;

public class Villa extends Services {
    private String typeOfRoom;
    private int floors;
    private double areaOfPool;
    private String roomAmenities;

    public Villa(String id, String nameServices, double areaService,double priceServices,int accompanyPeople,String typeOfRental ,String typeOfRoom, int floors, double areaOfPool) {
        super(id);
        super.nameServices = nameServices;
        super.areaServices = areaService;
        super.priceServices =priceServices;
        super.accompanyPeople=accompanyPeople;
        super.typeOfRental=typeOfRental;
        this.typeOfRoom = typeOfRoom;
        this.floors = floors;
        this.areaOfPool = areaOfPool;
    }

    public Villa(String id) {
        super(id);
    }

    @Override
    void showInfor() {

    }
}

package Models.Employee;

public class Employee {
    String nameEmployee;
    Integer ageEmployee;
    String addressEmployee;
    Integer idEmployee;

    public Employee(String nameEmployee, Integer ageEmployee, String addressEmployee) {
        this.nameEmployee = nameEmployee;
        this.ageEmployee = ageEmployee;
        this.addressEmployee = addressEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public Integer getAgeEmployee() {
        return ageEmployee;
    }

    public void setAgeEmployee(Integer ageEmployee) {
        this.ageEmployee = ageEmployee;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public void setAddressEmployee(String addressEmployee) {
        this.addressEmployee = addressEmployee;
    }

    @Override
    public String toString() {
        return "Employee :" +
                " Tên nhân viên : " + nameEmployee +
                " Tuổi : " + ageEmployee +
                " Địa chỉ  :" + addressEmployee;
    }

}

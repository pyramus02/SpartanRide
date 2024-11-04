package spartanRide.api.driver;

import jakarta.persistence.*;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int driverId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(email = "email", nullable = false)
    private String email;

    @Column(carModel = "carModel", nullable = false)
    private String carModel;

    @Column(plateNum = "plateNum", nullable = false)
    private String plateNum;

    @Column(phoneNum = "phoneNum", nullable = true)
    private int phoneNum;

    @Column(status = "status")
    private String status;


    public Driver(int driverId, String name, String email, String carModel, String plateNum, int phoneNum, String status) {
        this.driverId = driverId;
        this.name = name;
        this.email = email;
        this.carModel = carModel;
        this.plateNum = plateNum;
        this.phoneNum = phoneNum;
        this.status = status;
    }

    public Driver(String name, String email, String carModel, String plateNum, int phoneNum, String status) {
        this.name = name;
        this.email = email;
        this.carModel = carModel;
        this.plateNum = plateNum;
        this.phoneNum = phoneNum;
        this.status = status;
    }

    public Driver(){

    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

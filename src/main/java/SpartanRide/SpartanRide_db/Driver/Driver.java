package SpartanRide.SpartanRide_db.Driver;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "car_model")
    private String carModel;

    @Column(name = "plate_num", nullable = false)
    private String plateNum;

    @Column(name = "phone_num")
    private int phoneNum;

    @Column(name = "status")
    private String status;

    @Column(name = "destination")
    private String destination;

    @Column(name = "account_status")
    private String accountStatus;



    public Driver(int id, String name, String email, String carModel, String plateNum, int phoneNum, String status, String destination, String accountStatus) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.carModel = carModel;
        this.plateNum = plateNum;
        this.phoneNum = phoneNum;
        this.status = status;
        this.destination = destination;
        this.accountStatus = accountStatus;
    }

    public Driver(String name, String email, String carModel, String plateNum, int phoneNum, String status, String destination) {
        this.name = name;
        this.email = email;
        this.carModel = carModel;
        this.plateNum = plateNum;
        this.phoneNum = phoneNum;
        this.status = status;
        this.destination = destination;
        this.accountStatus = accountStatus;
    }


    public Driver() {

    }

    public String getAccountStatus(){
        return this.accountStatus;
    }

    public void setAccountStatus(String newStatus){
        this.accountStatus = accountStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    

}
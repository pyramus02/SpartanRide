package SpartanRide.SpartanRide_db;


import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "rider")
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "status")
    private String status;


    @Column(name = "accountStatus")
    private String accountStatus;


    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "driverId", nullable = true)
    private int driverId;

    @Column(name = "phone_num")
    private int phoneNum;

    public Rider() {

    }

    public void setDriverId(int drId) {
        this.driverId = drId;
    }

    public int getDriverId() {
        return this.driverId;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountStatus(){
        return this.accountStatus;
    }

    public void setAccountStatus(String newStatus){
        this.accountStatus = newStatus;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public void setRider(Rider newRider) {
        this.email = newRider.getEmail();
        this.name = newRider.getName();
        this.phoneNum = newRider.getPhoneNum();
        this.email = newRider.getEmail();

        if (newRider.getAccountStatus() != null) {
            this.accountStatus = newRider.getAccountStatus();
        }
    }


    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }


}

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


    @Column(name = "accountStatus", nullable = false)
    private String accountStatus;


    @Column(name = "email", nullable = false)
    private String email;


    public Rider() {

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


    public void setRider(Rider newRider) {
        this.email = newRider.getEmail();
        this.name = newRider.getName();
        this.accountStatus = newRider.getAccountStatus();
    }


}

package SpartanRide.SpartanRide_db.Admin;


import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "accountStatus")
    private String accountStatus;

    @Column(name = "status")
    private String status;

    @Column(name = "phone_num")
    private int phoneNum;



    public void setId(int newId) {
        this.id = newId;
    }

    public int getId() {
        return this.id;
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


    public void setAdmin(Admin newAdmin) {
        this.email = newAdmin.getEmail();
        this.name = newAdmin.getName();
        this.phoneNum = newAdmin.getPhoneNum();
        this.email = newAdmin.getEmail();
    }





}

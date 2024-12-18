package SpartanRide.SpartanRide_db.Rider;


import jakarta.persistence.*;

@Entity
@Table(name = "rider")
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;


    @Column(name = "status")
    private String status;


    @Column(name = "accountStatus")
    private String accountStatus;


    @Column(name = "email")
    private String email;

    @Column(name = "driverId")
    private Integer driverId;


    @Column(name = "password")
    private String password;

    @Column(name = "phone_num")
    private Integer phone_num;

    @Column(name = "reported")
    private Boolean reported;

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
        this.phone_num = newRider.getPhoneNum();
        this.email = newRider.getEmail();

        if (newRider.getAccountStatus() != null) {
            this.accountStatus = newRider.getAccountStatus();
        }
    }


    public int getPhoneNum() {
        return phone_num;
    }

    public void setPhoneNum(int phoneNum) {
        this.phone_num = phoneNum;
    }


    public String getPassword() {return this.password;}


    public void setPassword(String password) {
        this.password = password;
    }




    public Boolean getReported() {return this.reported;}

    public void setReported(Boolean report) {this.reported = report;}




}

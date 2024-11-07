package SpartanRide.SpartanRide_db;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    public void setId(int newId) {
        this.id = newId;
    }

    public int getId() {
        return this.id;
    }







}

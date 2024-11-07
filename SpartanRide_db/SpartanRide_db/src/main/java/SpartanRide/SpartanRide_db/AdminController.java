package SpartanRide.SpartanRide_db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;



@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private RiderService riderService;

    @GetMapping("/drivers")
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/riders")
    public List<Rider> getAllRiders() {
        return riderService.getAllRiders();
    }


    @GetMapping("/all")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    /**
     *
     *{"name": "Aidan",
     *  "email": "alquinn2@uncg.edu",
     *  phoneNum": "1231231234",
     *  "status": "Online",
     *  "accountStatus": "Active"}
     */

    @PostMapping("/new")
    public @ResponseBody List<Admin> addNewAdmin(@RequestBody Admin admin) {
        adminService.addNewAdmin(admin);
        return adminService.getAllAdmins();
    }


    @PutMapping("/update/{adminId}")
    public Admin updateAdmin(@PathVariable int adminId, @RequestBody Admin admin) {
        adminService.updateAdmin(adminId, admin);
        return adminService.getAdminById(adminId);
    }

    @PutMapping("/logIn/{id}")
    public Admin logIn(@PathVariable int id, @RequestBody Admin admin) {
        adminService.logIn(id, admin);

        return adminService.getAdminById(id);
    }

    @PutMapping("/logOff/{id}")
    public Admin logOfF(@PathVariable int id, @RequestBody Admin admin) {

        adminService.logOut(id, admin);

        return adminService.getAdminById(id);
    }

    @GetMapping("/stats")
    public Stats showStats() {

        int driverTotal = adminService.getDriverTotal();
        int riderTotal = adminService.getRiderTotal();
        int driverOnline = adminService.getDriverOnline();
        int riderOnline = adminService.getRiderOnline();


        Stats currStats = new Stats(driverTotal, riderTotal, driverOnline, riderOnline);

        return currStats;


    }






}
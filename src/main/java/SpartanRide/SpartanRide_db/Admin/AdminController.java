package SpartanRide.SpartanRide_db.Admin;

import SpartanRide.SpartanRide_db.*;
import SpartanRide.SpartanRide_db.Driver.Driver;
import SpartanRide.SpartanRide_db.Driver.DriverService;
import SpartanRide.SpartanRide_db.Review.Review;
import SpartanRide.SpartanRide_db.Rider.Rider;
import SpartanRide.SpartanRide_db.Rider.RiderService;
import SpartanRide.SpartanRide_db.Review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {



    @Autowired
    private AdminService adminService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private RiderService riderService;

    @Autowired
    private ReviewService reviewService;






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


    @GetMapping("/admin-home")
    public String adminHome() {
        return "admin_home";
    }

    @GetMapping("/admin-access")
    public String adminAccess() {
        return "admin_access";
    }

    @GetMapping("/admin-review")
    public String adminReview() {
        return "admin_review";
    }


    @PostMapping("/ban-driver")
    public String banDriver(int driverId, Model model) {
        driverService.banDriver(driverId);
        return "redirect:/admin/admin-access";
    }

    @PostMapping("/ban-rider")
    public String banRider(int riderId, Model model) {
        riderService.banRider(riderId);
        return "redirect:/admin/admin-access";
    }


    @PostMapping("/unban-driver")
    public String unbanDriver(int driverId, Model model) {
        driverService.unbanDriver(driverId);
        return "redirect:/admin/admin-access";
    }

    @PostMapping("/unban-rider")
    public String unbanRider(int riderId, Model model) {
        riderService.unbanRider(riderId);
        return "redirect:/admin/admin-access";
    }



    @PostMapping("/destroy-review")
    public String killReview(Integer driverId, Integer riderId) {

        Review thisReview = reviewService.getReviewOfSubByAuth(driverId, riderId);

        if (thisReview != null) {
            reviewService.deleteReviewById(thisReview.getId());

        }
        return "redirect:/admin/admin-review";
    }


}
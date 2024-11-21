package SpartanRide.SpartanRide_db.Rider;

import SpartanRide.SpartanRide_db.Driver.DriverService;
import SpartanRide.SpartanRide_db.Review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
@RequestMapping("/rider")
public class RiderController {


    @Autowired
    public RiderService riderService;
    @Autowired
    public DriverService driverService;
    @Autowired
    public ReviewService reviewService;

    @Autowired RiderRepository riderRepository;

    @GetMapping("/all")
    public List<Rider> getAllRiders() {
        return riderService.getAllRiders();
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
    public String addNewRider(Rider rider) {

        riderService.addNewRider(rider);
        return "redirect:/rider/riderHome";




    }

    @PostMapping("/subscribe/{driverId}/{riderId}")
    public Rider subscribe(@PathVariable int driverId,@PathVariable int riderId ) {

        driverService.addRider(driverId, riderId);
        return riderService.subscribe(driverId, riderId);

    }


    @PostMapping("/unsubscribe/{driverId}/{riderId}")
    public Rider unsubscribe(@PathVariable int driverId,@PathVariable int riderId ) {

        driverService.removeRider(driverId, riderId);
        return riderService.unsubscribe(driverId, riderId);

    }

    @PutMapping("/update/{riderId}")
    public Rider updateRider(@PathVariable int riderId, @RequestBody Rider rider) {
        riderService.updateRider(riderId, rider);
        return riderService.getRiderById(riderId);
    }

    @PostMapping("/logIn/{id}")
    public String logIn(@PathVariable int id) {
        riderService.logIn(id);

        return "redirect:/rider/riderHome";
    }

    @PostMapping("/login")
    public String login(int riderId) {

        riderService.logIn(riderId);

        if (riderService.getRiderById(riderId) != null) {
            return "redirect:/rider/riderHome";
        }

        return "redirect:/rider/login-page";
    }


    @PutMapping("/logOut/{id}")
    public Rider logOut(@PathVariable int id) {
        riderService.logOut(id);
        return riderService.getRiderById(id);
    }

    @GetMapping("/login-page")
    public String loginPage() {
        return "log_in";
    }


    @GetMapping("/signup-page")
    public String signupPage() {
        return "sign_up";
    }


    @GetMapping("/riderHome")
    public String riderHome() {
        return "rider_home";
    }

}
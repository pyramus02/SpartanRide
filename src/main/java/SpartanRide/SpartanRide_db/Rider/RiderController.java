package SpartanRide.SpartanRide_db.Rider;

import SpartanRide.SpartanRide_db.Driver.Driver;
import SpartanRide.SpartanRide_db.Driver.DriverService;
import SpartanRide.SpartanRide_db.Review.Review;
import SpartanRide.SpartanRide_db.Review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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


        if (riderService.checkEmailDup(rider.getEmail())) {
            return "redirect:/rider/signup-page";
        }


        rider.setAccountStatus("Online");
        rider.setStatus("Online");
        riderService.addNewRider(rider);
        return "redirect:/rider/riderHome/" + rider.getId();




    }

    @GetMapping("/subscribe/{driverId}/{riderId}")
    public String subscribe(@PathVariable int driverId,@PathVariable int riderId ) {

        driverService.addRider(driverId, riderId);
        riderService.subscribe(driverId, riderId);

        return "redirect:/rider/riderHome/" + riderId;

    }


    @GetMapping("/unsubscribe/{driverId}/{riderId}")
    public String unsubscribe(@PathVariable int driverId,@PathVariable int riderId ) {

        driverService.removeRider(driverId, riderId);
        riderService.unsubscribe(driverId, riderId);

        return "redirect:/rider/riderHome/" + riderId;


    }

    @PutMapping("/update/{riderId}")
    public Rider updateRider(@PathVariable int riderId, @RequestBody Rider rider) {
        riderService.updateRider(riderId, rider);
        return riderService.getRiderById(riderId);
    }

    @PostMapping("/logIn/{id}")
    public String logIn(int id) {






        riderService.logIn(id);




        return "redirect:/rider/riderHome/" + id;
    }

    @PostMapping("/login")
    public String login(int riderId) {





        riderService.logIn(riderId);

        if (riderService.getRiderById(riderId) != null) {
            return "redirect:/rider/riderHome/" + riderId;
        }

        return "redirect:/rider/login-page";
    }


    @GetMapping("/logOut/{id}")
    public String logOut(@PathVariable int id) {
        riderService.logOut(id);



        return "redirect:/rider/login-page";
    }

    @GetMapping("/login-page")
    public String loginPage() {
        return "rider_log_in";
    }


    @GetMapping("/signup-page")
    public String signupPage() {
        return "sign_up";
    }


    @GetMapping("/riderHome/{id}")
    public String riderHome(Model model, @PathVariable Integer id) {




        Rider curr = riderService.getRiderById(id);
        model.addAttribute("rider", curr);

        List<Driver> drivers = driverService.getAllDrivers();
        model.addAttribute("driverList", drivers);


        return "rider_home";
    }


    @GetMapping("riderHome/review/new")
    public String newReview(Review review) {
        reviewService.addReview(review);
        return "redirect:/rider/riderHome/" + review.getAuthorId();
    }







    @PostMapping("/logIn")
    public String logIn(String email, String password) {


        Rider rider = riderService.getRiderByCred(email, password);





    if (rider == null) {
        return "redirect:/rider/login-page";

        }


        System.out.println(rider.getAccountStatus());


        if (rider.getAccountStatus() == null) {
            rider.setAccountStatus("Online");
        }


        rider.setStatus("Online");
        riderRepository.save(rider);



        if (rider.getAccountStatus().equals("Banned")) {
            return "redirect:/rider/login-page";
        }


        if (riderService.getCred(rider) && rider.getAccountStatus() != "Banned") {

            riderService.logIn(rider.getId());

            return "redirect:/rider/riderHome/" + rider.getId();

        }



        return "redirect:/rider/login-page";
    }






    @GetMapping("/report-driver/{driverId}/{riderId}")
    public String reportDriver(@PathVariable Integer driverId, @PathVariable Integer riderId) {

        Driver thisDr = driverService.getDriverById(driverId);
        thisDr.setReported(true);
        driverService.updateProfile(driverId, thisDr);



        return "redirect:/rider/riderHome/" + riderId;


    }












}
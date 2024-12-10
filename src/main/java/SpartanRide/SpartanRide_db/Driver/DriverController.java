package SpartanRide.SpartanRide_db.Driver;

import SpartanRide.SpartanRide_db.Review.Review;
import SpartanRide.SpartanRide_db.Review.ReviewService;
import SpartanRide.SpartanRide_db.Rider.Rider;
import SpartanRide.SpartanRide_db.Rider.RiderRepository;
import SpartanRide.SpartanRide_db.Rider.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService service;

    @Autowired
    private RiderService riderService;

    @Autowired
    private DriverRepository repo;

    @Autowired
    private RiderRepository riderRepository;


    @Autowired
    private ReviewService revServ;

    /**
     * Get a list of all Drivers in the database.
     * http://localhost:8080/driver/all
     *
     * @return a list of Driver objects.
     */
    @GetMapping("/all")
    public String getAllDrivers(Model model) {
        model.addAttribute("drivers", service.getAllDrivers());
        model.addAttribute("title", "All Drivers");

        return "driver-list";
    }


    /**
     * Create a new Driver entry.
     * http://localhost:8080/driver/sign_up --data '{"name": "Aidan",
     * "email": "alquinn2@uncg.edu",
     * "car_model": "Honda Accord 2006",
     * "plateNum": "ZZZ-Z7Y5",
     * "phone_num":
     * "1231231234"}'
     *
     * @param driver the new Driver object.
     * @return the updated list of Drivers.
     */
    @PostMapping("/signUp")
    public String signUp(Driver driver) {

        if (service.checkEmailDup(driver.getEmail())) {
            return "redirect:/driver/sign-up-page";
        }


        driver.setAccountStatus("Online");
        driver.setStatus("Online");

        service.signUp(driver);
        return "redirect:/driver/driverProfile/" + driver.getId();


    }

    @PostMapping("/logIn")
    public String logIn(String email, String password) {


        System.out.println(email);
        System.out.println(password);

        Driver driver = service.getDriverByCred(email, password);







        if (driver == null) {
            return "redirect:/driver/log-in-page";

        }

        if(driver.getAccountStatus() == null) {
            driver.setAccountStatus("Active");
        }


        if(driver.getAccountStatus().equals("Banned")) {

            return "redirect:/driver/log-in-page";
        }


        if (service.getCred(driver)) {

            service.logIn(driver.getId(), driver);

            return "redirect:/driver/driverProfile/" + driver.getId();

        }

        return "redirect:/driver/log-in-page";
    }


    @GetMapping("/logOut/{id}")
    public String logOut(@PathVariable int id) {

        Driver driver = service.getDriverById(id);
        service.logOut(id, driver);

        return "/driver_log_in";
    }

    @GetMapping("/updateDest")
    public String updateDest(int id, String destination) {

        Driver curr = service.getDriverById(id);


        System.out.println(destination);


        if (curr != null) {

            System.out.println("got here");

            curr.setDestination(destination);

            service.updateProfile(id, curr);



        }

        return "redirect:/driver/driverProfile/" + curr.getId();


    }

    @GetMapping("/updateEm")
    public String updateEm(int id, String embarkment) {

        Driver curr = service.getDriverById(id);


        System.out.println(embarkment);


        if (curr != null) {

            System.out.println("got here");

            curr.setEmbarkment(embarkment);

            service.updateProfile(id, curr);



        }

        return "redirect:/driver/driverProfile/" + curr.getId();


    }




    @PostMapping("/carReg")
    public String carRegistration(Driver driver) {
        service.carRegistration(driver.getId(), driver);

        System.out.println(driver.getId());

        return "redirect:/driver/driverProfile/" + driver.getId();
    }
    @PutMapping("/start/{id}")
    public Driver startRide(@PathVariable int id, @RequestBody Driver driver) {
        service.startRide(id, driver);
        return service.getDriverById(driver.getId());
    }

    @PutMapping("/stop/{id}")
    public Driver stopRide(@PathVariable int id, @RequestBody Driver driver) {
        service.stopRide(id, driver);
        return service.getDriverById(driver.getId());
    }

    @PutMapping("/update/{id}")
    public Driver updateProfile(@PathVariable int id, @RequestBody Driver driver) {
        service.updateProfile(id, driver);
        return service.getDriverById(id);
    }

    @PutMapping("/set_dest/{id}/{destination}")
    public Driver setDestination(@PathVariable int id, @PathVariable String destination, @RequestBody Driver driver) {
        service.setDestination(id, destination, driver);
        return service.getDriverById(id);
    }

    @GetMapping("/kick-rider/{driverId}/{riderId}")
    public  String kickRider(@PathVariable int driverId, @PathVariable int riderId) {



        service.removeRider(driverId, riderId);
        riderService.unsubscribe(driverId, riderId);
        return "redirect:/driver/driverProfile/" + driverId;
    }


    @GetMapping("/report/{driverId}/{riderId}")
    public String reportRider(@PathVariable int driverId, @PathVariable Integer riderId) {

        Rider thisR = riderService.getRiderById(riderId);
        thisR.setReported(true);

        riderRepository.save(thisR);

        return "redirect:/driver/driverProfile/" + driverId;
    }

    @GetMapping("/driverProfile/{id}")
    public String driverProfile(@PathVariable int id, Model model) {
        model.addAttribute("driver", service.getDriverById(id));


        Driver thisDriver = service.getDriverById(id);


        List<Review> theseReviews = revServ.getReviewsBySub(id);

        if (theseReviews != null) {
            model.addAttribute("reviewList", theseReviews);
        }

        List<Rider> theseRiders = riderService.getRidersByDr(id);


        if (theseRiders != null) {
            model.addAttribute("riderList", theseRiders);
        }

        return "driver-profile";
    }

    @GetMapping("/sign-up-page")
    public String signUpRedirect() {
        return "home";
    }


    @GetMapping("/log-in-page")
    public String logInRedirect() {
        return "/driver_log_in";
    }


    @GetMapping("/end-ride")
    public String endRide(int id) {

        Driver thisDriver = service.getDriverById(id);

        System.out.println(id);

        for(int i = 0; i < thisDriver.getRiders().size(); i++) {


            System.out.println(thisDriver.getRiders().get(i));
            service.removeRider(thisDriver.getId(), thisDriver.getRiders().get(i));
            riderService.unsubscribe(thisDriver.getId(), thisDriver.getRiders().get(i));

        }

        return "redirect:/driver/driverProfile/" + thisDriver.getId();
    }




}
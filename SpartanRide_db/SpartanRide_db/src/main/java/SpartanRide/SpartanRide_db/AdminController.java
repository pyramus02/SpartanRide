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
    private AdminService service;
    @Autowired
    private DriverService driverService;


    DriverController driveControl;
    RiderController rideControl;

    @GetMapping("/drivers")
    public List<Driver> getAllDrivers() {
        return driveControl.getAllDrivers();

    }
    @GetMapping("/riders")
    public List<Rider> getAllRiders() {
        return rideControl.getAllRiders();
    }


    @DeleteMapping("/killreview")
    public Driver deleteReview(@RequestBody Driver driver, @RequestBody int reviewId) {

        driverService.deleteReview(driver, reviewId);
        return driverService.getDriverById(driver.getId());

    }










}
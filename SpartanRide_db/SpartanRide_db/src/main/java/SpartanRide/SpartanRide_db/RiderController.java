package SpartanRide.SpartanRide_db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rider")
public class RiderController {


    @Autowired
    public RiderService service;
    @Autowired
    public DriverService driverService;

    @GetMapping("/all")
    public List<Rider> getAllRiders() {
        return RiderService.getAllRiders();
    }


    @PostMapping("/create")
    public @ResponseBody List<Rider> addNewAnimal(@RequestBody Rider rider) {
        RiderService.addNewRider(rider);
        return RiderService.getAllRiders();
    }


    @PostMapping("/review{driverId}")
    public Driver reviewDriver(@PathVariable int driverId, @RequestBody Driver driver, @RequestBody String review) {
        driverService.reviewDriver(driverId, driver,review);
        return driverService.getDriverById(driverId);
    }








}
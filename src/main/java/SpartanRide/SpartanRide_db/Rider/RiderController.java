package SpartanRide.SpartanRide_db.Rider;

import SpartanRide.SpartanRide_db.Driver.DriverService;
import SpartanRide.SpartanRide_db.Review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rider")
public class RiderController {


    @Autowired
    public RiderService riderService;
    @Autowired
    public DriverService driverService;
    @Autowired
    public ReviewService reviewService;

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
    public @ResponseBody List<Rider> addNewRider(@RequestBody Rider rider) {
        riderService.addNewRider(rider);
        return riderService.getAllRiders();
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

    @PutMapping("/logIn/{id}")
    public Rider logIn(@PathVariable int id) {
        riderService.logIn(id);

        return riderService.getRiderById(id);
    }


    @PutMapping("/logOut/{id}")
    public Rider logOut(@PathVariable int id) {
        riderService.logOut(id);

        return riderService.getRiderById(id);
    }

}
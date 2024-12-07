package SpartanRide.SpartanRide_db.Driver;

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
    @PostMapping("/sign_up")
    public String signUp(Driver driver) {

        service.signUp(driver);

        return "redirect:/driver/all";
    }

    @PutMapping("/logIn/{id}")
    public Driver logIn(@PathVariable int id, @RequestBody Driver driver) {
        service.logIn(id, driver);

        return service.getDriverById(id);
    }


    @PutMapping("/logOut/{id}")
    public Driver logOut(@PathVariable int id, @RequestBody Driver driver) {
        service.logOut(id, driver);

        return service.getDriverById(id);
    }

    @PutMapping("/car_reg/{id}/{plate_num}")
    public Driver carRegistration(@PathVariable int id, @PathVariable String plate_num, @RequestBody Driver driver) {
        service.carRegistration(id, plate_num, driver);
        return service.getDriverById(id);
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

    @PutMapping("/kick-rider/{driverId}/{riderId}")
    public  Driver kickRider(@PathVariable int driverId, @PathVariable int riderId) {

        service.removeRider(driverId, riderId);
        riderService.unsubscribe(driverId, riderId);
        return service.getDriverById(driverId);
    }




}
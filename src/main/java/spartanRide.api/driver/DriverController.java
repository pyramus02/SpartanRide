package spartanRide.api.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService service;

    /**
     * Get a list of all Drivers in the database.
     * http://localhost:8080/driver/all
     *
     * @return a list of Driver objects.
     */
    @GetMapping("/all")
    public List<Driver> getAllDrivers() {
        return service.getAllDrivers();
    }

    @PostMapping("/signUp")
    public List<Driver> signUp(@RequestBody Driver driver) {
        service.signUp(driver);

        return service.getAllDrivers();
    }

    @PutMapping("/logIn/{id}")
    public Driver logIn(@PathVariable int id, @RequestBody Driver driver) {
        service.logIn(id, driver);

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


}

package spartanRide.api.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService service;

    /**
     * Get a list of all Drivers in the database.
     * http://localhost:8080/drivers/all
     *
     * @return a list of Driver objects.
     */
    @GetMapping("/all")
    public List<Driver> getAllDrivers() {
        return service.getAllDrivers();
    }

}

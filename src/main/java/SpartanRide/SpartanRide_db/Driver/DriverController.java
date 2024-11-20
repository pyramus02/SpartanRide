package SpartanRide.SpartanRide_db.Driver;

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

    @GetMapping("/carReg/{id}")
    public String carRegistration(@PathVariable int id, Model model) {
        model.addAttribute("driver", service.getDriverById(id));
        return "car-reg";
    }


    @PostMapping("/carReg")
    public String carRegistration(Driver driver) {
        service.carRegistration(driver.getId(), driver);
        return "driver-profile";
    }

}
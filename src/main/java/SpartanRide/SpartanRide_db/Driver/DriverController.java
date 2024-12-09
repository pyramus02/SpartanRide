package SpartanRide.SpartanRide_db.Driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService service;


//    Functions and Buttons

    @GetMapping("/carReg/{id}")
    public String carRegistration(@PathVariable int id, Model model) {
        model.addAttribute("driver", service.getDriverById(id));

        System.out.println(id);
        return "car-reg";
    }

    @PostMapping("/carReg")
    public String carRegistration(Driver driver) {
        service.carRegistration(driver.getId(), driver);

        System.out.println(driver.getId());

        return "redirect:/driver/driverProfile/" + driver.getId();
    }

    @GetMapping("/driverProfile/{id}")
    public String driverProfile(@PathVariable int id, Model model) {
        model.addAttribute("driver", service.getDriverById(id));

        return "driver-profile";
    }

    @PostMapping("/signUp")
    public String signUp(Driver driver) {
        service.signUp(driver);
        return "redirect:/driver/driverProfile/" + driver.getId();
    }


//    Page Redirects

    @GetMapping("/sign-up-page")
    public String signUpRedirect() {
        return "home";
    }


    @GetMapping("/driverProfile")
    public String driverProfileRedirect() {
        return "home";
    }

}
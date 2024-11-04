package spartanRide.api.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    /**
     * Fetch all Drivers.
     *
     * @return the list of all Drivers.
     */
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }


}

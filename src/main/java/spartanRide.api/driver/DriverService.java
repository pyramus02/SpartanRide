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

    public void signUp(Driver driver) {
        driverRepository.save(driver);
    }

    public void logIn(int id, Driver driver) {
        Driver existing = getDriverById(id);
        existing.setEmail("Online");

        driverRepository.save(driver);
    }

    /**
     * Gets a specific Driver by their id.
     *
     * @return details of a specific Driver.
     */
    public Driver getDriverById(int id) {
        return driverRepository.findById(id).orElse(null);
    }

    /**
     * Updates license plate
     *
     * @return details of a specific Driver.
     */
    public void carRegistration(int id, String plate_num,Driver driver) {
        Driver existing = getDriverById(id);
        existing.setPlateNum(plate_num);

        driverRepository.save(existing);
    }

    public void startRide(int id, Driver driver) {
        Driver existing = getDriverById(id);
        existing.setStatus("Driving");

        driverRepository.save(existing);
    }

    public void stopRide(int id, Driver driver) {
        Driver existing = getDriverById(id);
        existing.setStatus("Online");

        driverRepository.save(existing);
    }

    public void updateProfile(int id, Driver driver) {
        Driver existing = getDriverById(id);
        existing.setName(driver.getName());
        existing.setEmail(driver.getEmail());
        existing.setCarModel(driver.getCarModel());
        existing.setPlateNum(driver.getPlateNum());
        existing.setPlateNum(driver.getPlateNum());

        driverRepository.save(existing);
    }

    public void setDestination(int id, String destination, Driver driver) {
        Driver existing = getDriverById(id);

        existing.setDestination(destination);
        driverRepository.save(existing);
    }

}

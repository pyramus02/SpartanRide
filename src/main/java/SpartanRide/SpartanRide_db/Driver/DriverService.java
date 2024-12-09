package SpartanRide.SpartanRide_db.Driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public Driver getDriverById(int id) {
        return driverRepository.findById(id).orElse(null);
    }

    public void carRegistration(int id, Driver driver) {
        Driver existing = getDriverById(id);
        existing.setCarModel(driver.getCarModel());
        existing.setPlateNum(driver.getPlateNum());

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


    public void signUp(Driver driver) {
        driverRepository.save(driver);
    }

}
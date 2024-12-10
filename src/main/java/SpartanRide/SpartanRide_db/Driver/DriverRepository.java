package SpartanRide.SpartanRide_db.Driver;

import SpartanRide.SpartanRide_db.Rider.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

    @Query(value = "SELECT * FROM drivers WHERE status = 'Online'", nativeQuery = true)
    List<Driver> getOnline();


    @Query(value = "SELECT * FROM drivers WHERE email = ?1 AND password = ?2",nativeQuery = true)
    Driver getCred(String email, String password);

    @Query(value = "SELECT * FROM drivers WHERE email = ?1",nativeQuery = true)
    Driver checkEmailDup(String email);


    @Query(value = "SELECT * FROM drivers WHERE reported = true",nativeQuery = true)
    List<Driver> getBadDrivers();


}
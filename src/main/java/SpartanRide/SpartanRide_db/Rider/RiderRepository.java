package SpartanRide.SpartanRide_db.Rider;


import SpartanRide.SpartanRide_db.Driver.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Integer>  {


    @Query(value = "SELECT * FROM rider WHERE status = 'Online'", nativeQuery = true)
    List<Rider>getOnline();

    @Query(value = "SELECT * FROM rider WHERE email = ?1 AND password = ?2",nativeQuery = true)
    Rider getCred(String email, String password);


    @Query(value = "SELECT * FROM rider WHERE email = ?1",nativeQuery = true)
    Rider checkEmailDup(String email);


    @Query(value = "SELECT * FROM rider WHERE driver_id = ?1",nativeQuery = true)
    List<Rider> getRidersByDrivers(int driverId);


    @Query(value = "SELECT * FROM rider WHERE reported = true",nativeQuery = true)
    List<Rider> getBadRiders();






}

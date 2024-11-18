package SpartanRide.SpartanRide_db.Rider;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Integer>  {


    @Query(value = "SELECT * FROM rider WHERE status = 'Online'", nativeQuery = true)
    List<Rider>getOnline();



}

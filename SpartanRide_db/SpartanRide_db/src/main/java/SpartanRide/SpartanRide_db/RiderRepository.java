package SpartanRide.SpartanRide_db;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Integer>  {



}

package SpartanRide.SpartanRide_db;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RiderService {

    @Autowired
    public static RiderRepository riderRepository;


    public static List<Rider> getAllRiders() {
        return riderRepository.findAll();
    }

    public static void addNewRider(Rider rider) {
        riderRepository.save(rider);
    }

    public Rider getRiderById(int id) {
        return riderRepository.findById(id).orElse(null);
    }


    public void updateRider(int riderId, Rider rider) {

        Rider curr = getRiderById(riderId);
        curr.setRider(rider);
        riderRepository.save(curr);
    }








}

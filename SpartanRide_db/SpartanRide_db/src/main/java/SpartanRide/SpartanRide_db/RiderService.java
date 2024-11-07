package SpartanRide.SpartanRide_db;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RiderService {

    @Autowired
    public  RiderRepository riderRepository;


    public  List<Rider> getAllRiders() {
        return riderRepository.findAll();
    }

    public  void addNewRider(Rider rider) {
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

    public void logIn(int id, Rider rider) {
        Rider existing = getRiderById(id);
        existing.setStatus("Online");

        riderRepository.save(rider);
    }

    public void logOut(int id, Rider rider) {
        Rider existing = getRiderById(id);
        existing.setStatus("Offline");

        riderRepository.save(rider);
    }




    public Rider subscribe(int driverId, int riderId) {

        Rider curr = getRiderById(riderId);
        curr.setDriverId(driverId);

        riderRepository.save(curr);
        return getRiderById(riderId);
    }

    public Rider unsubscribe(int driverId, int riderId) {
        Rider curr = getRiderById(riderId);
        curr.setDriverId(0); //driverId is a Rider data field

        riderRepository.save(curr);
        return getRiderById(riderId);
    }










}

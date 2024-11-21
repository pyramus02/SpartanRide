package SpartanRide.SpartanRide_db.Rider;


import SpartanRide.SpartanRide_db.Driver.Driver;
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

        rider.setAccountStatus("Active");
        rider.setStatus("Online");
    }

    public Rider getRiderById(int id) {
        return riderRepository.findById(id).orElse(null);
    }

    public void updateRider(int riderId, Rider rider) {

        Rider curr = getRiderById(riderId);
        curr.setRider(rider);
        riderRepository.save(curr);
    }

    public void logIn(int id) {
        Rider existing = getRiderById(id);

        if (existing != null) {

            existing.setStatus("Online");
            riderRepository.save(existing);

        }


    }

    public void logOut(int id) {
        Rider existing = getRiderById(id);

        if (existing != null) {

            existing.setStatus("Offline");
            riderRepository.save(existing);

        }


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

    public void banRider(int id) {

        Rider existing = getRiderById(id);

        if (existing != null) {
            existing.setAccountStatus("Banned");
            riderRepository.save(existing);
        }
    }

    public void unbanRider(int id) {



        Rider existing = getRiderById(id);

        if (existing != null) {
            existing.setAccountStatus("Active");
            riderRepository.save(existing);
        }
    }










}

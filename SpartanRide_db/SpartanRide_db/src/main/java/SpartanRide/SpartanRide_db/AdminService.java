package SpartanRide.SpartanRide_db;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class AdminService {

    @Autowired
    private AdminRepository driverRepository;


}

package SpartanRide.SpartanRide_db;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository driverRepository;

    @Autowired
    public AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public void addNewAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    public Admin getAdminById(int id) {
        return adminRepository.findById(id).orElse(null);
    }

    public void updateAdmin(int adminId, Admin admin) {
        Admin curr = getAdminById(adminId);
        curr.setAdmin(admin);
        adminRepository.save(curr);
    }

    public void logIn(int id, Admin admin) {
        Admin existing = getAdminById(id);
        existing.setStatus("Online");
        adminRepository.save(admin);
    }

    public void logOut(int id, Admin admin) {
        Admin existing = getAdminById(id);
        existing.setStatus("Offline");
        adminRepository.save(admin);
    }


}

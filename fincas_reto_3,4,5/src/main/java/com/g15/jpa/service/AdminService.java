package com.g15.jpa.service;

import com.g15.jpa.entity.Admin;
import com.g15.jpa.repository.AdminRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author desarrollo
 */
@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAdmin() {
        return adminRepository.findAll();
    }

    public Admin insertAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    //Metodo para consultar una registo x su id (Capa de servicios)
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).get();
    }
}

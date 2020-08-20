package cde.mc.outageanalytics1.service;

import cde.mc.outageanalytics1.entity.User;
import cde.mc.outageanalytics1.repository.UpdateCustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateCustomerDetailsService {

    @Autowired
    private UpdateCustomerDetailsRepository updateCustomerDetailsRepository;

    //Update User
    public User updateUser(User user) {

            return updateCustomerDetailsRepository.save(user);
    }

    //Get all Users
     public List<User> findAll()
    {
        return updateCustomerDetailsRepository.findAll();
    }

     }






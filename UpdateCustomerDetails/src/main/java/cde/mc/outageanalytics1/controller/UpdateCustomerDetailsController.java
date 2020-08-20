package cde.mc.outageanalytics1.controller;

import cde.mc.outageanalytics1.entity.User;
import cde.mc.outageanalytics1.service.UpdateCustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UpdateCustomerDetailsController {

    @Autowired
    private UpdateCustomerDetailsService updateCustomerDetailsService;
    //Update user
    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Integer userId,@RequestBody User user) {
        return new ResponseEntity<>(updateCustomerDetailsService.updateUser(user), HttpStatus.OK);

    }
    //Get all users
    @GetMapping("/users")
    public List<User> findAll()
    {
        return updateCustomerDetailsService.findAll();
    }


}

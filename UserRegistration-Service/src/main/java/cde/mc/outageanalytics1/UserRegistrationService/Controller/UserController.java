package cde.mc.outageanalytics1.UserRegistrationService.Controller;

import cde.mc.outageanalytics1.UserRegistrationService.Entity.User;
import cde.mc.outageanalytics1.UserRegistrationService.Service.UserService;
import cde.mc.outageanalytics1.UserRegistrationService.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
//@RequestMapping("/secure/rest")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user)
    {
        String pwd=user.getPassword();
        String encryptPwd= passwordEncoder.encode(pwd);
        user.setPassword(encryptPwd);
        //user.setRoles("ROLE_"+user.getRoles());
        return new ResponseEntity<>(userService.addUser(user),HttpStatus.CREATED);

    }

    @GetMapping("/users/{userName}")
    public ResponseEntity<Optional<User>> getUserByUserName(@Valid @PathVariable(value="userName") String userName) throws UserNotFoundException {

        Optional<User> user=userService.findByUserName(userName);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }



}

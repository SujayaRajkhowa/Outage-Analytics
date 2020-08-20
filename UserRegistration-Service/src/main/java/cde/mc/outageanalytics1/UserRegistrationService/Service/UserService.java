package cde.mc.outageanalytics1.UserRegistrationService.Service;

import cde.mc.outageanalytics1.UserRegistrationService.Entity.User;
import cde.mc.outageanalytics1.UserRegistrationService.Repository.UserRepository;
import cde.mc.outageanalytics1.UserRegistrationService.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Add User
    public User addUser(User user)
    {
        return userRepository.save(user);
    }

    //Find User by UserName
        public Optional<User> findByUserName(String userName) throws UserNotFoundException {
        Optional<User> user=userRepository.findByUserName(userName);
        if(!user.isPresent())
            {
                throw new UserNotFoundException("Username -" +userName);
            }
        else {
            return user;
        }
    }





}

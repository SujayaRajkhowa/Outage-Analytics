package cde.mc.outageanalytics1.UserRegistrationService.Service;

import cde.mc.outageanalytics1.UserRegistrationService.Entity.User;
import cde.mc.outageanalytics1.UserRegistrationService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user=userRepository.findByuserName(userName);
        CustomUserDetails userDetails=null;
        if(user!= null)
        {
           userDetails=new CustomUserDetails();
           userDetails.setUser(user);

        }else{
            throw new UsernameNotFoundException("User don't exist with name : " +userName);
        }
        return userDetails;
    }
}

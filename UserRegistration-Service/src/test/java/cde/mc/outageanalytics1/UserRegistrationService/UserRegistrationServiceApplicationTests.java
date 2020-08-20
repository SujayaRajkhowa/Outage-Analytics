package cde.mc.outageanalytics1.UserRegistrationService;

import cde.mc.outageanalytics1.UserRegistrationService.Entity.Role;
import cde.mc.outageanalytics1.UserRegistrationService.Entity.User;
import cde.mc.outageanalytics1.UserRegistrationService.Repository.UserRepository;
import cde.mc.outageanalytics1.UserRegistrationService.Service.UserService;
import cde.mc.outageanalytics1.UserRegistrationService.exception.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserRegistrationServiceApplicationTests {

   /* @Autowired
    UserService userService;

    @MockBean
    private UserRepository userRepository;


    @Test
    public void addIncidentTest() {
        User user = new User(1, "Sujaya", "sujaya", "password","Mumbai","Maharashtra","India",781453,"sujaya@gmail.com","BKY673","87365265439","1997-06-23","USER");
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user, userService.addUser(user));
    }
        private User mockUser(){
        User user=new User();
        user.setUserId(1);
        user.setName("Sujaya");
        user.setUserName("sujaya");
        user.setPassword("password");
        user.setAddress("Mumbai");
        user.setState("Maharashtra");
        user.setCountry("India");
        user.setZipCode(863456);
        user.setEmailId("sujaya@gmail.com");
        user.setContactNo("7455234889");
        user.setDob("1997-05-07");
        user.setRoles("USER");
        return user;
    }
    @Test
    public void addTicketTest()
    {
        when(userRepository.save(mockUser())).thenReturn(mockUser());
        assertEquals(mockUser(),userService.addUser(mockUser()));
    }

    @Test
    public void findByUserNameTest() throws UserNotFoundException
    {
        when(userRepository.findByUserName("sujaya")).thenReturn(Optional.ofNullable(mockUser()));
        assertEquals(Optional.of(mockUser()),userService.findByUserName("sujaya"));
    }
*/
}

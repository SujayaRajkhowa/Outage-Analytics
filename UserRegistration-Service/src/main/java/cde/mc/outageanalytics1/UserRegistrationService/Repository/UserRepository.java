package cde.mc.outageanalytics1.UserRegistrationService.Repository;


import cde.mc.outageanalytics1.UserRegistrationService.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

    public interface UserRepository extends JpaRepository<User, Integer> {
    User findByuserName(String userName);

    Optional<User> findByUserName(String userName);

}

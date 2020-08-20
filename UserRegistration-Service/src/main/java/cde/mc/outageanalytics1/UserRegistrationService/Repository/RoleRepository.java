package cde.mc.outageanalytics1.UserRegistrationService.Repository;

import cde.mc.outageanalytics1.UserRegistrationService.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}

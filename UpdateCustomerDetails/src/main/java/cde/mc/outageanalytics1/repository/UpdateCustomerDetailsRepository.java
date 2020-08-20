package cde.mc.outageanalytics1.repository;

import cde.mc.outageanalytics1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UpdateCustomerDetailsRepository extends JpaRepository<User, Integer> {
}

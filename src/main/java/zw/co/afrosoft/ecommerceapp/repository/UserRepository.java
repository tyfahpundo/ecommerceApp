package zw.co.afrosoft.ecommerceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.ecommerceapp.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}

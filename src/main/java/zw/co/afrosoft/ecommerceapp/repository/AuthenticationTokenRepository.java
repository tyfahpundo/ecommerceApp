package zw.co.afrosoft.ecommerceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.ecommerceapp.model.AuthenticationToken;

public interface AuthenticationTokenRepository extends JpaRepository<AuthenticationToken,Long> {
}

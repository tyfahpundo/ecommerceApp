package zw.co.afrosoft.ecommerceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.ecommerceapp.model.Cart;

public interface CartRepository extends JpaRepository<Cart,Long> {
}

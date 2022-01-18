package zw.co.afrosoft.ecommerceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.ecommerceapp.model.Cart;
import zw.co.afrosoft.ecommerceapp.model.User;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
}

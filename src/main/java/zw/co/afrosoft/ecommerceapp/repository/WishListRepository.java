package zw.co.afrosoft.ecommerceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.ecommerceapp.model.User;
import zw.co.afrosoft.ecommerceapp.model.WishList;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList,Long> {

    List<WishList> findByUserOrderByCreatedDateDesc(User user);
}

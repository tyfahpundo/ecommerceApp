package zw.co.afrosoft.ecommerceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.ecommerceapp.model.WishList;

public interface WishListRepository extends JpaRepository<WishList,Long> {
}

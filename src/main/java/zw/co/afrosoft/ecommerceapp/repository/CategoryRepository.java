package zw.co.afrosoft.ecommerceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.ecommerceapp.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}

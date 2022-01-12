package zw.co.afrosoft.ecommerceapp.service;

import zw.co.afrosoft.ecommerceapp.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    void createCategory(Category category);

    List<Category> getAllCategories();

    void editCategory(Long categoryId, Category category);

    Optional<Category> readCategory(Long categoryId);
}

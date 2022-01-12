package zw.co.afrosoft.ecommerceapp.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.ecommerceapp.model.Category;
import zw.co.afrosoft.ecommerceapp.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void editCategory(Long categoryId, Category updateCategory) {
        Optional<Category>  existingCategory = Optional.of(categoryRepository.findById(categoryId).get());
        if(!existingCategory.isPresent()){
           throw new RuntimeException("Category does not exist");
        }
        Category category = existingCategory.get();
        category.setCategoryName(updateCategory.getCategoryName());
        category.setDescription(updateCategory.getDescription());
        category.setImageUrl(updateCategory.getImageUrl());
        categoryRepository.save(category);
    }
    @Override
    public Optional<Category> readCategory(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }
}

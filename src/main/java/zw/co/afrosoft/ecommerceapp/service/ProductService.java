package zw.co.afrosoft.ecommerceapp.service;

import zw.co.afrosoft.ecommerceapp.dto.ProductDto;
import zw.co.afrosoft.ecommerceapp.model.Category;

public interface ProductService {
    void createProduct(ProductDto productDto, Category category);
}

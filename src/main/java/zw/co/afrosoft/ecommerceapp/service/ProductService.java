package zw.co.afrosoft.ecommerceapp.service;

import zw.co.afrosoft.ecommerceapp.dto.ProductDto;
import zw.co.afrosoft.ecommerceapp.model.Category;

import java.util.List;

public interface ProductService {
    void createProduct(ProductDto productDto, Category category);

    List<ProductDto> getAllProducts();

    void updateProduct(ProductDto productDto, Long productId) throws Exception;
}

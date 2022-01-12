package zw.co.afrosoft.ecommerceapp.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.ecommerceapp.dto.ProductDto;
import zw.co.afrosoft.ecommerceapp.model.Category;
import zw.co.afrosoft.ecommerceapp.model.Product;
import zw.co.afrosoft.ecommerceapp.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void createProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setCategory(category);
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
    }
}

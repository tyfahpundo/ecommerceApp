package zw.co.afrosoft.ecommerceapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.afrosoft.ecommerceapp.common.ApiResponse;
import zw.co.afrosoft.ecommerceapp.dto.ProductDto;
import zw.co.afrosoft.ecommerceapp.model.Category;
import zw.co.afrosoft.ecommerceapp.service.CategoryService;
import zw.co.afrosoft.ecommerceapp.service.ProductService;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto){
        Optional<Category> category = categoryService.readCategory(productDto.getCategoryId());
        if(!category.isPresent()){
            return new ResponseEntity<>(new ApiResponse(false,"Category does not exist"),HttpStatus.CONFLICT);
        }
        productService.createProduct(productDto, category.get());
        return new ResponseEntity<>(new ApiResponse(true,"Product has been created"), HttpStatus.CREATED);
    }
}

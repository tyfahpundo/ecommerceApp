package zw.co.afrosoft.ecommerceapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.ecommerceapp.common.ApiResponse;
import zw.co.afrosoft.ecommerceapp.dto.ProductDto;
import zw.co.afrosoft.ecommerceapp.model.Category;
import zw.co.afrosoft.ecommerceapp.service.CategoryService;
import zw.co.afrosoft.ecommerceapp.service.ProductService;

import java.util.List;
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
    @GetMapping("/get-all-products")
    public ResponseEntity<List<ProductDto>> getProducts(){
        List<ProductDto> products = productService.getAllProducts();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId") Long productId,@RequestBody ProductDto productDto) throws Exception {
        Optional<Category> category = categoryService.readCategory(productDto.getCategoryId());
        if(!category.isPresent()){
            return new ResponseEntity<>(new ApiResponse(false,"Category of this product does not exist!"),HttpStatus.NOT_FOUND);
        }
        productService.updateProduct(productDto,productId);
        return new ResponseEntity<>(new ApiResponse(true,"Product udated successfully!"),HttpStatus.OK);
    }
}

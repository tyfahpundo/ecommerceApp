package zw.co.afrosoft.ecommerceapp.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.ecommerceapp.dto.AddToCartDto;
import zw.co.afrosoft.ecommerceapp.model.Product;
import zw.co.afrosoft.ecommerceapp.model.User;

@Service
public class CartServiceImpl implements CartService{
    private final ProductService productService;

    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void addToCart(AddToCartDto addToCartDto, User user) {
        //validate if product id is valid
        Product product = productService.findById(addToCartDto.getProductId());
        //Save the CArt
    }
}

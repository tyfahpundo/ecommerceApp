package zw.co.afrosoft.ecommerceapp.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.ecommerceapp.dto.AddToCartDto;
import zw.co.afrosoft.ecommerceapp.model.Cart;
import zw.co.afrosoft.ecommerceapp.model.Product;
import zw.co.afrosoft.ecommerceapp.model.User;
import zw.co.afrosoft.ecommerceapp.repository.CartRepository;

import java.util.Date;

@Service
public class CartServiceImpl implements CartService{
    private final ProductService productService;
    private final CartRepository cartRepository;

    public CartServiceImpl(ProductService productService, CartRepository cartRepository) {
        this.productService = productService;
        this.cartRepository = cartRepository;
    }

    @Override
    public void addToCart(AddToCartDto addToCartDto, User user) {
        //validate if product id is valid
        Product product = productService.findById(addToCartDto.getProductId());
        //Save the cart
        Cart cart = new Cart();
        cart.setProduct(product);
        cart.setUser(user);
        cart.setQuantity(addToCartDto.getQuantity());
        cart.setCreatedDate(new Date());
        cartRepository.save(cart);
    }
}

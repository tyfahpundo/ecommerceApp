package zw.co.afrosoft.ecommerceapp.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.ecommerceapp.dto.cart.AddToCartDto;
import zw.co.afrosoft.ecommerceapp.dto.cart.CartDto;
import zw.co.afrosoft.ecommerceapp.dto.cart.CartItemDto;
import zw.co.afrosoft.ecommerceapp.exceptions.CustomException;
import zw.co.afrosoft.ecommerceapp.model.Cart;
import zw.co.afrosoft.ecommerceapp.model.Product;
import zw.co.afrosoft.ecommerceapp.model.User;
import zw.co.afrosoft.ecommerceapp.repository.CartRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Override
    public CartDto listCartItems(User user) {
        List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);
        List<CartItemDto> cartItems = new ArrayList<>();
        double totalCost = 0;
        for(Cart cart: cartList){
            CartItemDto cartItemDto = new CartItemDto(cart);
            totalCost +=cartItemDto.getQuantity() * cart.getProduct().getPrice();
            cartItems.add(cartItemDto);
        }
        CartDto cartDto = new CartDto();
        cartDto.setTotalCost(totalCost);
        cartDto.setCartItems(cartItems);
        return cartDto;
    }

    @Override
    public void deleteItemFromCart(Long cartItemId, User user) {
        Optional<Cart> optionalCart = cartRepository.findById(cartItemId);
        if(optionalCart.isEmpty()){
            throw new CustomException("Cart item id is invalid: "+ cartItemId);
        }
        Cart cart = optionalCart.get();
        if(cart.getUser() != user){
            throw new CustomException("Cart item does not belong to the user: "+ cartItemId);
        }
        cartRepository.delete(cart);
    }

}

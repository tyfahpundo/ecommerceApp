package zw.co.afrosoft.ecommerceapp.service;

import zw.co.afrosoft.ecommerceapp.dto.cart.AddToCartDto;
import zw.co.afrosoft.ecommerceapp.dto.cart.CartDto;
import zw.co.afrosoft.ecommerceapp.model.User;

public interface CartService {
    void addToCart(AddToCartDto addToCartDto, User user);

    CartDto listCartItems(User user);

    void deleteItemFromCart(Long cartItemId, User user);
}

package zw.co.afrosoft.ecommerceapp.service;

import zw.co.afrosoft.ecommerceapp.dto.AddToCartDto;
import zw.co.afrosoft.ecommerceapp.model.User;

public interface CartService {
    void addToCart(AddToCartDto addToCartDto, User user);
}

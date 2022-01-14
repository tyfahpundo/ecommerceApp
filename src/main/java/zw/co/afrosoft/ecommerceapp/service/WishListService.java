package zw.co.afrosoft.ecommerceapp.service;

import zw.co.afrosoft.ecommerceapp.dto.ProductDto;
import zw.co.afrosoft.ecommerceapp.model.User;
import zw.co.afrosoft.ecommerceapp.model.WishList;

import java.util.List;

public interface WishListService {
    void createWishList(WishList wishList);

    List<ProductDto> getWishListForUser(User user);
}

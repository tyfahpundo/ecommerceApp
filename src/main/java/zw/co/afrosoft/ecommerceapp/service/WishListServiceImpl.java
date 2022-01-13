package zw.co.afrosoft.ecommerceapp.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.ecommerceapp.model.WishList;
import zw.co.afrosoft.ecommerceapp.repository.WishListRepository;

@Service
public class WishListServiceImpl implements WishListService{
    private final WishListRepository wishListRepository;

    public WishListServiceImpl(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    @Override
    public void createWishList(WishList wishList) {
        wishListRepository.save(wishList);
    }
}
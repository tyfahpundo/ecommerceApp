package zw.co.afrosoft.ecommerceapp.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.ecommerceapp.dto.ProductDto;
import zw.co.afrosoft.ecommerceapp.model.User;
import zw.co.afrosoft.ecommerceapp.model.WishList;
import zw.co.afrosoft.ecommerceapp.repository.WishListRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishListServiceImpl implements WishListService{
    private final WishListRepository wishListRepository;
    private final ProductService productService;

    public WishListServiceImpl(WishListRepository wishListRepository, ProductService productService) {
        this.wishListRepository = wishListRepository;
        this.productService = productService;
    }

    @Override
    public void createWishList(WishList wishList) {
        wishListRepository.save(wishList);
    }

    @Override
    public List<ProductDto> getWishListForUser(User user) {
        final List<WishList> wishLists = wishListRepository.findByUserOrderByCreatedDateDesc(user);
        List<ProductDto> productDtos = new ArrayList<>();
        for(WishList wishList: wishLists){
            productDtos.add(ProductDto.createProductDto(wishList.getProduct()));
        }
        return productDtos;
    }
}

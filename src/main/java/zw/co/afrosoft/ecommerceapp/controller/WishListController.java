package zw.co.afrosoft.ecommerceapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.ecommerceapp.common.ApiResponse;
import zw.co.afrosoft.ecommerceapp.dto.ProductDto;
import zw.co.afrosoft.ecommerceapp.model.Product;
import zw.co.afrosoft.ecommerceapp.model.User;
import zw.co.afrosoft.ecommerceapp.model.WishList;
import zw.co.afrosoft.ecommerceapp.service.AuthenticationService;
import zw.co.afrosoft.ecommerceapp.service.WishListService;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishListController {
    private final WishListService wishListService;
    private final AuthenticationService authenticationService;

    public WishListController(WishListService wishListService, AuthenticationService authenticationService) {
        this.wishListService = wishListService;
        this.authenticationService = authenticationService;
    }
    //save product in wishlist
    @PostMapping("/add-to-wishlist")
    public ResponseEntity<ApiResponse> addToWishList(@RequestBody Product product, @RequestParam("token") String token){
        //authenticate the token
        authenticationService.authenticate(token);
        //find the user
        User user = authenticationService.getUser(token);
        //save the item to wishList
        WishList wishList = new WishList(user,product);
        wishListService.createWishList(wishList);
        return new ResponseEntity<>(new ApiResponse(true,"Successfully added the item to your wishlist"), HttpStatus.CREATED);
    }
    //get all wishlist items for a user
    @GetMapping("/{token}")
    public ResponseEntity<List<ProductDto>> getWishList(@PathVariable("token") String token){
        //authenticate token
        authenticationService.authenticate(token);
        //find the user
        User user = authenticationService.getUser(token);
        List<ProductDto> productDtos = wishListService.getWishListForUser(user);
        return new ResponseEntity<>(productDtos,HttpStatus.OK);
    }
}

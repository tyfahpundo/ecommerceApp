package zw.co.afrosoft.ecommerceapp.controller;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.ecommerceapp.common.ApiResponse;
import zw.co.afrosoft.ecommerceapp.dto.cart.AddToCartDto;
import zw.co.afrosoft.ecommerceapp.dto.cart.CartDto;
import zw.co.afrosoft.ecommerceapp.model.User;
import zw.co.afrosoft.ecommerceapp.service.AuthenticationService;
import zw.co.afrosoft.ecommerceapp.service.CartService;
import zw.co.afrosoft.ecommerceapp.service.ProductService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;
    private final AuthenticationService authenticationService;

    public CartController(CartService cartService, AuthenticationService authenticationService, ProductService productService) {
        this.cartService = cartService;
        this.authenticationService = authenticationService;
    }
    //post a cart
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto, @RequestParam("token")  String token){
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        cartService.addToCart(addToCartDto, user);
        return new ResponseEntity<>(new ApiResponse(true,"Added to Cart"), HttpStatus.CREATED);
    }


    //get all cart items for a user
    @GetMapping("/get-cart-items")
    public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token){
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        CartDto cartDto = cartService.listCartItems(user);
        return new ResponseEntity<>(cartDto,HttpStatus.OK);
    }
    //delete cart item for a user
    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") Long cartItemId,
                                                      @RequestParam("token") String token){
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        cartService.deleteItemFromCart(cartItemId, user);
        return new ResponseEntity<>(new ApiResponse(true,"Item successfully removed from Cart!"),HttpStatus.OK);
    }

}

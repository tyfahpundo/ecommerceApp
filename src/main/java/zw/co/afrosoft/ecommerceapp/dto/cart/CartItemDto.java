package zw.co.afrosoft.ecommerceapp.dto.cart;

import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.afrosoft.ecommerceapp.model.Cart;
import zw.co.afrosoft.ecommerceapp.model.Product;
@Data
@NoArgsConstructor
public class CartItemDto {
    private Long id;
    private Integer quantity;
    private Product product;

    public CartItemDto(Cart cart){
        this.id = cart.getId();
        this.quantity = cart.getQuantity();
        this.setProduct(cart.getProduct());
    }
}

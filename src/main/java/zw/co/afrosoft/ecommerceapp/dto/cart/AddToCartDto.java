package zw.co.afrosoft.ecommerceapp.dto.cart;

import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class AddToCartDto {
    private Long id;
    private @NotNull Long productId;
    private @NotNull Integer quantity;
}

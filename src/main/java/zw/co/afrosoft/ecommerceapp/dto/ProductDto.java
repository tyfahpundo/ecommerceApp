package zw.co.afrosoft.ecommerceapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String imageUrl;
    @NotNull
    private String description;
    @NotNull
    private Long categoryId;
    @NotNull
    private double price;
}

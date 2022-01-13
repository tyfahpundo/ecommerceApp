package zw.co.afrosoft.ecommerceapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.afrosoft.ecommerceapp.model.Product;

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

    public static ProductDto createProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setPrice(product.getPrice());
        return productDto;
    }
}

package zw.co.afrosoft.ecommerceapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @Column(name = "image_url")
    private String imageUrl;
    @NotNull
    private double price;
    @NotNull
    private String description;

    //Many to One Relationship
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    Category category;


}

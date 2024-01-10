package com.example.api_online_shop.Product.model;

import com.example.api_online_shop.OrderDetails.model.OrderDetails;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Product")
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Product {
    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    private Long id;

    @Column(name = "name")
    @NotBlank(message = " Numele este necesar")
    private String name;

    @Column(name = "price")
    @NotNull(message = "Pretul este necesar")
    private int price;

    @Column(name = "weight")
    @NotNull(message = "Greutatea este necesar")
    private int weight;

    @Column(name = "localDate")
    @NotNull(message = "Data este necesara")
    private LocalDate localDate;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails=new ArrayList<>();


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", localDate=" + localDate +
                ", orderDetails=" + orderDetails +
                '}';
    }
}

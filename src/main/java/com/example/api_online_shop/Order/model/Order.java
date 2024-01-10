package com.example.api_online_shop.Order.model;

import com.example.api_online_shop.Customer.model.Customer;
import com.example.api_online_shop.OrderDetails.model.OrderDetails;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Order")
@Table(name = "`order`")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Order {
    @Id
    @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    private Long id;


    @Column(name = "ammount")
    @NotNull(message = "ammount is necessary")
    private int ammount;

    @Column(name = "shippingAdress")
    @NotBlank(message = "Adresa este necesara")
    private String shippingAdress;

    @Column(name = "orderAdress")
    @NotBlank(message = "Adresa este necesara")
    private String orderAdress;

    @Column(name = "orderEmail")
    @NotBlank(message = "orderEmail este necesara")
    private String orderEmail;

    @Column(name = "orderStatus")
    @NotBlank(message = "orderStatus este necesara")
    private String orderStatus;



    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails=new ArrayList<>();


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ammount=" + ammount +
                ", shippingAdress='" + shippingAdress + '\'' +
                ", orderAdress='" + orderAdress + '\'' +
                ", orderEmail='" + orderEmail + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}

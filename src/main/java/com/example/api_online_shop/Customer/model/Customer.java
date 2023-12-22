package com.example.api_online_shop.Customer.model;

import com.example.api_online_shop.Order.model.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Customer")
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Customer {
    @Id
    @SequenceGenerator(name = "customer_sequence", sequenceName = "customer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sequence")
    private Long id;

    @Column(name="email")
    @NotBlank(message="Email-ul este necesar")
    private String email;

    @Column(name="password")
    @NotBlank(message="Parola este necesara")
    private String password;

    @Column(name="fullName")
    @NotBlank(message="Numele si prenumele sunt necesare")
    private String fullName;

    @Column(name="billingAdress")
    @NotBlank(message="Adresa de facturare este necesara")
    private String billingAdress;


    @Column(name="defaultShippingAddress")
    @NotBlank(message="Adresa de livrare este necesara")
    private String defaultShippingAddress;

    @Column(name="country")
    @NotBlank(message="Tara este necesara")
    private String country;

    @Column(name="phone")
    @NotBlank(message="Telefonul este necesar")
    private String phone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> order=new ArrayList<>();



    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", billingAdress='" + billingAdress + '\'' +
                ", defaultShippingAddress='" + defaultShippingAddress + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

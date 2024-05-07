package edu.depaul.ticketselling.management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "venues")
@Getter
@Setter
@ToString
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 20)
    private String phoneNumber;

    @Column(nullable = false, length = 254)
    private String email;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false, length = 100)
    private String addressLine1;

    @Setter
    @Column(length = 100)
    private String addressLine2;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false, length = 2)
    private String state;

    @Column(nullable = false, length = 50)
    private String postalCode;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Venue() {

    }

    public Venue(String name, String phoneNumber, String email, int capacity, String addressLine1, String city, String state, String postalCode, String description) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.capacity = capacity;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.description = description;
    }

}


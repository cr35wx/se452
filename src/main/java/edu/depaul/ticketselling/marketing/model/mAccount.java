package edu.depaul.ticketselling.marketing.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@ToString
public class mAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 254)
    private String email;

    @Column(nullable = false, length = 256)
    private String password;

    @Column(length = 20)
    private String phoneNumber;

    @Column(nullable = false)
    private LocalDate createdDate;

    @Column(name = "ticket_id")
    private Long ticketId; // Ticket ID 속성 추가

    public mAccount() {

    }

    public mAccount(String email, String password, String phoneNumber, LocalDate createdDate) {
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.createdDate = createdDate;
    }

}


package ma.ouairem.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.ouairem.accountservice.enums.AccountType;
import ma.ouairem.accountservice.model.Customer;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Builder
@Entity
public class BankAccount {
    @Id
    private String id;
    private Double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;

}

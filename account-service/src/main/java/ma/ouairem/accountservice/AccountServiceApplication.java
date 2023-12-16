package ma.ouairem.accountservice;

import ma.ouairem.accountservice.entities.BankAccount;
import ma.ouairem.accountservice.enums.AccountType;
import ma.ouairem.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository accountRepository) {
        return args -> {
            BankAccount bankAccount1 = BankAccount.builder()
                    .id(UUID.randomUUID().toString())
                    .currency("MAD")
                    .balance(98000.0)
                    .createdAt(LocalDate.now())
                    .type(AccountType.CURRENT_ACCOUNT)
                    .customerId(1L)
                    .build();
            BankAccount bankAccount2 = BankAccount.builder()
                    .id(UUID.randomUUID().toString())
                    .currency("MAD")
                    .balance(12000.0)
                    .createdAt(LocalDate.now())
                    .type(AccountType.CURRENT_ACCOUNT)
                    .customerId(2L)
                    .build();
            accountRepository.saveAll(List.of(bankAccount1, bankAccount2));
        };
    }

}

package ma.ouairem.accountservice.web;

import ma.ouairem.accountservice.clients.CustomerRestClient;
import ma.ouairem.accountservice.entities.BankAccount;
import ma.ouairem.accountservice.model.Customer;
import ma.ouairem.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BankAccountRestController {
    private BankAccountRepository accountRepository;
    private CustomerRestClient customerRestClient;

    public BankAccountRestController(
            BankAccountRepository accountRepository,
            CustomerRestClient customerRestClient
    ) {
        this.accountRepository = accountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accountList() {
        List<BankAccount> bankAccounts = accountRepository.findAll();
        for(BankAccount account : bankAccounts) {
            account.setCustomer(customerRestClient.findCustomerById(account.getCustomerId()));
        }

        return bankAccounts;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount accountList(@PathVariable String id) {
        Optional<BankAccount> resp = accountRepository.findById(id);
        if(resp.isPresent()) {
            BankAccount bankAccount = resp.get();
            Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
            bankAccount.setCustomer(customer);

            return bankAccount;
        }
        return null;
    }
}

package MyApp.Service;

import MyApp.Model.Account;
import MyApp.Model.ServiceRequest;
import MyApp.Repository.AccountRepository;
import MyApp.Repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    AccountRepository accountRepository;
    ServiceRequestRepository serviceRequestRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository,ServiceRequestRepository serviceRequestRepository) {
        this.accountRepository = accountRepository;
        this.serviceRequestRepository = serviceRequestRepository;
    }

    public Account addAccount(long id, Account account) {
        ServiceRequest request = serviceRequestRepository.findById(id).get();
        request.getAccounts().add(account);

        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        List<Account> accountList = accountRepository.findAll();
        return accountList;
    }


    public Account getAccountById(long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        Account account = optionalAccount.get();

        return account;
    }

    public ServiceRequest getRequestFromAccount(long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        Account account = accountOptional.get();

        ServiceRequest request = account.getServiceRequest();

        return request;
    }


    public Account deleteAccount(long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        Account account = optionalAccount.get();

        accountRepository.delete(account);

        return account;
    }
}

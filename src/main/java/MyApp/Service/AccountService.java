package MyApp.Service;

import MyApp.Exceptions.UnauthorizedUserException;
import MyApp.Model.Account;
import MyApp.Model.ServiceRequest;
import MyApp.Repository.AccountRepository;
import MyApp.Repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    /**
     * POSTS AN ACCOUNT TO THE DATABASE
     * @param account
     * @return
     */
    public Account postAccount(Account account) {
        long token = (long) (Math.random()*Long.MAX_VALUE);
        account.setSecureToken(token);
        accountRepository.save(account);
        return account;
    }

    /**
     * POSTS A LOGIN, CHECKS IF THE ACCOUNT EXISTS AND MATCHES THE LOGIN CREDENTIALS
     * @param account
     * @return
     */
    public Account postLogin(Account account) throws UnauthorizedUserException {
        Account accountOnDb = accountRepository.findUserByUsername(account.getUsername());

        if(accountOnDb.getPassword().equals(account.getPassword())) {
            //generate new token for this account
            long token = (long) (Math.random()*Long.MAX_VALUE);
            accountOnDb.setSecureToken(token);
            accountRepository.save(accountOnDb);
            return accountOnDb;
        }
        else {
            throw new UnauthorizedUserException();
        }
    }

    /**
     * Put a engineer/worker on a request service
     * @param aid
     * @param rid
     * @return
     */
    public Account assignWork(long aid, long rid) {
        //get the account associated with the account id (aid) and the request for that account
        Account account = getAccountById(aid);
        ServiceRequest requestFromAccount = account.getServiceRequest();

        if(requestFromAccount != null) {
            //remove the account from its current service request
            requestFromAccount.getAccounts().remove(account);
        }

        //Find the service request associated with the request id (rid)
        Optional<ServiceRequest> optionalRequest = serviceRequestRepository.findById(rid);
        ServiceRequest request = optionalRequest.get();
        List<Account> accountsFromRequest = request.getAccounts();

        if(accountsFromRequest != null){
            request.getAccounts().add(account);
        }
        else {
            List<Account> newaccountlist = new ArrayList<Account>();
            newaccountlist.add(account);
            request.setAccounts(newaccountlist);

        }

        serviceRequestRepository.save(request);
        accountRepository.save(account);

        return account;
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

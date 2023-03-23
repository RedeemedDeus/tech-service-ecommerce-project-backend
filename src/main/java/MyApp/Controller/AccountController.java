package MyApp.Controller;

import MyApp.Model.Account;
import MyApp.Model.ServiceRequest;
import MyApp.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
@RestController
public class AccountController {
    AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 1.A company worker/agent that is working on a service request should be able to add itself to a request
     * POST localhost:9000/request/{id}/account
     */
    @PostMapping("request/{id}/account")
    public Account postAccount(@PathVariable long id, @RequestBody Account account) {
        return accountService.addAccount(id, account);
    }

    /**
     * 2. A company worker/agent should be able to see all accounts and what they are working on
     * GET localhost:9000/account
     */
    @GetMapping("account")
    public List<Account> getAllAccounts() throws Exception {
        return accountService.getAllAccounts();
    }

    /**
     * 3. A company worker/agent should be able to get an account by its id
     * GET localhost:9000/account/{id}
     */
    @GetMapping("account/{id}")
    public Account getAccountById(@PathVariable long id) {
        return accountService.getAccountById(id);
    }

    /**
     * 4.A company worker/agent should be able to get the request/s associated with an account
     * GET localhost:9000/account/{id}/request
     */
    @GetMapping("account/{id}/request")
    public ServiceRequest getRequestFromAccount(@PathVariable long id) {
        return accountService.getRequestFromAccount(id);
    }

    /**
     * 5.A company worker/agent should be able to delete an account
     * DELETE localhost:9000/account/{id}
     */
    @DeleteMapping("account/{id}")
    public Account deleteAccount(@PathVariable long id) {
        return accountService.deleteAccount(id);
    }

}

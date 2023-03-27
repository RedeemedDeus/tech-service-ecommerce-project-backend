package MyApp.Controller;

import MyApp.Exceptions.UnauthorizedUserException;
import MyApp.Model.Account;
import MyApp.Model.ServiceRequest;
import MyApp.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
     * 1.A user should be able to register a new account
     * POST localhost:9000/account
     */
    @PostMapping("account")
    public Account postAccount(@RequestBody Account account) {
        return accountService.postAccount(account);
    }

    /**
     * 2. A user should be able to log in to the site
     * POST localhost:9000/login
     */
    @PostMapping("login")
    public Account loginAccount(@RequestBody Account account) throws UnauthorizedUserException {
        return accountService.postLogin(account);
    }

    @ExceptionHandler(UnauthorizedUserException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "invalid login credentials, please try again!")
    public void handleUnauthorized(){
    }

    /**
     * 3. An engineer should be able to assign himself to a task
     * POST localhost:9000/account/{aid}/request/{rid}
     */
    @PutMapping("account/{aid}/request/{rid}")
    public Account assignWork(@PathVariable long aid, @PathVariable long rid) {
        return accountService.assignWork(aid,rid);
    }

    /**
     * 4. A company worker/agent should be able to see all accounts and what they are working on
     * GET localhost:9000/account
     */
    @GetMapping("account")
    public List<Account> getAllAccounts() throws Exception {
        return accountService.getAllAccounts();
    }

    /**
     * 5. A company worker/agent should be able to get an account by its id
     * GET localhost:9000/account/{id}
     */
    @GetMapping("account/{id}")
    public Account getAccountById(@PathVariable long id) {
        return accountService.getAccountById(id);
    }

    /**
     * 6.A company worker/agent should be able to get the request/s associated with an account
     * GET localhost:9000/account/{id}/request
     */
    @GetMapping("account/{id}/request")
    public ServiceRequest getRequestFromAccount(@PathVariable long id) {
        return accountService.getRequestFromAccount(id);
    }

    /**
     * 7.A company worker/agent should be able to delete an account
     * DELETE localhost:9000/account/{id}
     */
    @DeleteMapping("account/{id}")
    public Account deleteAccount(@PathVariable long id) {
        return accountService.deleteAccount(id);
    }

}

package net.javaguides.banking.controller;

import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.entity.Account;
import net.javaguides.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Add Account REST API
@PostMapping("/")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {

        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);


    }
//Get Account REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountbyId(@PathVariable Long id) {
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }

    //Deposite REST API
    @PutMapping("/{id}/deposite")
    public ResponseEntity<AccountDto> deposite(@PathVariable Long id, @RequestBody Map<String,Double> request) {
        return new ResponseEntity<>(accountService.deposite(id,request.get("amount")), HttpStatus.OK);
    }
    //Withdraw REST API
    @PutMapping("/{id}/withdraw")
public ResponseEntity<AccountDto> withdrawal(@PathVariable Long id, @RequestBody Map<String,Double> request) {
        return new ResponseEntity<>(accountService.withdraw(id,request.get("amount")), HttpStatus.OK);

}
//Get All Accounts REST API
    @GetMapping
    public ResponseEntity <List<AccountDto>> getAllAccounts() {
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

//Delete Accounts by id
@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<>("Account deleted", HttpStatus.OK);
    }





}


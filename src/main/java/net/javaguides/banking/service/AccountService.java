package net.javaguides.banking.service;

import net.javaguides.banking.dto.AccountDto;

import java.util.List;

public interface AccountService {

 AccountDto createAccount(AccountDto accountDto);
 AccountDto getAccountById(Long id);
 AccountDto deposite(Long Id, double amount);
 AccountDto withdraw(Long Id, double amount);
 List<AccountDto> getAllAccounts();
  void deleteAccount(Long id);
}


package me.dio.java_spring_boot_railway.service.impl;

import me.dio.java_spring_boot_railway.domain.model.Account;
import me.dio.java_spring_boot_railway.domain.repository.AccountRepository;
import me.dio.java_spring_boot_railway.domain.repository.UserRepository;
import me.dio.java_spring_boot_railway.dto.AccountDTO;
import me.dio.java_spring_boot_railway.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public AccountDTO findById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Account ID " + id + " not found."));
        return convertToDTO(account);
    }

    @Override
    public AccountDTO create(AccountDTO accountDTO) {
        if(accountRepository.existsByAccountNumber(accountDTO.getAccountNumber())) {
            throw new IllegalArgumentException("Account number already exists.");
        }
        Account account = convertToEntity(accountDTO);
        account = accountRepository.save(account);
        return convertToDTO(account);
    }

    @Override
    public List<AccountDTO> findAll() {
        return accountRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!accountRepository.existsById(id)) {
            throw new NoSuchElementException("Account ID " + id + " not found.");
        }
        accountRepository.deleteById(id);
    }

    private AccountDTO convertToDTO(Account account) {
        return new AccountDTO(
                account.getId(),
                account.getBalance(),
                account.getAccountNumber(),
                account.getUser() != null ? account.getUser().getId() : null
        );
    }

    private Account convertToEntity(AccountDTO accountDTO) {
        Account account = new Account();
        account.setBalance(accountDTO.getBalance());
        account.setAccountNumber(accountDTO.getAccountNumber());
        if(accountDTO.getUserId() != null){
            account.setUser(userRepository.findById(accountDTO.getUserId())
                    .orElseThrow(() -> new NoSuchElementException("User ID " + accountDTO.getUserId() + " not found.")));
        }
        return account;
    }
}

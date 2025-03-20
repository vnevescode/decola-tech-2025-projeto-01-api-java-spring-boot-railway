package me.dio.java_spring_boot_railway.service.impl;

import me.dio.java_spring_boot_railway.domain.model.Account;
import me.dio.java_spring_boot_railway.domain.model.Transaction;
import me.dio.java_spring_boot_railway.domain.repository.AccountRepository;
import me.dio.java_spring_boot_railway.domain.repository.TransactionRepository;
import me.dio.java_spring_boot_railway.dto.TransactionDTO;
import me.dio.java_spring_boot_railway.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public TransactionDTO findById(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Transaction ID " + id + " not found."));
        return convertToDTO(transaction);
    }

    @Override
    public TransactionDTO create(TransactionDTO dto) {
        Account account = accountRepository.findById(dto.getAccountId())
                .orElseThrow(() -> new NoSuchElementException("Account ID " + dto.getAccountId() + " not found."));

        Transaction transaction = convertToEntity(dto);
        transaction.setAccount(account);

        Transaction saved = transactionRepository.save(transaction);
        return convertToDTO(saved);
    }

    @Override
    public List<TransactionDTO> findAll() {
        return transactionRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!transactionRepository.existsById(id)) {
            throw new NoSuchElementException("Transaction ID " + id + " not found.");
        }
        transactionRepository.deleteById(id);
    }

    private TransactionDTO convertToDTO(Transaction transaction) {
        return new TransactionDTO(
                transaction.getId(),
                transaction.getOperationType(),
                transaction.getAmount(),
                transaction.getCreatedAt(),
                transaction.getAccount().getId()
        );
    }

    private Transaction convertToEntity(TransactionDTO dto) {
        Transaction transaction = new Transaction();
        transaction.setOperationType(dto.getOperationType());
        transaction.setAmount(dto.getAmount());
        transaction.setCreatedAt(dto.getCreatedAt() != null ? dto.getCreatedAt() : java.time.LocalDateTime.now());
        return transaction;
    }
}

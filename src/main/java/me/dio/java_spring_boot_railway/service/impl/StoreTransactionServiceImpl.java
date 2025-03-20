package me.dio.java_spring_boot_railway.service.impl;

import me.dio.java_spring_boot_railway.domain.model.StoreAccount;
import me.dio.java_spring_boot_railway.domain.model.StoreTransaction;
import me.dio.java_spring_boot_railway.domain.repository.StoreAccountRepository;
import me.dio.java_spring_boot_railway.domain.repository.StoreTransactionRepository;
import me.dio.java_spring_boot_railway.dto.StoreTransactionDTO;
import me.dio.java_spring_boot_railway.service.StoreTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class StoreTransactionServiceImpl implements StoreTransactionService {
    private final StoreTransactionRepository storeTransactionRepository;
    private final StoreAccountRepository storeAccountRepository;

    public StoreTransactionServiceImpl(StoreTransactionRepository storeTransactionRepository, StoreAccountRepository storeAccountRepository) {
        this.storeTransactionRepository = storeTransactionRepository;
        this.storeAccountRepository = storeAccountRepository;
    }

    @Override
    public StoreTransactionDTO findById(Long id) {
        StoreTransaction transaction = storeTransactionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("StoreTransaction ID " + id + " not found."));
        return convertToDTO(transaction);
    }

    @Override
    public StoreTransactionDTO create(StoreTransactionDTO dto) {
        StoreAccount storeAccount = storeAccountRepository.findById(dto.getStoreAccountId())
                .orElseThrow(() -> new NoSuchElementException("StoreAccount ID " + dto.getStoreAccountId() + " not found."));

        StoreTransaction transaction = convertToEntity(dto);
        transaction.setStoreAccount(storeAccount);

        StoreTransaction saved = storeTransactionRepository.save(transaction);
        return convertToDTO(saved);
    }

    @Override
    public List<StoreTransactionDTO> findAll() {
        return storeTransactionRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!storeTransactionRepository.existsById(id)) {
            throw new NoSuchElementException("StoreTransaction ID " + id + " not found.");
        }
        storeTransactionRepository.deleteById(id);
    }

    private StoreTransactionDTO convertToDTO(StoreTransaction transaction) {
        return new StoreTransactionDTO(
                transaction.getId(),
                transaction.getOperationType(),
                transaction.getAmount(),
                transaction.getCreatedAt(),
                transaction.getStoreAccount().getId()
        );
    }

    private StoreTransaction convertToEntity(StoreTransactionDTO dto) {
        StoreTransaction transaction = new StoreTransaction();
        transaction.setOperationType(dto.getOperationType());
        transaction.setAmount(dto.getAmount());
        transaction.setCreatedAt(dto.getCreatedAt() != null ? dto.getCreatedAt() : java.time.LocalDateTime.now());
        return transaction;
    }
}

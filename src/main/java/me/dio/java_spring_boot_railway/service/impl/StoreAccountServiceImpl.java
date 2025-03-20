package me.dio.java_spring_boot_railway.service.impl;

import me.dio.java_spring_boot_railway.domain.model.Store;
import me.dio.java_spring_boot_railway.domain.model.StoreAccount;
import me.dio.java_spring_boot_railway.domain.repository.StoreAccountRepository;
import me.dio.java_spring_boot_railway.domain.repository.StoreRepository;
import me.dio.java_spring_boot_railway.dto.StoreAccountDTO;
import me.dio.java_spring_boot_railway.service.StoreAccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class StoreAccountServiceImpl implements StoreAccountService {
    private final StoreAccountRepository storeAccountRepository;
    private final StoreRepository storeRepository;

    public StoreAccountServiceImpl(StoreAccountRepository storeAccountRepository, StoreRepository storeRepository) {
        this.storeAccountRepository = storeAccountRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    public StoreAccountDTO findById(Long id) {
        StoreAccount account = storeAccountRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("StoreAccount ID " + id + " not found."));
        return convertToDTO(account);
    }

    @Override
    public StoreAccountDTO create(StoreAccountDTO storeAccountDTO) {
        if(storeAccountRepository.existsByAccountNumber(storeAccountDTO.getAccountNumber())) {
            throw new IllegalArgumentException("Store account number already exists.");
        }
        StoreAccount account = convertToEntity(storeAccountDTO);
        StoreAccount saved = storeAccountRepository.save(account);
        return convertToDTO(saved);
    }

    @Override
    public List<StoreAccountDTO> findAll() {
        return storeAccountRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!storeAccountRepository.existsById(id)) {
            throw new NoSuchElementException("StoreAccount ID " + id + " not found.");
        }
        storeAccountRepository.deleteById(id);
    }

    private StoreAccountDTO convertToDTO(StoreAccount account) {
        return new StoreAccountDTO(
                account.getId(),
                account.getBalance(),
                account.getAccountNumber(),
                account.getStore() != null ? account.getStore().getId() : null
        );
    }

    private StoreAccount convertToEntity(StoreAccountDTO dto) {
        StoreAccount account = new StoreAccount();
        account.setBalance(dto.getBalance());
        account.setAccountNumber(dto.getAccountNumber());

        if(dto.getStoreId() != null) {
            Store store = storeRepository.findById(dto.getStoreId())
                    .orElseThrow(() -> new NoSuchElementException("Store ID " + dto.getStoreId() + " not found."));
            account.setStore(store);
        } else {
            account.setStore(null);
        }
        return account;
    }
}

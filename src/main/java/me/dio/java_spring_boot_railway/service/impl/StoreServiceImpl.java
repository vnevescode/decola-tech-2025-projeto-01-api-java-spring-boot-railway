package me.dio.java_spring_boot_railway.service.impl;

import me.dio.java_spring_boot_railway.domain.model.Store;
import me.dio.java_spring_boot_railway.domain.repository.StoreRepository;
import me.dio.java_spring_boot_railway.dto.StoreDTO;
import me.dio.java_spring_boot_railway.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public StoreDTO findById(Long id) {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Store ID " + id + " not found."));
        return convertToDTO(store);
    }

    @Override
    public StoreDTO create(StoreDTO storeDTO) {
        Store store = convertToEntity(storeDTO);
        Store savedStore = storeRepository.save(store);
        return convertToDTO(savedStore);
    }

    @Override
    public List<StoreDTO> findAll() {
        return storeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!storeRepository.existsById(id)) {
            throw new NoSuchElementException("Store ID " + id + " not found.");
        }
        storeRepository.deleteById(id);
    }

    private StoreDTO convertToDTO(Store store) {
        return new StoreDTO(
                store.getId(),
                store.getName(),
                store.getAddress(),
                store.getCity(),
                store.getState()
        );
    }

    private Store convertToEntity(StoreDTO storeDTO) {
        Store store = new Store();
        store.setName(storeDTO.getName());
        store.setAddress(storeDTO.getAddress());
        store.setCity(storeDTO.getCity());
        store.setState(storeDTO.getState());
        return store;
    }
}

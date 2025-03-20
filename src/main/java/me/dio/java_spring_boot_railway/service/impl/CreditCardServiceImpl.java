package me.dio.java_spring_boot_railway.service.impl;

import me.dio.java_spring_boot_railway.domain.model.CreditCard;
import me.dio.java_spring_boot_railway.domain.repository.CreditCardRepository;
import me.dio.java_spring_boot_railway.dto.CreditCardDTO;
import me.dio.java_spring_boot_railway.service.CreditCardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CreditCardServiceImpl implements CreditCardService {
    private final CreditCardRepository creditCardRepository;

    public CreditCardServiceImpl(CreditCardRepository repository) {
        this.creditCardRepository = repository;
    }

    @Override
    public CreditCardDTO findById(Long id) {
        var card = creditCardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("CreditCard ID " + id + " not found."));
        return new CreditCardDTO(card.getId(), card.getNumber(), card.getExpirationDate(), card.getCreditLimit());
    }

    @Override
    public CreditCardDTO create(CreditCardDTO dto) {
        if(creditCardRepository.existsByNumber(dto.getNumber())){
            throw new IllegalArgumentException("Credit card number already exists.");
        }
        CreditCard card = new CreditCard();
        card.setNumber(dto.getNumber());
        card.setExpirationDate(dto.getExpirationDate());
        card.setCreditLimit(dto.getCreditLimit());
        card = creditCardRepository.save(card);
        return new CreditCardDTO(card.getId(), card.getNumber(), card.getExpirationDate(), card.getCreditLimit());
    }

    @Override
    public List<CreditCardDTO> findAll() {
        return creditCardRepository.findAll().stream()
                .map(card -> new CreditCardDTO(card.getId(), card.getNumber(), card.getExpirationDate(), card.getCreditLimit()))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!creditCardRepository.existsById(id))
            throw new NoSuchElementException("CreditCard ID " + id + " not found.");
        creditCardRepository.deleteById(id);
    }
}

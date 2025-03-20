package me.dio.java_spring_boot_railway.service.impl;

import me.dio.java_spring_boot_railway.domain.model.Account;
import me.dio.java_spring_boot_railway.domain.model.CreditCard;
import me.dio.java_spring_boot_railway.domain.model.User;
import me.dio.java_spring_boot_railway.domain.repository.AccountRepository;
import me.dio.java_spring_boot_railway.domain.repository.CreditCardRepository;
import me.dio.java_spring_boot_railway.domain.repository.UserRepository;
import me.dio.java_spring_boot_railway.dto.UserDTO;
import me.dio.java_spring_boot_railway.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final CreditCardRepository creditCardRepository;

    public UserServiceImpl(UserRepository userRepository,
                           AccountRepository accountRepository,
                           CreditCardRepository creditCardRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User ID " + id + " not found."));
        return convertToDTO(user);
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new IllegalArgumentException("User email already exists.");
        }

        User user = convertToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new NoSuchElementException("User ID " + id + " not found.");
        }
        userRepository.deleteById(id);
    }

    private UserDTO convertToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getDocumentId(),
                user.getAccount() != null ? user.getAccount().getId() : null,
                user.getCreditCard() != null ? user.getCreditCard().getId() : null
        );
    }

    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setDocumentId(userDTO.getDocumentId());

        if(userDTO.getAccountId() != null) {
            Account account = accountRepository.findById(userDTO.getAccountId())
                    .orElseThrow(() -> new NoSuchElementException("Account ID " + userDTO.getAccountId() + " not found."));
            user.setAccount(account);
        }

        if(userDTO.getCreditCardId() != null) {
            CreditCard creditCard = creditCardRepository.findById(userDTO.getCreditCardId())
                    .orElseThrow(() -> new NoSuchElementException("CreditCard ID " + userDTO.getCreditCardId() + " not found."));
            user.setCreditCard(creditCard);
        }

        return user;
    }
}

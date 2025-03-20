package me.dio.java_spring_boot_railway.service.impl;

import me.dio.java_spring_boot_railway.domain.model.Car;
import me.dio.java_spring_boot_railway.domain.model.Rental;
import me.dio.java_spring_boot_railway.domain.model.Store;
import me.dio.java_spring_boot_railway.domain.model.User;
import me.dio.java_spring_boot_railway.domain.repository.CarRepository;
import me.dio.java_spring_boot_railway.domain.repository.RentalRepository;
import me.dio.java_spring_boot_railway.domain.repository.StoreRepository;
import me.dio.java_spring_boot_railway.domain.repository.UserRepository;
import me.dio.java_spring_boot_railway.dto.RentalDTO;
import me.dio.java_spring_boot_railway.service.RentalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class RentalServiceImpl implements RentalService {
    private final RentalRepository rentalRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final StoreRepository storeRepository;

    public RentalServiceImpl(RentalRepository rentalRepository, UserRepository userRepository,
                             CarRepository carRepository, StoreRepository storeRepository) {
        this.rentalRepository = rentalRepository;
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    public RentalDTO findById(Long id) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Rental ID " + id + " not found."));
        return convertToDTO(rental);
    }

    @Override
    public RentalDTO create(RentalDTO rentalDTO) {
        Rental rental = convertToEntity(rentalDTO);
        rental = rentalRepository.save(rental);
        return convertToDTO(rental);
    }

    @Override
    public List<RentalDTO> findAll() {
        return rentalRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!rentalRepository.existsById(id)) {
            throw new NoSuchElementException("Rental ID " + id + " not found.");
        }
        rentalRepository.deleteById(id);
    }

    private RentalDTO convertToDTO(Rental rental) {
        return new RentalDTO(
                rental.getId(),
                rental.getStartDate(),
                rental.getEndDate(),
                rental.getTotalValue(),
                rental.getStatus(),
                rental.getUser().getId(),
                rental.getCar().getId(),
                rental.getPickUpStore().getId(),
                rental.getDropOffStore().getId()
        );
    }

    private Rental convertToEntity(RentalDTO rentalDTO) {
        Rental rental = new Rental();
        rental.setStartDate(rentalDTO.getStartDate());
        rental.setEndDate(rentalDTO.getEndDate());
        rental.setTotalValue(rentalDTO.getTotalValue());
        rental.setStatus(rentalDTO.getStatus());

        User user = userRepository.findById(rentalDTO.getUserId())
                .orElseThrow(() -> new NoSuchElementException("User ID not found."));
        rental.setUser(user);

        Car car = carRepository.findById(rentalDTO.getCarId())
                .orElseThrow(() -> new NoSuchElementException("Car ID not found."));
        rental.setCar(car);

        Store pickUpStore = storeRepository.findById(rentalDTO.getPickUpStoreId())
                .orElseThrow(() -> new NoSuchElementException("Pick-up Store ID not found."));
        rental.setPickUpStore(pickUpStore);

        Store dropOffStore = storeRepository.findById(rentalDTO.getDropOffStoreId())
                .orElseThrow(() -> new NoSuchElementException("Drop-off Store ID not found."));
        rental.setDropOffStore(dropOffStore);

        return rental;
    }
}

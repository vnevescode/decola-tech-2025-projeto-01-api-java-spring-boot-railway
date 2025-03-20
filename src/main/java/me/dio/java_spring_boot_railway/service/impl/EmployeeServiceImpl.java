package me.dio.java_spring_boot_railway.service.impl;

import me.dio.java_spring_boot_railway.domain.model.Employee;
import me.dio.java_spring_boot_railway.domain.repository.EmployeeRepository;
import me.dio.java_spring_boot_railway.domain.repository.StoreRepository;
import me.dio.java_spring_boot_railway.dto.EmployeeDTO;
import me.dio.java_spring_boot_railway.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final StoreRepository storeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, StoreRepository storeRepository) {
        this.employeeRepository = employeeRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    public EmployeeDTO findById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Employee ID " + id + " not found."));
        return convertToDTO(employee);
    }

    @Override
    public EmployeeDTO create(EmployeeDTO dto) {
        Employee employee = convertToEntity(dto);
        employee = employeeRepository.save(employee);
        return convertToDTO(employee);
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new NoSuchElementException("Employee ID " + id + " not found.");
        }
        employeeRepository.deleteById(id);
    }

    private EmployeeDTO convertToDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getRole(),
                employee.getSalary(),
                employee.getStore() != null ? employee.getStore().getId() : null
        );
    }

    private Employee convertToEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setRole(dto.getRole());
        employee.setSalary(dto.getSalary());
        if (dto.getStoreId() != null) {
            employee.setStore(storeRepository.findById(dto.getStoreId())
                    .orElseThrow(() -> new NoSuchElementException("Store ID " + dto.getStoreId() + " not found.")));
        } else {
            employee.setStore(null);
        }
        return employee;
    }
}

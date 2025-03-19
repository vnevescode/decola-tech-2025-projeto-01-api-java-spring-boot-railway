package me.dio.java_spring_boot_railway.domain.repository;


import me.dio.java_spring_boot_railway.domain.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}

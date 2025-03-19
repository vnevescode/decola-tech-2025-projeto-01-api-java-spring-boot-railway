package me.dio.java_spring_boot_railway.domain.repository;


import me.dio.java_spring_boot_railway.domain.model.StoreAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreAccountRepository extends JpaRepository<StoreAccount, Long> {
}

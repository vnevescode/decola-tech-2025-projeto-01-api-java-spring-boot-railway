package me.dio.java_spring_boot_railway.domain.repository;

import me.dio.java_spring_boot_railway.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

package com.sicky.Backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sicky.Backend.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,UUID> {

    boolean existexistsByPhoneNumber(String phoneNumber);
    User findByPhoneNumber(String phoneNumber);
}

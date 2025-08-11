package com.kunalgupte.buddyrental.repository;

import com.kunalgupte.buddyrental.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

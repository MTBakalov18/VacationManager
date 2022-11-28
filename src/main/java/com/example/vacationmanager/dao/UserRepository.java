package com.example.vacationmanager.dao;

import com.example.vacationmanager.tables.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameAndPassword(String username, String password);
}
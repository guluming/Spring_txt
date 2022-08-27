package com.example.spring_txt.repository;

import com.example.spring_txt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.name like %:name%")
    List<User> findByName(String name);
}

package com.example.spring_txt.repository;

import com.example.spring_txt.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {
    @Query("select u from Users u where u.name like %:name%")
    List<Users> findByName(String name);
}

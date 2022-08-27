package com.example.spring_txt.service;

import com.example.spring_txt.entity.User;
import com.example.spring_txt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public ResponseEntity<Object> getUserList() {
        List<User> userList = userRepository.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    public ResponseEntity<Object> getUserId(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return new ResponseEntity<>("존재하지 않는 사용자 입니다.", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
    }

    @Transactional
    public ResponseEntity<Object> deleteUserId(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        } else {
            userRepository.delete(user.get());
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> getUserName(String name) {
        List<User> userList = userRepository.findByName(name);
        if (userList.isEmpty()) {
            return new ResponseEntity<>("해당되는 사용자가 없습니다.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        }
    }
}

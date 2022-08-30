package com.example.spring_txt.controller;

import com.example.spring_txt.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @GetMapping("/user/list")
    public ResponseEntity<Object> getUserList() {
        return userService.getUserList();
    }

    @GetMapping("/user/id")
    public ResponseEntity<Object> getUserId(@RequestParam("id") Long id) {
        return userService.getUserId(id);
    }

    @DeleteMapping("/user/id")
    public ResponseEntity<Object> deleteUserId(@RequestParam("id") Long id) {
        return userService.deleteUserId(id);
    }

    @GetMapping("/user/name")
    public ResponseEntity<Object> getUserName(@RequestParam("name") String name) {
        return userService.getUserName(name);
    }
}

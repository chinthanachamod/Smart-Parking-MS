package org.example.userservice.controller;

import org.example.userservice.dto.ResponseDTO;
import org.example.userservice.dto.UserDTO;
import org.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    // "localhost:8089/api/users/save" for save user
    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> registerUser(@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(userService.registerUser(userDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponseDTO("error", e.getMessage()));
        }

    }

    // "localhost:8089/api/users/login" for login user
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> loginUser(@RequestBody UserDTO userDTO) {
        UserDTO userdto = userService.loginUser(userDTO);
        if (userdto != null) {
            return ResponseEntity.ok(new ResponseDTO("Login Success", userdto));
        } else {
            return ResponseEntity.badRequest().body(new ResponseDTO("Error!", "Invalid username or password"));
        }
    }

    // "localhost:8089/api/users/allUsers" for getting all users
    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        try {
            return ResponseEntity.ok(userService.getAllUsers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}

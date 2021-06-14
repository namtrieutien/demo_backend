package com.example.demo.controller;

import com.example.demo.model.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get-list-users")
    public ResponseEntity<?> getListUsers(){
        List<UserDto> userDtos = userService.getListUsers();
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/get-user-by-id")
    public ResponseEntity<?> getUserById(@RequestParam("id") int id){
        System.out.println("getUserById");
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/get-user-by-name")
    public ResponseEntity<?> getUserByName(@RequestParam("name") String name){
        System.out.println("getUserByName");
        UserDto userDto = userService.getUserByName(name);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/search-user-by-name")
    public ResponseEntity<?> searchUser(@RequestParam(name = "name", required = false, defaultValue = "") String name){
        List<UserDto> userDtos = userService.searchUser(name);
        return ResponseEntity.ok(userDtos);
    }

    @Transactional
    @PutMapping("/update-user-by-id")
    public void updateUser(@RequestParam("id") int id, @RequestParam("name") String name){
        System.out.println("update-user-by-id: " + id + " name: " + name);
        userService.updateUserById(id, name);
    }

    @Transactional
    @DeleteMapping("/delete-user-by-id")
    public void deleteUserById(@RequestParam("id") int id){
        userService.deleteUserById(id);
    }

    @Transactional
    @DeleteMapping("/delete-user-by-name")
    public void deleteUserByName(@RequestParam("name") String name){
        userService.deleteUserByName(name);
    }

    @Transactional
    @PostMapping("/create-new-user")
    public void createNewUser(@RequestParam("name") String name){
        userService.createUserByName(name);
    }
}


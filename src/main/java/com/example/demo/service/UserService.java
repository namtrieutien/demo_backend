package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserDto> getListUsers();
    UserDto getUserById(int id);
    UserDto getUserByName(String name);
    List<UserDto> searchUser(String name);
    void deleteUserById(int id);
    void deleteUserByName(String name);

    void createUserByName(String name);
    void updateUserById(int id, String newName);

}

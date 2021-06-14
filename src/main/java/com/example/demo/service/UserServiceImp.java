package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getListUsers() {
        List<User> users = (List<User>) userRepository.findAll();

        ArrayList<UserDto> userDtos = new ArrayList<>();
        for(User user : users){
            userDtos.add(UserMapper.toUserDto(user));
        }
        return userDtos;
    }

    @Override
    public UserDto getUserById(int id) {
        User user =  userRepository.getUserById(id);
        return UserMapper.toUserDto(user);
    }

    @Transactional
    @Override
    public UserDto getUserByName(String name) {
        User user = userRepository.getUserByName(name);
        return UserMapper.toUserDto(user);
    }

    @Override
    public List<UserDto> searchUser(String name) {
        List<UserDto> userDtos = getListUsers();
        List<UserDto> filterUserDtos = new ArrayList<>();
        for(UserDto userDto: userDtos){
            if(userDto.getName().contains(name)){
                filterUserDtos.add(userDto);
            }
        }
        return filterUserDtos;
    }

    @Override
    public void deleteUserById(int id) {
        List<User> users = (List<User>) userRepository.findAll();
        int ctDeleteUser = 0;
        for(User user: users){
            if(user.getId() == id){
                userRepository.delete(user);
                ctDeleteUser +=1;
            }
        }
        if(ctDeleteUser == 0){
            throw new NotFoundException("Không có user id: " + id);
        }
    }

    @Override
    public void deleteUserByName(String name) {

        userRepository.deleteUserByName(name);
    }

    @Override
    public void createUserByName(String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
    }

    @Override
    public void updateUserById(int id, String newName) {
        List<User> users = (List<User>) userRepository.findAll();
        int ctFoundUser = 0;
        for(User user: users){
            if(user.getId() == id){
               user.setName(newName);
               userRepository.save(user);
                ctFoundUser +=1;
            }
        }
        if(ctFoundUser == 0){
            throw new NotFoundException("Không có user id: " + id);
        }
    }
}

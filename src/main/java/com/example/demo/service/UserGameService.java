package com.example.demo.service;

import com.example.demo.entity.Game;
import com.example.demo.model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserGameService {
    List<Game> findGameByUserId(int id);

}

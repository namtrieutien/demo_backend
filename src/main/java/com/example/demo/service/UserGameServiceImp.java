package com.example.demo.service;

import com.example.demo.entity.Game;
import com.example.demo.entity.User;
import com.example.demo.entity.UserGame;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.repository.UserGameRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserGameServiceImp implements UserGameService{
    @Autowired
    private UserGameRepository userGameRepository;

    @Override
    public List<Game> findGameByUserId(int id) {
        List<UserGame> userGames = ( List<UserGame>)userGameRepository.findAll();
        List<Game> listGames = new ArrayList<>();
        for(UserGame userGame: userGames){
            if(userGame.getUserGameKey().getUser_id() == id){
                listGames.add(userGame.getGame());
            }
        }
        return listGames;
    }
}

package com.example.demo.service;

import com.example.demo.entity.Game;
import com.example.demo.entity.Group;
import com.example.demo.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GameServiceImp implements GamerService{
    @Autowired
    private GameRepository gameRepository;


    @Override
    public String getInfoGroupByGameId(int id) {
        List<Game> games = (List<Game>) gameRepository.findAll();
        for(Game game: games){
            if(game.getId() == id){
                return game.getGroup().getName();
            }
        }
        return null;
    }

}

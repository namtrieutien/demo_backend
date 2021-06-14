package com.example.demo.controller;

import com.example.demo.entity.Game;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.service.UserGameService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users-games")
public class UserGameController {
    @Autowired
    private UserGameService userGameService;

    @GetMapping("/find-game-by-userid")
    public ResponseEntity<?> findGameByUserId(@RequestParam("id") int id){
        List<Game> games = userGameService.findGameByUserId(id);
        if(games.size() == 0){
            throw new NotFoundException("Không tồn tại user id: " + id);
        }

        List<String> gameNames = new ArrayList<>();
        for(Game game: games){
            gameNames.add(game.getName());
        }
        return ResponseEntity.ok(gameNames);
    }
}


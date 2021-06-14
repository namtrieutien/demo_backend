package com.example.demo.controller;

import com.example.demo.entity.Game;
import com.example.demo.model.dto.UserDto;
import com.example.demo.service.GroupService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/getListGamesById/{id}")
    public ResponseEntity<?> getListGamesByGroupId(@PathVariable("id") int id){
        List<Game> games = groupService.getListGamesByGroupId(id);
        List<String> gameNames = new ArrayList<>();
        for(Game game: games){
            gameNames.add(game.getName());
        }
        return ResponseEntity.ok(gameNames);
    }
}


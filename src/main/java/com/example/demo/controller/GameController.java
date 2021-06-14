package com.example.demo.controller;

import com.example.demo.entity.Group;
import com.example.demo.model.dto.UserDto;
import com.example.demo.service.GamerService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GamerService gamerService;

    @GetMapping("/getInfoGroup/{id}")
    public String getInfoGroupByGameId(@PathVariable("id") int id){
        String groupName = gamerService.getInfoGroupByGameId(id);
        return gamerService.getInfoGroupByGameId(id);
    }
}


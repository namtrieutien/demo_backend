package com.example.demo.service;

import com.example.demo.entity.Game;
import com.example.demo.entity.Group;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface GamerService {
    String getInfoGroupByGameId(int id);

}

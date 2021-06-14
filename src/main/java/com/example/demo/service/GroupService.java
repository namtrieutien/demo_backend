package com.example.demo.service;

import com.example.demo.entity.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupService {
    List<Game> getListGamesByGroupId(int id);

}

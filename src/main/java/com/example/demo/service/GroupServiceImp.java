package com.example.demo.service;

import com.example.demo.entity.Game;
import com.example.demo.entity.Group;
import com.example.demo.repository.GameRepository;
import com.example.demo.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupServiceImp implements GroupService{
    @Autowired
    private GroupRepository groupRepository;


    @Override
    public List<Game> getListGamesByGroupId(int id) {
        List<Group> groups = (List<Group>) groupRepository.findAll();
        for(Group group: groups){
            if(group.getId() == id){
                return group.getGames();
            }
        }
        return null;
    }
}

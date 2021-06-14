package com.example.demo.repository;

import com.example.demo.entity.User;
import com.example.demo.entity.UserGame;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGameRepository extends CrudRepository <UserGame, Long>{


}

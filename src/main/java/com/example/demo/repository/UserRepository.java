package com.example.demo.repository;

import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository <User, Long>{

    User getUserById(@Param("id") int id);

    @Query("SELECT u FROM User u WHERE u.name = :name")
    User getUserByName(@Param("name") String name);

    @Modifying
    @Query("DELETE FROM User u WHERE u.name = :name")
    void deleteUserByName(@Param("name") String name);

}

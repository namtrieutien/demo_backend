package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.NamedEntityGraph;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class UserGameKey implements Serializable {

    @Column(name="user_id")
    int user_id;

    @Column(name="game_id")
    int game_id;

}

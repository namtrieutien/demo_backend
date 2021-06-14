package com.example.demo.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

//store the username and password we recieve from the client.
public class JwtRequest {

    private String username;
    private String password;

}

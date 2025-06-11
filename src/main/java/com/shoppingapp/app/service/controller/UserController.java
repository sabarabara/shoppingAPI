package com.shoppingapp.app.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingapp.app.service.core.dto.UserDTO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("User")
public class UserController{

  @PostMapping("post")
  public UserDTO createUser(@RequestBody UserDTO userdto){
    return userdto;
  }

  @GetMapping("get")
  public HttpSession getUser(HttpSession session){
    return session;
  }
}
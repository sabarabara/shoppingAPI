package com.shoppingapp.app.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingapp.app.service.core.dto.UserDTO;
import com.shoppingapp.app.service.core.dto.UserResDTO;
import com.shoppingapp.app.service.usecase.interacter.UserUsecase;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("Users")
public class UserController{

  private final UserUsecase userUsecase;

  public UserController(UserUsecase userUsecase){
    this.userUsecase=userUsecase;
  }

  @PostMapping("create")
  public String createUser(@RequestBody UserDTO userdto){
    return userUsecase.createUser(userdto);
  }

  @GetMapping("get")
  public UserResDTO getUser(HttpSession session){
    return userUsecase.getUser(session);
  }
}
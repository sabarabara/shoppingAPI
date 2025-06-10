package com.shoppingapp.app.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingapp.app.auth.core.domain.model.vo.UserSession;
import com.shoppingapp.app.auth.usecase.SessionUsecase;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
public class AuthController{

   private final SessionUsecase sessionUsecase;

  @Autowired
    public AuthController(SessionUsecase sessionUsecase) {
        this.sessionUsecase = sessionUsecase;
    }

    @PostMapping("/login")
  public UserSession login(HttpSession session,String userId,String username,String password){

    session.setAttribute("userId", userId);
    session.setAttribute("username", username);
    session.setAttribute("password", password);

    UserSession userSession=sessionUsecase.crateUserSession();
    return userSession;
  }

  @PostMapping("/logout")
  public String logput(HttpSession session){
    session.invalidate();
    return "OK";
  }
}
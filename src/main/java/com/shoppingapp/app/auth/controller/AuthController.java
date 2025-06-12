package com.shoppingapp.app.auth.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingapp.app.auth.core.domain.model.vo.UserSession;
import com.shoppingapp.app.auth.usecase.AuthUsecase;
import com.shoppingapp.app.auth.usecase.SessionUsecase;
import com.shoppingapp.app.service.core.dto.UserDTO;
import com.shoppingapp.app.service.core.entity.UserEntity;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
public class AuthController{

   private final SessionUsecase sessionUsecase;
   private final AuthUsecase authUsecase;


    public AuthController(SessionUsecase sessionUsecase,AuthUsecase authUsecase) {
        this.sessionUsecase = sessionUsecase;
        this.authUsecase=authUsecase;
    }

    @PostMapping("/login")
  public UserSession login(HttpSession session,@RequestBody UserDTO userDTO){

    UserEntity userEntity=authUsecase.comparePass(userDTO);
    
    session.setAttribute("userId",userEntity.getUserId());
    session.setAttribute("username", userEntity.getUsername());
    session.setAttribute("email", userEntity.getMailaddress());
    UserSession userSession=sessionUsecase.crateUserSession(session);
    
    return userSession;
  }

  @PostMapping("/logout")
  public String logput(HttpSession session){
    session.invalidate();
    return "OK";
  }
}
package com.shoppingapp.app.auth.usecase;

import org.springframework.beans.factory.annotation.Autowired;

import com.shoppingapp.app.auth.core.domain.model.factory.ISessionFactory;
import com.shoppingapp.app.auth.core.domain.model.vo.UserSession;
import com.shoppingapp.app.auth.core.domain.service.interacter.ISessionStore;

public class SessionUsecase{

  private final ISessionStore sessionStore;
  private final ISessionFactory userSessionFactory;

  private final String userId;
  private final String username;
  private final String password;


  @Autowired
  public SessionUsecase(ISessionStore sessionStore, ISessionFactory userSessionFactory){
    this.sessionStore=sessionStore;
    this.userSessionFactory=userSessionFactory;

    userId=this.sessionStore.getUserId();
    username=this.sessionStore.getUsername();
    password=this.sessionStore.getPassword();
  }

  public UserSession crateUserSession(){

    UserSession userSession=userSessionFactory.createUserSession(userId, username, password);
    return userSession;
  }
}
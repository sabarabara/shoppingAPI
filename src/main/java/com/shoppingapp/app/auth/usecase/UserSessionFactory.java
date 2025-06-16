package com.shoppingapp.app.auth.usecase;

import org.springframework.stereotype.Component;

import com.shoppingapp.app.auth.core.domain.model.factory.ISessionFactory;
import com.shoppingapp.app.auth.core.domain.model.vo.UserSession;


@Component
public class UserSessionFactory implements ISessionFactory{

  public UserSession createUserSession(String userId,String username,String password,String email){
    UserSession userSession=new UserSession(userId, username, password,email);
    return userSession;
  }
}
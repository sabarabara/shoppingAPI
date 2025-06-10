package com.shoppingapp.app.auth.core.domain.model.vo;

public class UserSession{

  private final String userId;
  private final String username;
  private final String password;

  public UserSession(String userId,String username, String password){
    this.userId=userId;
    this.username=username;
    this.password=password;
  }

  public String getUserId(){
    return userId;
  }

  public String getUsername(){
    return username;
  }

  public String getPassword(){
    return password;
  }
}
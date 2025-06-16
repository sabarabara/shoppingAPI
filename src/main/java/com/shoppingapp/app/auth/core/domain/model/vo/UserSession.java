package com.shoppingapp.app.auth.core.domain.model.vo;

public class UserSession{

  private final String userId;
  private final String username;
  private final String password;
  private final String email;

  public UserSession(String userId,String username, String password,String email){
    this.userId=userId;
    this.username=username;
    this.password=password;
    this.email=email;
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

  public String getEmail(){
    return email;
  }
}
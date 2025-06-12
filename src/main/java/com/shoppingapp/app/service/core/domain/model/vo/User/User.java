package com.shoppingapp.app.service.core.domain.model.vo.User;

public class User{

  private final Password password;
  private final Username username;
  private final UserId userId;
  private final Email email;

  public User(Password password,Username username,UserId userId, Email email){
    this.password=password;
    this.username=username;
    this.userId=userId;
    this.email=email;
  }

  public String getPassword(){
    return password.getPassword();
  }

  public String getUsername(){
    return username.getUsername();
  }

  public String getUserId(){
    return userId.getUserId();
  }

  public String getEmail(){
    return email.getEmail();
  }
}
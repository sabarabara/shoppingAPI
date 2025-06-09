package com.shoppingapp.app.service.core.domain.model.vo.User;

public class Password{
  private final String password;

  public Password(String password){
    this.password=password;
  }

  public String getPassword(){
    return password;
  }
}
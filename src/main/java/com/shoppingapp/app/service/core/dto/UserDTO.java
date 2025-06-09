package com.shoppingapp.app.service.core.dto;

public class UserDTO{

  private final String username;
  private final String password;

  public UserDTO(String username,String password){
    this.username=username;
    this.password=password;
  }

  public String getName(){
    return username;
  }

  public String getPassword(){
    return password;
  }
}
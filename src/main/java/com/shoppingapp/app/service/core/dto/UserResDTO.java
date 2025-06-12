package com.shoppingapp.app.service.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResDTO{

  private final String username;
  private final String email;

  public UserResDTO(@JsonProperty("username") String username,
                 @JsonProperty("email") String email
                ){
    this.username=username;
    this.email=email;
  }

  public String getUsername(){
    return username;
  }

  public String getEmail(){
    return email;
  }
}
package com.shoppingapp.app.service.core.domain.model.vo.User;

public class UserId{
  private final String userId;

  public UserId(String userId){
    this.userId=userId;
  }

  public String getUserId(){
    return userId;
  }
}
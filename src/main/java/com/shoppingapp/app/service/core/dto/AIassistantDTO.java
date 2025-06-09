package com.shoppingapp.app.service.core.dto;


public class AIassistantDTO{

  private final String message;

  public AIassistantDTO(String message){
    this.message=message;
  }

  public String getMessage(){
    return message;
  }
}
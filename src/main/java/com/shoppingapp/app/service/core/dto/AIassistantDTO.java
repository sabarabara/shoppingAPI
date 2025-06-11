package com.shoppingapp.app.service.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AIassistantDTO{

  private final String message;

  public AIassistantDTO(@JsonProperty("message") String message){
    this.message=message;
  }

  public String getMessage(){
    return message;
  }
}
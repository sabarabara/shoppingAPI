package com.shoppingapp.app.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingapp.app.service.core.dto.AIassistantDTO;
import com.shoppingapp.app.service.usecase.interacter.AIAssistantUsecase;


@RestController
@RequestMapping("/AI")
public class AIAssistantController{

  private final AIAssistantUsecase aiAssistantUsecase;

  public AIAssistantController(AIAssistantUsecase aiAssistantUsecase){
    this.aiAssistantUsecase=aiAssistantUsecase;
  }


  @GetMapping("/get")
  public AIassistantDTO sendMessage(){
    return aiAssistantUsecase.returnAIassistantMessage();
  }
}
package com.shoppingapp.app.service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingapp.app.service.core.dto.AIassistantDTO;


@RestController
@RequestMapping("/AI")
public class AIAssistantController{

  @PostMapping("/post")
  public String sendMessage(AIassistantDTO aiassistantdto){
    return "OK";
  }
}
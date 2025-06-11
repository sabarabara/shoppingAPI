package com.shoppingapp.app.service.usecase.interacter;

import org.springframework.stereotype.Service;

import com.shoppingapp.app.service.core.domain.model.factory.AIAssistant.ISendMessageFactory;
import com.shoppingapp.app.service.core.domain.model.vo.AIAssistant.AIAssistantMessage;
import com.shoppingapp.app.service.core.domain.service.interacter.IAIassistant;
import com.shoppingapp.app.service.core.dto.AIassistantDTO;

@Service
public class AIAssistantUsecase{

  private final IAIassistant aIassistant;
  private final ISendMessageFactory sendMessageFactory;

  public AIAssistantUsecase(IAIassistant aIaIassistant,ISendMessageFactory sendMessageFactory){
    this.aIassistant=aIaIassistant;
    this.sendMessageFactory=sendMessageFactory;
  }

  public AIassistantDTO returnAIassistantMessage(){

  AIAssistantMessage aiAssistantMessage=sendMessageFactory.createSendAssistantMessage();
  AIassistantDTO returnDto=aIassistant.assistYourShopping(aiAssistantMessage);

  return returnDto;
  }
}
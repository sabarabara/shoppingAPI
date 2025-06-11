package com.shoppingapp.app.service.core.domain.service.interacter;

import com.shoppingapp.app.service.core.domain.model.vo.AIAssistant.AIAssistantMessage;
import com.shoppingapp.app.service.core.dto.AIassistantDTO;

public interface IAIassistant {

  public AIassistantDTO assistYourShopping(AIAssistantMessage message);

}
package com.shoppingapp.app.service.core.domain.model.factory.AIAssistant;

import com.shoppingapp.app.service.core.domain.model.vo.AIAssistant.AIAssistantMessage;

public interface ISendMessageFactory {

  public AIAssistantMessage createSendAssistantMessage();
}
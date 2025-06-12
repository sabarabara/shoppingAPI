package com.shoppingapp.app.service.framework.AIassistantServer;

import com.shoppingapp.app.service.core.domain.model.vo.AIAssistant.AIAssistantMessage;
import com.shoppingapp.app.service.core.domain.service.interacter.IAIassistant;
import com.shoppingapp.app.service.core.dto.AIassistantDTO;
import com.shoppingapp.utils.IO.JOut;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;


@Service
public class AIassistant implements IAIassistant{


  @Value("${gemini.api.key}")
  private String apiKey;

  public AIassistantDTO assistYourShopping(AIAssistantMessage message){

    Client client = new Client.Builder().apiKey(apiKey).build();

    /*JOut jout=new JOut();
    jout.p(💡).p(apiKey).e();*/

    String sendingMessage=message.getMessage();
    GenerateContentResponse response =
        client.models.generateContent("gemini-2.0-flash",sendingMessage,null);
        client.close();

        String parsedResponseText=response.text();
        AIassistantDTO recieveMessage=new AIassistantDTO(parsedResponseText);
      return recieveMessage;
  }
}
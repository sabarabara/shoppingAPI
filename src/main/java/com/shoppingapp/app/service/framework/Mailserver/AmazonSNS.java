/*package com.shoppingapp.app.service.framework.Mailserver;

import org.springframework.stereotype.Component;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.SnsException;
import software.amazon.awssdk.services.sns.model.SubscribeRequest;
import software.amazon.awssdk.services.sns.model.SubscribeResponse;

import com.shoppingapp.app.service.core.domain.service.interacter.IMailServer;

@Component
public class AmazonSNS implements IMailServer{

  public String sendCostLim();
}

/* */
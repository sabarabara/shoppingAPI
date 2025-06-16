package com.shoppingapp.app.service.core.domain.service.interacter;

import jakarta.servlet.http.HttpSession;

public interface IMailServer {
  public String sendCostLim(HttpSession session);
}
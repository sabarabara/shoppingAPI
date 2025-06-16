package com.shoppingapp.app.auth.core.domain.service.interacter;

import jakarta.servlet.http.HttpSession;

public interface ISessionStore {
  public abstract String getUserId(HttpSession session);
  public abstract String getUsername(HttpSession session);
  public abstract String getPassword(HttpSession session);
  public abstract String getEmail(HttpSession session);
}
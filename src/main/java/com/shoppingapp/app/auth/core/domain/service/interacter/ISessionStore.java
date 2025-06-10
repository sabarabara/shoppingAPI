package com.shoppingapp.app.auth.core.domain.service.interacter;

public interface ISessionStore {
  public abstract String getUserId();
  public abstract String getUsername();
  public abstract String getPassword();
}
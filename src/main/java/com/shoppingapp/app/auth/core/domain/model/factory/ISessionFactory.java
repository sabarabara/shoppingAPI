package com.shoppingapp.app.auth.core.domain.model.factory;

import com.shoppingapp.app.auth.core.domain.model.vo.UserSession;

public interface ISessionFactory {

  public UserSession createUserSession(String userId,String username,String password);
}
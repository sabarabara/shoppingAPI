package com.shoppingapp.app.auth.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.ObjectProvider;

import com.shoppingapp.app.auth.core.domain.model.factory.ISessionFactory;
import com.shoppingapp.app.auth.core.domain.model.vo.UserSession;
import com.shoppingapp.app.auth.core.domain.service.interacter.ISessionStore;


@Service
public class SessionUsecase {

  private final ObjectProvider<ISessionStore> sessionStoreProvider;
  private final ISessionFactory userSessionFactory;

  @Autowired
  public SessionUsecase(ObjectProvider<ISessionStore> sessionStoreProvider,
                        ISessionFactory userSessionFactory) {
    this.sessionStoreProvider = sessionStoreProvider;
    this.userSessionFactory = userSessionFactory;
  }

  public UserSession crateUserSession() {
    ISessionStore sessionStore = sessionStoreProvider.getObject();
    String userId = sessionStore.getUserId();
    String username = sessionStore.getUsername();
    String password = sessionStore.getPassword();

    return userSessionFactory.createUserSession(userId, username, password);
  }
}
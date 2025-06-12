package com.shoppingapp.app.auth.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.shoppingapp.app.auth.core.domain.service.interacter.ISessionStore;

import jakarta.servlet.http.HttpSession;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionStore implements ISessionStore{

  public String getUserId(HttpSession session){
    return (String) session.getAttribute("userId");
  }

  public String getUsername(HttpSession session){
    return (String) session.getAttribute("username");
  }

  public String getPassword(HttpSession session){
    return (String) session.getAttribute("password");
  }
}
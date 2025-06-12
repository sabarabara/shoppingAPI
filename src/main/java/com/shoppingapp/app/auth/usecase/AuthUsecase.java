package com.shoppingapp.app.auth.usecase;

import com.shoppingapp.app.auth.framework.AuthFramework;
import com.shoppingapp.app.service.core.dto.UserDTO;
import com.shoppingapp.app.service.core.entity.UserEntity;
import com.shoppingapp.app.service.usecase.factory.User.UserFactory;

public class AuthUsecase{

  private final AuthFramework authFramework;
  private final UserFactory userFactory;

  public AuthUsecase(AuthFramework authFramework,UserFactory userFactory){
    this.authFramework=authFramework;
    this.userFactory=userFactory;
  }

  public UserEntity comparePass(UserDTO userdto){

    UserEntity userEntity= userFactory.createUsereEntity(userdto);
    return authFramework.comparePassword(userEntity);
  }
}
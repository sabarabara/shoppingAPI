package com.shoppingapp.app.auth.core.domain.service.interacter;

import com.shoppingapp.app.service.core.entity.UserEntity;

public interface IAuthFramework {
  public UserEntity comparePassword(UserEntity userEntity);
}
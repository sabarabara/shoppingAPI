package com.shoppingapp.app.service.core.domain.model.factory.User;

import com.shoppingapp.app.service.core.dto.UserDTO;
import com.shoppingapp.app.service.core.entity.UserEntity;

public interface IUserFactory {
  public UserEntity createUsereEntity(UserDTO userdto);
}
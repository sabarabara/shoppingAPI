package com.shoppingapp.app.auth.framework;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shoppingapp.app.auth.core.domain.service.interacter.IAuthFramework;
import com.shoppingapp.app.service.core.domain.service.interacter.IDBRepository.IUserRepository;
import com.shoppingapp.app.service.core.entity.UserEntity;

@Service
public class AuthFramework implements IAuthFramework{

  private final IUserRepository userRepository;
  public AuthFramework(IUserRepository userRepository){
    this.userRepository=userRepository;
  }

  public UserEntity comparePassword(UserEntity userEntity){
    String email=userEntity.getMailaddress();
    Optional<UserEntity> originuEntity=userRepository.findByEmail(email);

    if(!originuEntity.isPresent()) new Error("you should 新規登録 してね");

    String password=userEntity.getPassword();
    String originalpassword=originuEntity.get().getPassword();

    if(password!=originalpassword) new Error("pass or email is not corrected");

    return userEntity;
  }
}
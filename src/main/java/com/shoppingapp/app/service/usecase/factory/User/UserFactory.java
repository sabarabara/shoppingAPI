package com.shoppingapp.app.service.usecase.factory.User;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shoppingapp.app.service.core.domain.model.factory.User.IUserFactory;
import com.shoppingapp.app.service.core.domain.model.vo.User.Email;
import com.shoppingapp.app.service.core.domain.model.vo.User.Password;
import com.shoppingapp.app.service.core.domain.model.vo.User.User;
import com.shoppingapp.app.service.core.domain.model.vo.User.UserId;
import com.shoppingapp.app.service.core.domain.model.vo.User.Username;
import com.shoppingapp.app.service.core.domain.service.generater.IdGenerator;
import com.shoppingapp.app.service.core.domain.service.interacter.IDBRepository.IUserRepository;
import com.shoppingapp.app.service.core.dto.UserDTO;
import com.shoppingapp.app.service.core.entity.UserEntity;

@Service
public class UserFactory implements IUserFactory{

  private final IdGenerator idGenerator;
  private final IUserRepository userRepository;

  public UserFactory(IdGenerator idGenerator,IUserRepository userRepository){
    this.idGenerator=idGenerator;
    this.userRepository=userRepository;
  }

  public UserEntity createUsereEntity(UserDTO userdto){

    Username username=new Username(userdto.getUsername());
    Password password=new Password(userdto.getPassword());
    Email email =new Email(userdto.getEmail());

    //ここにそのemailがいるかの判定
    Optional<UserEntity> detectUserEntity= userRepository.findByEmail(email.getEmail());

    String prevalidatedduserid;
    if(detectUserEntity.isPresent()) prevalidatedduserid=detectUserEntity.get().getUserId();
    else prevalidatedduserid=idGenerator.generate("users");

    UserId userId=new UserId(prevalidatedduserid);

    User user=new User(password, username, userId, email);

    String validatedPassword=user.getPassword();
    String validatedUsername=user.getUsername();
    String validatedUserId=user.getUserId();
    String validatedEmail=user.getEmail();

    UserEntity userEntity= new UserEntity(validatedUserId, validatedUsername, validatedPassword, validatedEmail);

    return userEntity;
  }
}
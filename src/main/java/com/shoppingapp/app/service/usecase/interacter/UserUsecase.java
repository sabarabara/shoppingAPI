package com.shoppingapp.app.service.usecase.interacter;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shoppingapp.app.auth.core.domain.model.vo.UserSession;
import com.shoppingapp.app.auth.usecase.SessionUsecase;
import com.shoppingapp.app.service.core.domain.model.factory.User.IUserFactory;
import com.shoppingapp.app.service.core.domain.service.interacter.IDBRepository.IUserRepository;
import com.shoppingapp.app.service.core.dto.UserDTO;
import com.shoppingapp.app.service.core.dto.UserResDTO;
import com.shoppingapp.app.service.core.entity.UserEntity;
import com.shoppingapp.utils.IO.JOut;

import jakarta.servlet.http.HttpSession;

@Service
public class UserUsecase{

  private final IUserRepository userRepository;
  private final SessionUsecase sessionUsecase;
  private final IUserFactory userFactory;

  public UserUsecase(IUserRepository userRepository,SessionUsecase sessionUsecase,IUserFactory userFactory){
    this.userRepository=userRepository;
    this.sessionUsecase=sessionUsecase;
    this.userFactory=userFactory;
  }

  public UserResDTO getUser(HttpSession session){
    

    UserSession userSession=sessionUsecase.crateUserSession(session);
    String userId =userSession.getUserId();


    
    Optional<UserEntity> userEntity=userRepository.findByUserId(userId);


    String validatedemail=userEntity.get().getMailaddress();
    String validatedusername=userEntity.get().getUsername();

    UserResDTO userResDTO=new UserResDTO(validatedusername, validatedemail);
    return userResDTO;
  }

  public String createUser(UserDTO userDTO){

    UserEntity userEntity=userFactory.createUsereEntity(userDTO);
    UserEntity savedUserEntity=userRepository.save(userEntity);

    return "saved User";
  }
}
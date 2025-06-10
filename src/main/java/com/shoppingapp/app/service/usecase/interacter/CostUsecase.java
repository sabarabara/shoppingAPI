package com.shoppingapp.app.service.usecase.interacter;

import org.springframework.stereotype.Service;

import com.shoppingapp.app.service.core.domain.service.interacter.IMailServer;
import com.shoppingapp.app.service.core.domain.service.interacter.IDBRepository.IUserCostLimRepository;
import com.shoppingapp.app.service.core.domain.service.interacter.IDBRepository.IUserRepository;
import com.shoppingapp.app.service.core.dto.ShoppingMemoDTO;

@Service
public class CostUsecase{

  private final IUserRepository userRepository;
  private final IUserCostLimRepository userCostLimRepository;
  private final IMailServer mailServer;

  public String sendCostData(ShoppingMemoDTO shoppingmemodto){
    
    return "OK";
  }

  public String recieveSCostData(ShoppingMemoDTO shoppingMemoDTO){

  }
} 
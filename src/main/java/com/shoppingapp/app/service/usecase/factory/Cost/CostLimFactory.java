package com.shoppingapp.app.service.usecase.factory.Cost;

import java.util.Optional;

import com.shoppingapp.app.auth.core.domain.model.vo.UserSession;
import com.shoppingapp.app.auth.usecase.SessionUsecase;
import com.shoppingapp.app.service.core.domain.model.vo.Cost.CostLim;
import com.shoppingapp.app.service.core.domain.service.interacter.IDBRepository.IUserCostLimRepository;
import com.shoppingapp.app.service.core.dto.CostLimDTO;
import com.shoppingapp.app.service.core.entity.UserCostLimEntity;
import com.shoppingapp.app.service.framework.DBserver.IdGeneratorImpl;

import jakarta.servlet.http.HttpSession;

public class CostLimFactory{

  private final IUserCostLimRepository userCostLimRepository;
  private final SessionUsecase sessionUsecase;
  private final IdGeneratorImpl idGeneratorImpl;


  public CostLimFactory(IUserCostLimRepository userCostLimRepository,SessionUsecase sessionUsecase,IdGeneratorImpl idGeneratorImpl){
    this.userCostLimRepository=userCostLimRepository;
    this.sessionUsecase=sessionUsecase;
    this.idGeneratorImpl=idGeneratorImpl;
  }
  public
  
  UserCostLimEntity createCostLim(HttpSession session,CostLimDTO costLimDTO){

    UserSession userSession = sessionUsecase.crateUserSession(session);
    String userId = userSession.getUserId();

    int parseCostLim=costLimDTO.getCostLim();
    CostLim costLim=new CostLim(parseCostLim);

    int validatedCostLim=costLim.getCostLim();

    Optional<UserCostLimEntity> resUserCostLimEntity = userCostLimRepository.findByUserId(userId);

    String costLimId;

    if(resUserCostLimEntity.isPresent()){
      costLimId=resUserCostLimEntity.get().getUserCostLimId();
    }else{
      costLimId=idGeneratorImpl.generate("costlim");
    }

    UserCostLimEntity userCostLimEntity = new UserCostLimEntity(costLimId, userId, validatedCostLim);

    return userCostLimEntity;
  }
}
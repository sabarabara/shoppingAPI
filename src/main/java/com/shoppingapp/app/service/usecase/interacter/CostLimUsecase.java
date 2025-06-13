package com.shoppingapp.app.service.usecase.interacter;

import java.util.Optional;

import com.shoppingapp.app.auth.core.domain.model.vo.UserSession;
import com.shoppingapp.app.auth.usecase.SessionUsecase;
import com.shoppingapp.app.service.core.domain.service.interacter.IDBRepository.IUserCostLimRepository;
import com.shoppingapp.app.service.core.dto.CostLimDTO;
import com.shoppingapp.app.service.core.entity.UserCostLimEntity;
import com.shoppingapp.app.service.usecase.factory.Cost.CostLimFactory;

import jakarta.servlet.http.HttpSession;

public class CostLimUsecase{

  private final IUserCostLimRepository userCostLimRepository;
  private final CostLimFactory costLimFactory;
  private final SessionUsecase sessionUsecase;


  public CostLimUsecase(IUserCostLimRepository userCostLimRepository,CostLimFactory costLimFactory,SessionUsecase sessionUsecase){
    this.userCostLimRepository=userCostLimRepository;
    this.costLimFactory=costLimFactory;
    this.sessionUsecase=sessionUsecase;
  }

  public CostLimDTO postCostLim(HttpSession session,CostLimDTO costLimDTO){

    UserCostLimEntity userCostLimEntity = costLimFactory.createCostLim(session, costLimDTO);
    int resCostLim = userCostLimEntity.getCostLim();
    CostLimDTO resCostLimdto = new CostLimDTO(resCostLim);

    return resCostLimdto;
  }



  public CostLimDTO getCostLim(HttpSession session){

    UserSession userSession = sessionUsecase.crateUserSession(session);
    String userId = userSession.getUserId();

    Optional<UserCostLimEntity> userCostLimEntity = userCostLimRepository.findByUserId(userId);

    //ないときのエラーハンドリングをかこう！ あとで...
    int resCostLim = userCostLimEntity.get().getCostLim();
    CostLimDTO resCostLimdto = new CostLimDTO(resCostLim);

    return resCostLimdto;
  }
}
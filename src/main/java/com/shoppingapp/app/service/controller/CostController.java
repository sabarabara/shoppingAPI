package com.shoppingapp.app.service.controller;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.shoppingapp.app.service.core.dto.CostLimDTO;
import com.shoppingapp.app.service.core.dto.ShoppingMemoDTO;
import com.shoppingapp.app.service.usecase.interacter.CostLimUsecase;
import com.shoppingapp.app.service.usecase.interacter.CostUsecase;

import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/Cost")

public class CostController{

  private final CostUsecase costUsecase;
  private final CostLimUsecase costLimUsecase;

  public CostController(CostUsecase costUsecase,CostLimUsecase costLimUsecase){
    this.costUsecase=costUsecase;
    this.costLimUsecase=costLimUsecase;
  }

  @PostMapping("/post")
  public String postShoppingMemo(HttpSession session,@RequestBody ShoppingMemoDTO shoppingMemodto){
    return costUsecase.sendCostData(session,shoppingMemodto);
  }

  @GetMapping("get-all")
  public List<ShoppingMemoDTO> getShoppingMemoMonths(HttpSession session){
    return costUsecase.recieveCostDataofMonths(session);
  }

  @GetMapping("get-one")
  public ShoppingMemoDTO getShoppingMemoofMonth(HttpSession session){
    return costUsecase.receiveCostDataofMonth(session);
  }

  @PostMapping("post-costlim")
  public CostLimDTO postCostLim(HttpSession session,@RequestBody CostLimDTO costLimDTO){
    return costLimUsecase.postCostLim(session, costLimDTO);
  }

  @GetMapping("get-costlim")
  public CostLimDTO getCostlim(HttpSession session){
    return costLimUsecase.getCostLim(session);
  }
}
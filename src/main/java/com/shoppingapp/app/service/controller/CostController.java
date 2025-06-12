package com.shoppingapp.app.service.controller;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.shoppingapp.app.service.core.dto.ShoppingMemoDTO;
import com.shoppingapp.app.service.usecase.interacter.CostUsecase;

import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/Cost")

public class CostController{

  private final CostUsecase costUsecase;

  public CostController(CostUsecase costUsecase){
    this.costUsecase=costUsecase;
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
  
}
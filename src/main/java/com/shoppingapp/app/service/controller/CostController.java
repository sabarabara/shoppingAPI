package com.shoppingapp.app.service.controller;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.shoppingapp.app.service.core.dto.ShoppingMemoDTO;
import com.shoppingapp.app.service.usecase.interacter.CostUsecase;


@RestController
@RequestMapping("/Cost")

public class CostController{

  private final CostUsecase costUsecase;

  public CostController(CostUsecase costUsecase){
    this.costUsecase=costUsecase;
  }

  @PostMapping("/post")
  public String postShoppingMemo(@RequestBody ShoppingMemoDTO shoppingMemodto){
    return costUsecase.sendCostData(shoppingMemodto);
  }

  @GetMapping("get-all")
  public List<ShoppingMemoDTO> getShoppingMemoMonths(){
    return costUsecase.recieveCostDataofMonths();
  }

  @GetMapping("get-one")
  public ShoppingMemoDTO getShoppingMemoofMonth(){
    return costUsecase.receiveCostDataofMonth();
  }
  
}
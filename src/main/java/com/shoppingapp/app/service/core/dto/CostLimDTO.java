package com.shoppingapp.app.service.core.dto;

public class CostLimDTO{

  private final int costlim;

  public CostLimDTO(int costlim){
    this.costlim=costlim;
  }

  public int getCostLim(){
    return costlim;
  }
}
package com.shoppingapp.app.service.core.domain.model.vo.Cost;

public class CostLim{

  private final int costlim;

  public CostLim(int costlim){
    this.costlim=costlim;
  }

  public int getCostLim(){
    return costlim;
  }
}
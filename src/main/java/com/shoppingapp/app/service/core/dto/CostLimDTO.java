package com.shoppingapp.app.service.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CostLimDTO{

  private final int costlim;

  public CostLimDTO(@JsonProperty("costlim") int costlim){
    this.costlim=costlim;
  }

  public int getCostLim(){
    return costlim;
  }
}
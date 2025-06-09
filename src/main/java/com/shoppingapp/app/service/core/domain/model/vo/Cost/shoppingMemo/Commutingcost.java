package com.shoppingapp.app.service.core.domain.model.vo.Cost.shoppingMemo;

import com.shoppingapp.app.service.core.domain.model.vo.Cost.Money;

public class Commutingcost{

  private final Money commutingcost;

  public Commutingcost(Money commutingcost){
    this.commutingcost=commutingcost;
  }

  public Money getCommutingcost(){
    return commutingcost;
  }
}
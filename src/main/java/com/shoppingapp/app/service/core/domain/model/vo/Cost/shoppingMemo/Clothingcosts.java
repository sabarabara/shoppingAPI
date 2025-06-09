package com.shoppingapp.app.service.core.domain.model.vo.Cost.shoppingMemo;

import com.shoppingapp.app.service.core.domain.model.vo.Cost.Money;

public class Clothingcosts{

  private final Money clothingcosts;

  public Clothingcosts(Money clothingcosts){
    this.clothingcosts=clothingcosts;
  }

  public Money getClothingcosts(){
    return clothingcosts;
  }
}
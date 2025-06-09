package com.shoppingapp.app.service.core.domain.model.vo.Cost.shoppingMemo;

import com.shoppingapp.app.service.core.domain.model.vo.Cost.Money;

public class Groceries{

  private final Money groceries;

  public Groceries(Money groceries){
    this.groceries=groceries;
  }

  public Money getGroceries(){
    return groceries;
  }
}
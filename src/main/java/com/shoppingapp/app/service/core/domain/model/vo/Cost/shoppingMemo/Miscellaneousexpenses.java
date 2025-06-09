package com.shoppingapp.app.service.core.domain.model.vo.Cost.shoppingMemo;

import com.shoppingapp.app.service.core.domain.model.vo.Cost.Money;

public class Miscellaneousexpenses{

  private final Money miscellaneousexpenses;

  public Miscellaneousexpenses(Money miscellaneousexpenses){
    this.miscellaneousexpenses=miscellaneousexpenses;
  }

  public Money getMiscellaneousexpenses(){
    return miscellaneousexpenses;
  }
}


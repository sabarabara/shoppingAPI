package com.shoppingapp.app.service.core.domain.model.vo.Cost;

public class Money{
  
  private final int amount;

  public Money(int amount){
    if(amount<0){
      throw new IllegalArgumentException("please enter positive number");
    }
    this.amount=amount;
  }

  public int getAmount(){
    return amount;
  }

  
}
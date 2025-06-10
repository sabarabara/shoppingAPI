package com.shoppingapp.app.service.usecase.factory.Cost;

import com.shoppingapp.app.service.core.domain.model.factory.Cost.IShoppingMemoFactory;
import com.shoppingapp.app.service.core.domain.model.vo.Cost.ShoppingMemo;
import com.shoppingapp.app.service.core.domain.model.vo.Cost.Sumcal;
import com.shoppingapp.app.service.core.dto.ShoppingMemoDTO;
import com.shoppingapp.app.service.core.entity.ShoppingMemoEntiry;

public class ShoppingMemoFactory implements IShoppingMemoFactory{

  // dto->voにおけるバリデーション
  public ShoppingMemoEntiry createShoppingMemoEntiry(ShoppingMemoDTO shoppingmemodto){

    final int groceries=shoppingmemodto.getGroceries();
    final int clothingCosts=shoppingmemodto.getClothingcosts();
    final int commutingCost=shoppingmemodto.getCommutingcost();
    final int miscellaneousExpenses=shoppingmemodto.getMiscellaneousexpenses();


    ShoppingMemo shoppingMemo=new ShoppingMemo(groceries, clothingCosts, commutingCost, miscellaneousExpenses);

    //dbschemaへの型の変更

    DateFactory date=new DateFactory();
    final int year=date.getYear();
    final int month=date.getMonth();

    //これfactory作るか悩ましいなんか汚いから後で直す。
    Sumcal sumcal=new Sumcal(shoppingMemo);
    final int sum =sumcal.getSum();


    //ShoppingMemoEntiry shoppingMemoEntiry=new
  }
}
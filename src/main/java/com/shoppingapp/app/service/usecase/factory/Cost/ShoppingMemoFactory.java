package com.shoppingapp.app.service.usecase.factory.Cost;

import org.springframework.stereotype.Service;

import com.shoppingapp.app.auth.core.domain.model.vo.UserSession;
import com.shoppingapp.app.auth.usecase.SessionUsecase;
import com.shoppingapp.app.service.core.domain.model.factory.Cost.IShoppingMemoFactory;
import com.shoppingapp.app.service.core.domain.model.vo.Cost.ShoppingMemo;
import com.shoppingapp.app.service.core.domain.model.vo.Cost.Sumcal;
import com.shoppingapp.app.service.core.dto.ShoppingMemoDTO;
import com.shoppingapp.app.service.core.entity.ShoppingMemoEntiry;
import com.shoppingapp.app.service.framework.DBserver.IdGeneratorImpl;

@Service
public class ShoppingMemoFactory implements IShoppingMemoFactory{

  private final SessionUsecase sessionUsecase;
  private final IdGeneratorImpl idGeneratorImpl;

  public ShoppingMemoFactory(SessionUsecase sessionUsecase,IdGeneratorImpl idGeneratorImpl){
    this.sessionUsecase=sessionUsecase;
    this.idGeneratorImpl=idGeneratorImpl;
  }

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

    //session 作成！
    final UserSession userSession=sessionUsecase.crateUserSession();
    final String userId=userSession.getUserId();

    //採番処理呼び出し
    //String shoppingMemoId=idGeneratorImpl.generate("shoppingMemo");
    String shoppingMemoId="fjkdlsadfa";

    //validation後の
    final int validatedGroceries=shoppingMemo.getGroceries().getAmount();
    final int validatedClothingCosts=shoppingMemo.getClothingcosts().getAmount();
    final int validatedCommutingCost=shoppingMemo.getCommutingcost().getAmount();
    final int validatedMiscellaneousExpenses=shoppingMemo.getMiscellaneousexpenses().getAmount();

    ShoppingMemoEntiry shoppingMemoEntiry=new ShoppingMemoEntiry(shoppingMemoId,userId,month,year,validatedGroceries,validatedCommutingCost,validatedClothingCosts,validatedMiscellaneousExpenses,sum);
    return shoppingMemoEntiry;
  }
}
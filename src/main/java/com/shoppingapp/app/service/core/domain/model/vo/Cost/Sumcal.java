package com.shoppingapp.app.service.core.domain.model.vo.Cost;

public class Sumcal{


    private final Money groceries_yen;
    private final Money clothingcosts_yen;
    private final Money commutingcost_yen;
    private final Money miscellaneousexpenses_yen;

    private final int sum;

  public Sumcal(ShoppingMemo shoppingMemo){
    groceries_yen=shoppingMemo.getGroceries();
    clothingcosts_yen=shoppingMemo.getClothingcosts();
    commutingcost_yen=shoppingMemo.getCommutingcost();
    miscellaneousexpenses_yen=shoppingMemo.getMiscellaneousexpenses();

    sum=groceries_yen.getAmount()+clothingcosts_yen.getAmount()+commutingcost_yen.getAmount()+miscellaneousexpenses_yen.getAmount();
  }

  public int getSum(){
    return sum;
  }
}
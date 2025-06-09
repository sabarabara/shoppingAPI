package com.shoppingapp.app.service.core.domain.model.vo.Cost;



import com.shoppingapp.app.service.core.domain.model.vo.Cost.shoppingMemo.Clothingcosts;
import com.shoppingapp.app.service.core.domain.model.vo.Cost.shoppingMemo.Commutingcost;
import com.shoppingapp.app.service.core.domain.model.vo.Cost.shoppingMemo.Groceries;
import com.shoppingapp.app.service.core.domain.model.vo.Cost.shoppingMemo.Miscellaneousexpenses;

public class ShoppingMemo{

  private final Groceries groceries;
  private final Clothingcosts clothingcosts;
  private final Commutingcost commutingcost;
  private final Miscellaneousexpenses miscellaneousexpenses;

  public ShoppingMemo(Groceries groceries,Clothingcosts clothingcosts,Commutingcost commutingcost,Miscellaneousexpenses miscellaneousexpenses){

    this.groceries=groceries;
    this.clothingcosts=clothingcosts;
    this.commutingcost=commutingcost;
    this.miscellaneousexpenses=miscellaneousexpenses;
  }

  public Money getGroceries(){
    return groceries.getGroceries();
  }

  public Money getClothingcosts(){
    return clothingcosts.getClothingcosts();
  }

  public Money getCommutingcost(){
    return commutingcost.getCommutingcost();
  }

  public Money getMiscellaneousexpenses(){
    return miscellaneousexpenses.getMiscellaneousexpenses();
  }

  
}
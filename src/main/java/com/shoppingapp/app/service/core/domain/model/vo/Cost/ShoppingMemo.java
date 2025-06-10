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

  public ShoppingMemo(int  groceries_i,int  clothingcosts_i,int  commutingcost_i,int  miscellaneousexpenses_i){
    groceries=new Groceries(new Money(groceries_i));
    clothingcosts=new Clothingcosts(new Money(clothingcosts_i));
    commutingcost=new Commutingcost(new Money(commutingcost_i));
    miscellaneousexpenses=new Miscellaneousexpenses(new Money(miscellaneousexpenses_i));
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
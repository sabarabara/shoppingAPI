package com.shoppingapp.app.service.core.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ShoppingMemoDTO {
  private final int groceries;
  private final int commutingcost;
  private final int clothingcosts;
  private final int miscellaneousexpenses;

  @JsonCreator
  public ShoppingMemoDTO(
    @JsonProperty("groceries") int groceries,
    @JsonProperty("commutingcost") int commutingcost,
    @JsonProperty("clothingcosts") int clothingcosts,
    @JsonProperty("miscellaneousexpenses") int miscellaneousexpenses
  ) {
    this.groceries = groceries;
    this.commutingcost = commutingcost;
    this.clothingcosts = clothingcosts;
    this.miscellaneousexpenses = miscellaneousexpenses;
  }

  public int getGroceries() {
    return groceries;
  }

  public int getCommutingcost() {
    return commutingcost;
  }

  public int getClothingcosts() {
    return clothingcosts;
  }

  public int getMiscellaneousexpenses() {
    return miscellaneousexpenses;
  }
}

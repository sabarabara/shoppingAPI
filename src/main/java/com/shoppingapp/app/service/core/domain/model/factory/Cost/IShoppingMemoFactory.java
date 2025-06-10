package com.shoppingapp.app.service.core.domain.model.factory.Cost;

import com.shoppingapp.app.service.core.dto.ShoppingMemoDTO;
import com.shoppingapp.app.service.core.entity.ShoppingMemoEntiry;

public interface IShoppingMemoFactory {
  public ShoppingMemoEntiry createShoppingMemoEntiry(ShoppingMemoDTO shoppingmemodto);
}
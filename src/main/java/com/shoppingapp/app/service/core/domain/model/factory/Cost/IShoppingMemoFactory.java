package com.shoppingapp.app.service.core.domain.model.factory.Cost;

import com.shoppingapp.app.service.core.dto.ShoppingMemoDTO;
import com.shoppingapp.app.service.core.entity.ShoppingMemoEntiry;

import jakarta.servlet.http.HttpSession;

public interface IShoppingMemoFactory {
  public ShoppingMemoEntiry createShoppingMemoEntiry(HttpSession session,String shoppingMemoId,ShoppingMemoDTO shoppingmemodto);
}
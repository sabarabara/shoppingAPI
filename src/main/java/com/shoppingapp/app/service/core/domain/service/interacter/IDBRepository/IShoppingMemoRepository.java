package com.shoppingapp.app.service.core.domain.service.interacter.IDBRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingapp.app.service.core.entity.ShoppingMemoEntiry;

public interface IShoppingMemoRepository extends JpaRepository<ShoppingMemoEntiry,String>{
  Optional<ShoppingMemoEntiry> findByUserIdAndMonthAndYear(String userId, int month, int year);
  List<Optional<ShoppingMemoEntiry>> findByUserIdAndYear(String userId, int month);
}
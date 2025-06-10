package com.shoppingapp.app.service.core.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="shopping_memo")
public class ShoppingMemoEntiry{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer shoppingMemoId;

  @Column()
  private int userId;

  @Column(nullable = false)
  private int month;

  @Column(nullable = false)
  private int year;

  @Column(nullable = false)
  private int groceries;

  @Column(nullable = false)
  private int commutingCost;

  @Column(nullable = false)
  private int clothingCosts;
  
  @Column(nullable = false)
  private int miscellaneousExpenses;

  @Column(nullable = false)
  private int sum;

  public ShoppingMemoEntiry(){
    
  }

}
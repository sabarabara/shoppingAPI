package com.shoppingapp.app.service.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shopping_memo")
public class ShoppingMemoEntiry {


    @Id
    @Column()
    private String shoppingMemoId;

    @Column()
    private String userId;

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


    public ShoppingMemoEntiry() {
    }

    public ShoppingMemoEntiry(
        String shoppingMemoId,
        String userId,
        int month,
        int year,
        int groceries,
        int commutingCost,
        int clothingCosts,
        int miscellaneousExpenses,
        int sum
    ) {
        this.shoppingMemoId=shoppingMemoId;
        this.userId = userId;
        this.month = month;
        this.year = year;
        this.groceries = groceries;
        this.commutingCost = commutingCost;
        this.clothingCosts = clothingCosts;
        this.miscellaneousExpenses = miscellaneousExpenses;
        this.sum = sum;
    }

    public String getShoppingMemoId() {
        return shoppingMemoId;
    }

    public String getUserId() {
        return userId;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getGroceries() {
        return groceries;
    }

    public int getCommutingCost() {
        return commutingCost;
    }

    public int getClothingCosts() {
        return clothingCosts;
    }

    public int getMiscellaneousExpenses() {
        return miscellaneousExpenses;
    }

    public int getSum() {
        return sum;
    }

    

    public ShoppingMemoEntiry getShoppingMemoEntiry(){
      return this;
    }
}

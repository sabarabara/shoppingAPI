package com.shoppingapp.app.service.usecase.factory.Cost;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class DateFactory{

  private final int year;
  private final int month;

  public DateFactory(){

    LocalDate now=LocalDate.now();
    this.year =  now.getYear();
    this.month = now.getMonthValue();
  }

  public int getYear(){
    return year;
  }

  public int getMonth(){
    return month;
  }
}
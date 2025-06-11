package com.shoppingapp.app.service.usecase.factory.Cost;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class DateFactory{

  private final int year;
  private final int month;

  public DateFactory(){
    year=LocalDate.now().getDayOfYear();
    month=LocalDate.now().getDayOfMonth();
  }

  public int getYear(){
    return year;
  }

  public int getMonth(){
    return month;
  }
}
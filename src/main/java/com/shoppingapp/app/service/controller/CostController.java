package com.shoppingapp.app.service.controller;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import com.shoppingapp.app.service.core.dto.ShoppingMemoDTO;


@RestController
@RequestMapping("/Cost")

public class CostController{

  @PostMapping("/post")
  public ShoppingMemoDTO postShoppingMemo(@RequestBody ShoppingMemoDTO shoppingMemodto){
    return shoppingMemodto;
  }

  /*@GetMapping("get")
  public ShoppingMemoDTO getShoppingMemo(HttpSession session){
  }*/
}
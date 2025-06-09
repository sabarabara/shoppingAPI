package com.shoppingapp.app.service.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="UserCostLim")
public class UserCostLimEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer userCostLimId;

  @Column(nullable = false)
  private Integer userId;

  @Column(nullable = false)
  private int costLim;
}
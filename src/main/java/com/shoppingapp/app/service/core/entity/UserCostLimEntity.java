package com.shoppingapp.app.service.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_cost_lim")
public class UserCostLimEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column()
  private String userCostLimId;

  @Column(nullable = false)
  private String userId;

  @Column(nullable = false)
  private int costLim;

  public UserCostLimEntity() {}

    public UserCostLimEntity(String userCostLimId, String userId, int costLim) {
        this.userCostLimId = userCostLimId;
        this.userId = userId;
        this.costLim = costLim;
    }

    // Getter
    public String getUserCostLimId() {
        return userCostLimId;
    }

    public String getUserId() {
        return userId;
    }

    public int getCostLim() {
        return costLim;
    }
}
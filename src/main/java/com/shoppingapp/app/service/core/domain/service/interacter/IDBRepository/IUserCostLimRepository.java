package com.shoppingapp.app.service.core.domain.service.interacter.IDBRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingapp.app.service.core.entity.UserCostLimEntity;

public interface IUserCostLimRepository extends JpaRepository<UserCostLimEntity,Integer>{
}
package com.shoppingapp.app.service.core.domain.service.interacter.IDBRepository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingapp.app.service.core.entity.UserCostLimEntity;

public interface IUserCostLimRepository extends JpaRepository<UserCostLimEntity,Integer>{

  Optional<UserCostLimEntity> findByuserId(String userId);
}
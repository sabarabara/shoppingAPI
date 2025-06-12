package com.shoppingapp.app.service.core.domain.service.interacter.IDBRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shoppingapp.app.service.core.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity,String>{
  Optional<UserEntity> findByUserId(String userId);
  Optional<UserEntity> findByEmail(String email);
}
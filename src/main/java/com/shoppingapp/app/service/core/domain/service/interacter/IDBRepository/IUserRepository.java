package com.shoppingapp.app.service.core.domain.service.interacter.IDBRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingapp.app.service.core.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity,Integer>{

  
}
package com.example.diasoft.repository;

import com.example.diasoft.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long>{
    UserEntity findByName (String name);
}

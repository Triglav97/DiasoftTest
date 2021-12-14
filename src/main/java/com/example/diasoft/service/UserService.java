package com.example.diasoft.service;

import com.example.diasoft.entity.UserEntity;
import com.example.diasoft.exception.BDEmpty;
import com.example.diasoft.exception.UserAlreadyExistException;
import com.example.diasoft.exception.UserNotFoundException;
import com.example.diasoft.model.User;
import com.example.diasoft.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByName(user.getName()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        Optional<UserEntity> user = userRepo.findById(id);
        System.out.println();
        if (!user.isPresent()) {
            throw new UserNotFoundException("Пользователь с таким id не найден");
        }
        return User.toModel(user);
    }

    public Long delete(Long id) throws UserNotFoundException {
//        Optional<UserEntity> user = userRepo.findById(id);
//        if (!user.isPresent()) {
//            throw new UserNotFoundException("Пользователь с таким id не найден");
//        }
        userRepo.deleteById(id);
        return id;
    }

    public Set<User> getAllUsers() throws BDEmpty {
        List<UserEntity> users = (List<UserEntity>) userRepo.findAll();
        Set<User> usersSet = new HashSet<>();
        if (users.isEmpty()){
            throw new BDEmpty("бд пустая");
        }
        for(UserEntity u:users){
            usersSet.add(User.toModel(Optional.ofNullable(u)));
        }
        return usersSet;
    }
}

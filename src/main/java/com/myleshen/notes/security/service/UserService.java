package com.myleshen.notes.security.service;

import com.myleshen.notes.security.entity.UserEntity;
import com.myleshen.notes.security.model.UserModel;
import com.myleshen.notes.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = userRepository.findByUserName(userName);

        userEntity.orElseThrow(() -> new UsernameNotFoundException("The User Name " + userName + " is not found" ));

        return userEntity.map(UserModel::new).get();
    }

    public void addUser(UserEntity userEntity) {
        this.userRepository.save(userEntity);
    }

    public void addAdminUser(UserEntity userEntity) {
        this.userRepository.save(userEntity);
    }

    public UUID findUserUUID(String userName) {
        Optional<UserEntity> userEntity = this.userRepository.findByUserName(userName);
        return userEntity.map(UserEntity::getId).orElse(null);
    }


    public UserEntity findByUserName(String userName) {
        Optional<UserEntity> userEntity = userRepository.findByUserName(userName);
        return userEntity.get();
    }

}

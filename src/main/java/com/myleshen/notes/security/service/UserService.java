package com.myleshen.notes.security.service;

import com.myleshen.notes.security.entity.UserEntity;
import com.myleshen.notes.security.dao.UserDao;
import com.myleshen.notes.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

        return userEntity.map(UserDao::new).get();
    }
}

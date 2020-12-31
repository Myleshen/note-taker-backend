package com.myleshen.notes.security.service;

import com.myleshen.notes.security.entity.UserEntity;
import com.myleshen.notes.security.model.UserModel;
import com.myleshen.notes.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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
        userEntity.setUserPass(passwordEncoder.encode(userEntity.getUserPass()));
        userEntity.setRoleList("USER");
        userEntity.setActive(true);
        userEntity.setId(UUID.randomUUID());
        this.userRepository.save(userEntity);
    }

    public void addAdminUser(UserEntity userEntity) {
        userEntity.setUserPass(passwordEncoder.encode(userEntity.getUserPass()));
        userEntity.setRoleList("ADMIN");
        userEntity.setActive(true);
        userEntity.setId(UUID.randomUUID());
        this.userRepository.save(userEntity);
    }

}

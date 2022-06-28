package com.car.rental.service.impl;

import com.car.rental.entity.UserInfo;
import com.car.rental.repository.UserRepository;
import com.car.rental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void saveUser(UserInfo userInfo) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(userInfo.getPassword().getBytes());
        userInfo.setPassword(new BigInteger(1, md5.digest()).toString(16));
        userRepository.save(userInfo);
    }
    @Override
    public void updateUserInfoById(UserInfo userInfo) {
        userRepository.save(userInfo);
    }

    @Override
    public void deleteUserInfoById(int userInfoId) {
        userRepository.deleteById(userInfoId);
    }

    @Override
    public UserInfo getUserInfoById(int userInfoId) {
        Optional<UserInfo> User = userRepository.findById(userInfoId);
        return Optional.ofNullable(User).get().orElse(null);
    }

    @Override
    public List<UserInfo> getUsers() {
        return userRepository.findAll();
    }

}

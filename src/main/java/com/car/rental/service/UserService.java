package com.car.rental.service;

import com.car.rental.entity.UserInfo;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {

    void saveUser(UserInfo userInfo) throws NoSuchAlgorithmException;

    void updateUserInfoById(UserInfo userInfo);

    void deleteUserInfoById(int userInfoId);

    UserInfo getUserInfoById(int userInfoId);

    List<UserInfo> getUsers();


}

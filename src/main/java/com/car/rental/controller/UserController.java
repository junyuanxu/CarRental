package com.car.rental.controller;

import com.car.rental.common.CommonResult;
import com.car.rental.entity.UserInfo;
import com.car.rental.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService UserInfoService;

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<UserInfo> getUserInfoList() {
        return UserInfoService.getUsers();
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public CommonResult saveUser(@RequestBody UserInfo userInfo) {
        try {
            UserInfoService.saveUser(userInfo);
            return CommonResult.success("register success");
        } catch (Exception e) {
            log.info("register user fail, error is {}",e);
            return CommonResult.error("register fail");
        }
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public CommonResult getUserInfo(@PathVariable int id) {
        return new CommonResult(CommonResult.Type.SUCCESS,"success",UserInfoService.getUserInfoById(id));
    }

    @RequestMapping(value="", method=RequestMethod.PUT)
    public CommonResult putUserInfo(@RequestBody UserInfo UserInfo) {
        UserInfoService.updateUserInfoById(UserInfo);
        return CommonResult.success("success");
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUserInfo(@PathVariable int id) {
        UserInfoService.deleteUserInfoById(id);
        return "success";
    }


}

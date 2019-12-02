package com.atguigu.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Reference
    private UserService userService;

    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser(){
       List<UmsMember> umsMembersms =  userService.findAll();
        return umsMembersms;
    }

    @RequestMapping("/getUserAddress")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getUserAddress(String member_id){
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses =  userService.getUserAddress(member_id);

        return umsMemberReceiveAddresses;
    }

    @RequestMapping("/index")
    @ResponseBody
    public String index(){

        return "hello user";
    }
}



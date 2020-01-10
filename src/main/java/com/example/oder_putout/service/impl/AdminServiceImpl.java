package com.example.oder_putout.service.impl;

import com.example.oder_putout.respository.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl {
    @Autowired
    private AdminDao adminDao;
    public int login(int id,String password){
        if(adminDao.findIdAndPassword(id,password)==null){
            System.out.println("账号或密码错误");
        return 0;}
        else
            System.out.println("登录成功");
        return 1;
    }
}

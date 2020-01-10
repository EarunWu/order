package com.example.oder_putout.service.impl;

import com.example.oder_putout.respository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl {
    @Autowired
    CustomerDao customerDao;
    public int addCustomer(String name,String address,int tel,String easyWrite){
        return customerDao.addCustomer(name, address, tel, easyWrite);
    }
}

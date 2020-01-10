package com.example.oder_putout.service.impl;

import com.example.oder_putout.entity.OrderGoods;
import com.example.oder_putout.entity.OrderInfo;
import com.example.oder_putout.respository.OrderDao;
import com.example.oder_putout.respository.OrderInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl {
    @Autowired
    OrderDao orderDao;
    @Autowired
    OrderInfoDao orderInfoDao;
    public List<Map<String,Object>> findAOrderList(int orderId){
        orderInfoDao.updateOrderPrice(orderInfoDao.orderPrice(orderId),orderId);
        return orderDao.findOrderList(orderId);
    }
    public int setOrderPrice(int orderId){
        return orderDao.updateOrderPrice(orderDao.findOrderPrice(orderId),orderId);
    }
    public Map<String,Object> getOrderInfo(int orderId){
        return orderDao.findOrderById(orderId);
    }
    public int addOrder(String customer){
        orderInfoDao.insertOrder(customer);
        return orderDao.findMaxId();
    }
}

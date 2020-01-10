package com.example.oder_putout.service;

import com.example.oder_putout.entity.OrderGoods;
import com.example.oder_putout.entity.OrderInfo;

import java.util.List;
import java.util.Map;

public interface OrderService {
    public List<Map<String,Object>> findAOrderList(int orderId);
    public int addOrder(int customer);
    public Map<String,Object> getOrderInfo(int orderId);
}

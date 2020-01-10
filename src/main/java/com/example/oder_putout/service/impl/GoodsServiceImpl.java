package com.example.oder_putout.service.impl;

import com.example.oder_putout.entity.Goods;
import com.example.oder_putout.respository.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl {
    @Autowired
    GoodsDao goodsDao;
    public List<Goods> getGoodsList(){
        return goodsDao.findAllGoods();
    }
}

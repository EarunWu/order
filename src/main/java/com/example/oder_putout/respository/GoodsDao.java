package com.example.oder_putout.respository;


import com.example.oder_putout.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GoodsDao extends JpaRepository<Goods,Integer> {
    @Query(value = "select * from goods where stock!=1 and categories=1 ORDER BY stock desc",nativeQuery = true)
    public List<Goods> findAllGoods();
    @Query(value = "SELECT * FROM goods WHERE id=?1",nativeQuery = true)
    public Goods findgoodsById(int goodsId);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO goods(name,price,unit,stock,categories,box_size,easy_write) VALUES (?1,?2,?3,?4,?5,?6,?7)",nativeQuery = true)
    public int addGoods(String name,float price,String unit,int stock,int categories,float box_size,String easy_write);
    @Query(value = "SELECT * FROM goods WHERE (easy_write like %?1% or name like %?1%) and categories=1 ORDER BY stock desc",nativeQuery = true)
    public List<Goods> findGoodsByEW(String easy_write);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO order_goods(goods_id,number,order_id,box_number,price,total_price) VALUES (?1,?2,?3,?4,?5,?6)",nativeQuery = true)
    public int addOrderGoods(int goodsId,float number,int orderId,int boxNumber,float price,float totalPrice);
    @Modifying
    @Transactional
    @Query(value = "UPDATE goods set price=?1 WHERE id=?2",nativeQuery = true)
    public int savePrice(float price,int goodsId);
    @Modifying
    @Transactional
    @Query(value = "UPDATE goods set name=?1,price=?2,stock=?3,unit=?4,box_size=?5,easy_write=?6 WHERE id=?7",nativeQuery = true)
    public int updateGoodsInfo(String name, float price,int stock,String unit,float box_size,String easy_write,int goodsId);
    @Modifying
    @Transactional
    @Query(value = "update goods set categories=0 where id=?1",nativeQuery = true)
    public int deleteGoods(int goodsId);
}

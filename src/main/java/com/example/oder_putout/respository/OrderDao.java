package com.example.oder_putout.respository;

import com.example.oder_putout.entity.OrderGoods;
import com.example.oder_putout.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface OrderDao extends JpaRepository<OrderGoods,Integer> {
    @Query(value = "select * from order_goods WHERE order_id=?1 ",nativeQuery = true)
    public List<OrderGoods> findOrderGoodsByOrderId(int orderId);
    @Query(value = "select order_goods.id,goods.name,goods.unit,order_goods.number,order_goods.box_number,order_goods.price, order_goods.total_price from order_goods left join goods on order_goods.goods_id = goods.id WHERE order_goods.order_id=?1",nativeQuery = true)
    public List<Map<String,Object>> findOrderList(int orderId);
    @Query(value = "SELECT sum(Round(order_goods.number*goods.price,2)) as total  FROM order_goods LEFT JOIN goods on order_goods.goods_id=goods.id WHERE order_goods.order_id=?1",nativeQuery = true)
    public float findOrderPrice(int orderId);
    @Modifying
    @Transactional
    @Query(value = "UPDATE order_info set total_price=?1 WHERE id=?2",nativeQuery = true)
    public int updateOrderPrice(float total,int id);
    @Query(value = "select * from order_info WHERE id=?1 ",nativeQuery = true)
    public Map<String,Object> findOrderById(int orderId);
    @Query(value = "select max(id) from order_info",nativeQuery = true)
    public int findMaxId();
    @Modifying
    @Transactional
    @Query(value = "delete from order_goods where id=?1",nativeQuery = true)
    public int deleteOrderGoods(int id);
    @Modifying
    @Transactional
    @Query(value = "delete from order_goods where order_id=?1",nativeQuery = true)
    public int deleteTheOrderGoods(int orderId);
}

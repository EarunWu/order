package com.example.oder_putout.respository;

import com.example.oder_putout.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface OrderInfoDao extends JpaRepository<OrderInfo,Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO order_info (customer) VALUES (?1) ",nativeQuery = true)
    public int insertOrder(String customer);
    @Query(value = "select * from order_info ORDER BY created_at desc limit 10",nativeQuery = true)
    public List<OrderInfo> findOrderInfo();
    @Query(value = "select order_info.id,order_info.customer,order_info.total_price as totalPrice,order_info.created_at as createdAt from order_info left JOIN customer on order_info.customer=customer.name WHERE customer.easy_write like %?1% or customer.name like %?1% ORDER BY order_info.created_at desc limit ?2,10",nativeQuery = true)
    public List<Map<String,Object>> searchEasyWrite(String easyWrite,int toPage);
    @Query(value = "SELECT IFNULL(SUM(ROUND(total_price,2)),0) FROM order_goods WHERE order_id=?1",nativeQuery = true)
    public float orderPrice(int orderId);
    @Modifying
    @Transactional
    @Query(value = "update order_info set total_price=?1 where id=?2",nativeQuery = true)
    public int updateOrderPrice(float price,int id);
    @Query(value = "select * from order_info where id=?1",nativeQuery = true)
    public OrderInfo findCustomerById(int orderId);
    @Modifying
    @Transactional
    @Query(value = "delete from order_info where id=?1",nativeQuery = true)
    public int deleteOrderById(int orderId);
    @Query(value = "select count(*) from order_info left JOIN customer on order_info.customer=customer.name where customer.easy_write like %?1% or customer.name like %?1% ORDER BY order_info.created_at desc",nativeQuery = true)
    public int getSearchOrderNum(String easyWrite);

}

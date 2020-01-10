package com.example.oder_putout.respository;

import com.example.oder_putout.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer,Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO customer(name,address,tel,easy_write) VALUES (?1,?2,?3,?4)",nativeQuery = true)
    public int addCustomer(String name,String address,int tel,String easyWrite);
    @Query(value = "select * from customer where easy_write like %?1% or name like %?1%",nativeQuery = true)
    public List<Customer> findCustomerByEW(String easyWrite);
    @Query(value = "select * from customer limit 10",nativeQuery = true)
    public List<Customer> findCustomer();

}

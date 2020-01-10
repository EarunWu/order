package com.example.oder_putout.respository;

import com.example.oder_putout.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminDao extends JpaRepository<Admin,Integer> {
    @Query(value = "select * from admin where id=?1 AND password=?2",nativeQuery = true)
    public Admin findIdAndPassword(int id,String password);

}

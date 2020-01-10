package com.example.oder_putout.controller;

import com.example.oder_putout.entity.Goods;
import com.example.oder_putout.respository.GoodsDao;
import com.example.oder_putout.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;
    @Autowired
    private GoodsDao goodsDao;

    @RequestMapping("/goods_add")
    public String test(Model model){
        return "goods_add";

    }
    @RequestMapping("/goods_update")
    public String goodsUpdate(Model model,int gId,int orderId){
        Goods goods=goodsDao.findgoodsById(gId);
        model.addAttribute("goods",goods);
        model.addAttribute("orderId",orderId);
        return "goods_update";

    }

    @RequestMapping("/index")
    public String toIndex(Model model){
        return "index";

    }
    @RequestMapping("/tologin")
    public String tologin(int id,String password){
        if(adminService.login(id,password)==1){
            return "redirect:index";
        }
        else
            return "login";
    }
    @RequestMapping("/login")
    public String login(){
            return "login";
    }
    @RequestMapping("/qdAPI")
    public String qdAPI(){
        return "qdAPI";
    }

}

package com.example.oder_putout.controller;

import com.example.oder_putout.entity.Goods;
import com.example.oder_putout.entity.OrderInfo;
import com.example.oder_putout.respository.GoodsDao;
import com.example.oder_putout.respository.OrderDao;
import com.example.oder_putout.respository.OrderInfoDao;
import com.example.oder_putout.service.impl.GoodsServiceImpl;
import com.example.oder_putout.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class GoodsController {
    @Autowired
    private GoodsServiceImpl goodsService;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private OrderInfoDao orderInfoDao;

    @RequestMapping("/goods_list")
    public String test(Model model){
        List<Goods> goodsList=goodsService.getGoodsList();
        model.addAttribute("goodsList",goodsList);
        return "goods_list";

    }
    @RequestMapping("/searchGoodsList")
    public String searchGoodsList(Model model,String easy_write){
        List<Goods> goodsList =goodsDao.findGoodsByEW(easy_write);
        model.addAttribute("goodsList",goodsList);
        return "goods_list";

    }
    @RequestMapping("/updateGoodsinfoPage")
    public String updatepage(Model model,int goodsId){
        Goods goods=goodsDao.findgoodsById(goodsId);
        model.addAttribute("goods",goods);
        return "reviseGoodsInfo";

    }
    @RequestMapping("/updateGoodsInfo")
    public String updateGoodsInfo(String name, float price,int stock,String unit,float box_size,String easy_write,int goodsId){
        goodsDao.updateGoodsInfo(name, price, stock, unit, box_size, easy_write, goodsId);
        return "updateGoodsSucceed";

    }
    @RequestMapping("/deleteGoods")
    public String deleteGoods(Model model,int goodsId){
        goodsDao.deleteGoods(goodsId);
        List<Goods> goodsList=goodsService.getGoodsList();
        model.addAttribute("goodsList",goodsList);
        return "goods_list";

    }
    @RequestMapping("/addgoods")
    public String addgoods(String name,float price,String unit,float box_size,String easy_write){
        int stock=1;
        int categories=1;
        System.out.println(goodsDao.addGoods(name,price,unit,stock,categories,box_size,easy_write));
        System.out.println("添加成功");
        return "addGoodsSucceed";

    }
    @RequestMapping("/searchGoods")
    public String searchGood(Model model,String easy_write,int orderId){
        List<Goods> searchList =goodsDao.findGoodsByEW(easy_write);
        List<Map<String,Object>> orderList=orderService.findAOrderList(orderId);
        OrderInfo orderInfo=orderInfoDao.findCustomerById(orderId);
        model.addAttribute("searchList",searchList);
        model.addAttribute("orderList",orderList);
        model.addAttribute("orderId",orderId);
        model.addAttribute("orderInfo",orderInfo);
        return "addOrder";

    }
    @RequestMapping(value="/addOrderGoods")
    @ResponseBody
    public int addOrderGoods(int goodsId,float number,int orderId,int boxNumber,float price,float totalPrice){
        return goodsDao.addOrderGoods(goodsId, number, orderId, boxNumber, price, totalPrice);
    }
    @RequestMapping("/reLoad")
    public String reLoad(Model model,int orderId){
        List<Goods> searchList=goodsService.getGoodsList();
        List<Map<String,Object>> orderList=orderService.findAOrderList(orderId);
        OrderInfo orderInfo=orderInfoDao.findCustomerById(orderId);
        model.addAttribute("searchList",searchList);
        model.addAttribute("orderList",orderList);
        model.addAttribute("orderId",orderId);
        model.addAttribute("orderInfo",orderInfo);
        return "addOrder";
    }
    @RequestMapping(value="/savePrice")
    @ResponseBody
    public int savePrice(int goodsId,float price){
        System.out.println(goodsId);
        System.out.println(price);
        return goodsDao.savePrice(price, goodsId);
    }
}

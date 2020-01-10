package com.example.oder_putout.controller;

import com.example.oder_putout.entity.Goods;
import com.example.oder_putout.entity.OrderInfo;
import com.example.oder_putout.respository.OrderDao;
import com.example.oder_putout.respository.OrderInfoDao;
import com.example.oder_putout.service.impl.GoodsServiceImpl;
import com.example.oder_putout.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private GoodsServiceImpl goodsService;
    @Autowired
    private OrderInfoDao orderInfoDao;
    @Autowired
    private OrderDao orderDao;
    @RequestMapping("/outPrintData")
    public String getAOrderList(Model model,int orderId){
        OrderInfo orderInfo=orderInfoDao.findCustomerById(orderId);
        List<Map<String,Object>> orderList=orderService.findAOrderList(orderId);
        model.addAttribute("orderList",orderList);
        model.addAttribute("orderInfo",orderInfo);
        return "outPrintData";
    }
    @RequestMapping("/addOrder")
    public String addOrder(Model model,String customer){
        List<Goods> searchList=goodsService.getGoodsList();
        int orderId=orderService.addOrder(customer);
        OrderInfo orderInfo=orderInfoDao.findCustomerById(orderId);
        List<Map<String,Object>> orderList=orderService.findAOrderList(orderId);
        model.addAttribute("searchList",searchList);
        model.addAttribute("orderList",orderList);
        model.addAttribute("orderId",orderId);
        model.addAttribute("orderInfo",orderInfo);
        return "addOrder";
    }
    @RequestMapping("/orderList")
    public String orderList(Model model){
        model.addAttribute("orderList",orderInfoDao.findOrderInfo());
        return "oneOrderList";
    }
    @RequestMapping("/deleteOrderGoods")
    public String deleteOrderGoods(int orderGoodsId,int orderId){
        orderDao.deleteOrderGoods(orderGoodsId);
        return "redirect:reLoad?orderId="+orderId;
    }
    @RequestMapping("/searchOrderList")
    public String searchOrderList(Model model,String easyWrite,int toPage){
        if(toPage<0){
            toPage=0;
        }
        int page=orderInfoDao.getSearchOrderNum(easyWrite)/10+1;
        if (toPage>=page){
            toPage=page-1;
        }
        int toPageNum=10*toPage;
        model.addAttribute("orderList",orderInfoDao.searchEasyWrite(easyWrite,toPageNum));
        model.addAttribute("page",page);
        model.addAttribute("easyWrite",easyWrite);
        model.addAttribute("toPage",toPage);
        return "orderList";
    }
    @RequestMapping("/deleteOrder")
    public String deleteOrder(Model model,int orderId){
        orderInfoDao.deleteOrderById(orderId);
        orderDao.deleteTheOrderGoods(orderId);
        model.addAttribute("orderList",orderInfoDao.findOrderInfo());
        return "oneOrderList";
    }

}

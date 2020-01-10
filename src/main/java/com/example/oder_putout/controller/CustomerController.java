package com.example.oder_putout.controller;

import com.example.oder_putout.respository.CustomerDao;
import com.example.oder_putout.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    CustomerDao customerDao;

    @RequestMapping("/addCustomer")
    public String addCustomer(String name,String address,int tel,String easyWrite){
        customerService.addCustomer(name, address, tel, easyWrite);
        return "addCustomerSucceed";
    }
    @RequestMapping("/creatCustomer")
    public String creatCustomer(){
        return "creatCustomer";
    }
    @RequestMapping("/creatOrder")
    public String creatOrder(Model model){
        model.addAttribute("customerList",customerDao.findCustomer());
        return "creatOrder";
    }
    @RequestMapping("/searchCustomer")
    public String serchCustomer(Model model,String easyWrite){
        model.addAttribute("customerList",customerDao.findCustomerByEW(easyWrite));
        return "creatOrder";
    }

}

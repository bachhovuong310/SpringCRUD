package com.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.helloworld.order.db.OrderRepository;

@Controller
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderRepository repository;
	
	@RequestMapping("")
	public String getOrderList(ModelMap model){
		model.addAttribute("orderList", repository.findAll());
		return "order";
	}
}

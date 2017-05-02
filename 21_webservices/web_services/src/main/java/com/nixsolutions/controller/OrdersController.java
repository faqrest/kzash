package com.nixsolutions.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nixsolutions.entity.Orders;
import com.nixsolutions.service.ServiceApi.BookService;
import com.nixsolutions.service.ServiceApi.OrdersService;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	
	private BookService bookService;
	private OrdersService orderService;
	
	@Autowired
	public OrdersController(BookService bookService, OrdersService orderService) {
		this.bookService = bookService;
		this.orderService = orderService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String printAllBooks(Model model) {
		List<Orders> orders = orderService.getAll();
		model.addAttribute("orders", orders);
		return "orders/orders";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String printBookInfo(Model model, @PathVariable int id) throws SQLException {
		Orders order = orderService.getById(id);
		model.addAttribute("order", order);
		return "orders/infoOrder";
	}
}

package karl.pizza.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import karl.pizza.model.*;

@Controller
public class OrderController {
	
	@RequestMapping(value = {"/", "/home", "/index"}, method = RequestMethod.GET) 
	public String getOrderView(Model model){
		model.addAttribute("menu", Reader.readXML());
		return "index";
	}
	
	@RequestMapping(value = "/make_order", method = RequestMethod.POST)
	public @ResponseBody String makeOrder(@RequestBody Cart cart) {
		StringBuilder res = new StringBuilder("Hello ");
		res.append(cart.getCustomer());
		res.append("\nYour order is :\n");
		for(Order i : cart.getOrders()) {
			res.append(i.getNumber());
			res.append("*");
			res.append(i.getItem().getName());
			res.append("\n");
		}
		res.append("total price is : ");
		res.append(cart.getTotal_price());
		return res.toString();
	}
}

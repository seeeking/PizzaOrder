package karl.pizza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import karl.pizza.model.*;

@Controller
public class OrderController {
	
	@Autowired
	private Menu myMenu;
	
	@RequestMapping(value = {"/", "/home", "/index"}, method = RequestMethod.GET) 
	public String getOrderView(Model model){
		model.addAttribute("menu", myMenu);
		return "home";
	}
	
	@RequestMapping(value = "/make_order", method = RequestMethod.POST)
	public @ResponseBody String makeOrder(@RequestBody Cart cart) {
		if(cart != null) {
			StringBuilder res = new StringBuilder("Hello ");
			res.append(cart.getCustomer());
			res.append("\nYour order is :\n");
			for(Order i : cart.getOrders()) {
				res.append(i.getNumber());
				res.append("*");
				res.append(i.getItemId());
				res.append("\n");
			}
			res.append("total price is : ");
			res.append(cart.getTotalPrice());
			res.append('\n');
			//res.append(cart.getDate());
			return res.toString();
		}
		else {
			return "error";
		}
	}
}

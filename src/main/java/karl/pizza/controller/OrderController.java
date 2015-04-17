package karl.pizza.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value = "make_order", method = RequestMethod.POST)
	public String makeOrder() {
		return "order_success";
	}
}

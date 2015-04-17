package karl.pizza.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item {
	public enum Size {
		large, small, empty
	}
	
	private String name;
	private Size size;
	private double price;
	
	public void setName(String n) {
		name = n;
	}
	
	public void setSize(Size size) {
		this.size = size;
	}
	
	public void setPrice(double p) {
		price = p;
	}
	
	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	@XmlElement(name = "size")
	public Size getSize() {
		return size;
	}

	@XmlElement(name = "price")
	public double getPrice() {
		return price;
	}
}

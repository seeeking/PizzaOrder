package karl.pizza.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item {
	
	private String name;
	private String catagory;
	private String size;
	private double price;
	private long id;
	
	public void setId(long i) {
		id = i;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setCatagory(String n) {
		catagory = n;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public void setPrice(double p) {
		price = p;
	}
	
	@XmlElement(name = "name")
	public String getName() {
		return name;
	}
	
	@XmlElement(name = "catagory")
	public String getCatagory() {
		return catagory;
	}

	@XmlElement(name = "size")
	public String getSize() {
		return size;
	}

	@XmlElement(name = "price")
	public double getPrice() {
		return price;
	}
	
	@XmlElement(name = "id")
	public long getId() {
		return id;
	}
}

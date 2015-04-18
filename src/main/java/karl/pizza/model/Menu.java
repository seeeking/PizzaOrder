package karl.pizza.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement
public class Menu {
	private String owner;
	private List<Item> item;
	
	@XmlAttribute
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String s) {
		owner = s;
	}
	
	@XmlElement
	public List<Item> getItem() {
		return item;
	}
	
	public void setItem(List<Item> item) {
		this.item = item;
	}
}

package karl.pizza.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement
public class Catagory {
	
	private String name;
	private List<Item> item;

	@XmlElement
	public List<Item> getItem() {
		return item;
	}

	@XmlAttribute
	public String getName() {
		return name;
	}
	
	public void setItem(List<Item> i) {
		item = i;
	}

	public void setName(String n) {
		name = n;
	}
}

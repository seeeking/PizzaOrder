package karl.pizza.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Menu {
	
	private List<Catagory> catagory;
	
	@XmlElement
	public List<Catagory> getCatagory() {
		return catagory;
	}
	
	public void setCatagory(List<Catagory> cata) {
		catagory = cata;
	}
}

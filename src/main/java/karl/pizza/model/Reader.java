package karl.pizza.model;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Reader {
	public static Menu readXML() {
		String path = "src/main/resources/menu.xml";
		File f = new File(path);
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Menu.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Menu m = (Menu) jaxbUnmarshaller.unmarshal(f);
			return m;
		}
		catch(JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
}

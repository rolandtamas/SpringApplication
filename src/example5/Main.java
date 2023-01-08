package example5;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

@SuppressWarnings("deprecation")
public class Main {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("D:\\Facultate\\An2\\JT\\proiect\\SpringApplication\\src\\example5\\Beans.xml"));
		Rectangle rectangle = (Rectangle)factory.getBean("rectangle");
		rectangle.area();
	}

}

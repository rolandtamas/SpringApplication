package exercise2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("deprecation")

public class Main {
	
	private static final String XML_PATH = "D:\\Facultate\\An2\\JT\\proiect\\SpringApplication\\src\\exercise2\\Beans.xml";

	public static void main(String[] args) 
	{
		BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource(XML_PATH));
		
		// Object 1:
		Vehicle auto = (Vehicle)beanFactory.getBean("autovehicle");
		System.out.println(auto);
		System.out.println();
		
		// Object 2:
		Vehicle moto = (Vehicle)beanFactory.getBean("motorcycle");
		System.out.println(moto);
		System.out.println();
		
		// Object 3:
		ApplicationContext context=new ClassPathXmlApplicationContext(XML_PATH);
		Vehicle truck = (Vehicle)context.getBean("truck");
		System.out.println(truck);
		System.out.println();
	}

}

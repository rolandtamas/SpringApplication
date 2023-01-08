package exercise3;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class Main {

	private static final String XML_PATH = "D:\\Facultate\\An2\\JT\\proiect\\SpringApplication\\src\\exercise3\\Beans.xml";
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) 
	{
		boolean exit = false;
		BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource(XML_PATH)); 
		CarController controller = (CarController)beanFactory.getBean("carcontroller");

//		ApplicationContext context =new ClassPathXmlApplicationContext("Beans.xml");
//		CarController controller = (CarController)context.getBean("carcontroller");	
		
		System.out.println("CRUD API With Spring Framework");
		while(!exit)
		{			
			System.out.println("Select one of the options below:");
			System.out.println("1 - List all entries in the database");
			System.out.println("2 - List one entry from the database");
			System.out.println("3 - Create a database entry");
			System.out.println("4 - Update a database entry");
			System.out.println("5 - Delete a database entry");
			System.out.println("6 - Delete all database entries");
			System.out.println("7 - List all cars newer than 5 years");
			System.out.println("8 - List all cars with mileage under 100000 km");
			System.out.println("x - Exit");
			
			var scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			
			switch(input.toString().toLowerCase())
			{
				case "1":
				{
					List<Car> cars = controller.getCars();
					for (Car car : cars)
					{
						System.out.println(car);
					}
					break;
				}
				case "2":
				{
					System.out.println("Enter brand name: ");
					input = scanner.nextLine();
					Car car = controller.getCar(input);
					if (car == null)
					{
						System.out.println("Entry not found!");
					}
					else
					{
						System.out.println(car);
					}					
					break;
				}
				case "3":
				{
					System.out.println("Enter brand name:");
					String brand = scanner.nextLine();
					System.out.println("Enter manufacturing year:");
					int manufacturingYear = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter colour: ");
					String colour = scanner.nextLine();
					System.out.println("Enter mileage");
					int mileage = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter registration number: ");
					String registrationNumber = scanner.nextLine();
					
					if ( brand.isBlank() && colour.isBlank() && registrationNumber.isBlank() && manufacturingYear < 0 && mileage < 0) 
					{
						System.out.println("Some data is missing, please try again!");						
					}
					else
					{
						controller.create(brand, registrationNumber, colour, manufacturingYear, mileage);
					}
					break;
				}
				case "4":
				{
					List<Car> cars = controller.getCars();
					for (Car car : cars)
					{
						System.out.println(car);
					}
					System.out.println();
					System.out.println("Please enter the ID of the car that you want to modify:");
					int id = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Please specify the data you want to modify (brand, mileage, (manufacturing) year, colour, (registration) number):");
					String field = scanner.nextLine();
					switch(field.toLowerCase())
					{
						case "brand":
						{
							System.out.println("Enter new brand name: ");
							String brand = scanner.nextLine();
							controller.updateBrand(id, brand);
							break;
						}
						case "mileage":
						{
							System.out.println("Enter new brand name: ");
							int mileage = scanner.nextInt();
							scanner.nextLine();
							controller.updateMileage(id, mileage);
							break;
						}
						case "colour":
						{
							System.out.println("Enter new brand name: ");
							String colour = scanner.nextLine();
							controller.updateColour(id, colour);
							break;
						}
						case "year":
						{
							System.out.println("Enter new brand name: ");
							int year = scanner.nextInt();
							scanner.nextLine();
							controller.updateManufacturingYear(id, year);
							break;
						}
						case "number":
						{
							System.out.println("Enter new brand name: ");
							String registrationNumber = scanner.nextLine();
							controller.updateRegistrationNumber(id, registrationNumber);
							break;
						}
						
						default:
						{
							System.err.println("Invalid data specified!");
							break;
						}
						
					}
					break;
				}
				case "5":
				{
					List<Car> cars = controller.getCars();
					for (Car car : cars)
					{
						System.out.println(car);
					}
					
					System.out.println();
					System.out.println("Please enter the ID of the car that you want to DELETE:");
					int id = scanner.nextInt();
					scanner.nextLine();
					controller.delete(id);
					break;
				}
				case "6":
				{
					System.out.println("This process is irreversible. Are you sure? (y/n)");
					var res = scanner.nextLine();
					if(res.equals("y"))
					{
						controller.deleteAll();
					}
					break;
				}
				
				case "7":
				{
					List<Car> cars = controller.getCars().stream()
							.filter(car -> car.getManufacturingYear() > 2017)
							.toList();
					for(Car car : cars)
					{
						System.out.println(car);
					}
					break;
				}
				
				case "8":
				{
					List<Car> cars = controller.getCars().stream()
							.filter(car -> car.getMileage() < 100000)
							.toList();
					for(Car car : cars)
					{
						System.out.println(car);
					}
					break;
				}
				
				case "x":
				{
					exit = true;
					scanner.close();
					break;
				}			
			}
		}
		
		return;
	}

}

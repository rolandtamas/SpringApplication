package exercise2;

public class Motorcycle extends Vehicle {
	private String type;
	
	public Motorcycle() 
	{
		super();
	}
	
	public Motorcycle(double price, int maxSpeed, String type)
	{
		super(price, maxSpeed);
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nType " + type+"\n";		
	}
	
}

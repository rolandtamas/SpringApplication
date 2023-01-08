package exercise2;

public abstract class Vehicle {
	private double price;
	private int maxSpeed;
	
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString()
	{
		return "Price " + price +"\n" +"Max Speed " + maxSpeed +"\n";		
	}
	
	public Vehicle() {
	}
	
	public Vehicle(double price, int maxSpeed)
	{
		this.maxSpeed = maxSpeed;
		this.price = price;
	}
}

package exercise2;

import org.springframework.beans.factory.annotation.Autowired;

public class Truck extends Vehicle {
	private double load;
	
	public Truck() {
		super();
	}
	
	public Truck(double price, int maxSpeed, double load)
	{
		super(price, maxSpeed);
		this.load = load;
	}
	
	@Autowired
	public void setLoad(double load) {
		this.load = load;
	}
	
	public double getLoad() {
		return load;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nLoad " + load +"\n";
	}
}

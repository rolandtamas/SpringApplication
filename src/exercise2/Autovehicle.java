package exercise2;

public class Autovehicle extends Vehicle {
	private String brand;
	private int yearOfFabrication;
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public int getYearOfFabrication() {
		return yearOfFabrication;
	}
	
	public void setYearOfFabrication(int yearOfFabrication) {
		this.yearOfFabrication = yearOfFabrication;
	}
	
	public Autovehicle() { super(); }
	
	public Autovehicle(double price, int maxSpeed, String brand, int yearOfFabrication) {
		super(price, maxSpeed);
		this.brand = brand;
		this.yearOfFabrication = yearOfFabrication;
	}
	
	@Override
	public String toString() 
	{
		return super.toString() + " Brand " + brand + " Year of fabrication " + yearOfFabrication;
	}
	
}

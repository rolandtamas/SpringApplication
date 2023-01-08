package exercise3;

public class Car 
{
	private int ID;
	private int ManufacturingYear;
	private int Mileage;
	private String Brand;
	private String Colour;
	private String RegistrationNumber;
	
	public Car() {}
	
	public Car(int ID, int ManufacturingYear, int Mileage, String Brand, String Colour, String RegistrationNumber)
	{
		this.ID = ID;
		this.ManufacturingYear = ManufacturingYear;
		this.Mileage = Mileage;
		this.Brand = Brand;
		this.Colour = Colour;
		this.RegistrationNumber = RegistrationNumber;
	}
	
	public String getBrand() {
		return Brand;
	}
	
	public void setBrand(String brand) {
		Brand = brand;
	}
	
	public String getColour() {
		return Colour;
	}
	
	public void setColour(String colour) {
		Colour = colour;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public int getManufacturingYear() {
		return ManufacturingYear;
	}
	
	public void setManufacturingYear(int manufacturingYear) {
		ManufacturingYear = manufacturingYear;
	}
	
	public int getMileage() {
		return Mileage;
	}
	
	public void setMileage(int mileage) {
		Mileage = mileage;
	}
	
	public String getRegistrationNumber() {
		return RegistrationNumber;
	}
	
	public void setRegistrationNumber(String registrationNumber) {
		RegistrationNumber = registrationNumber;
	}
	
	@Override
	public String toString() {
		return "ID: " + ID + "\n"
				+"Brand: " + Brand + "\n"
				+"ManufacturingYear: " + ManufacturingYear + "\n"
				+"Colour: " + Colour + "\n"
				+"Mileage: " + Mileage + "\n"
				+"RegistrationNumber: " + RegistrationNumber + "\n";		
	}
}

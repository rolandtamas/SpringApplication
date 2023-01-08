package example3;

public class Main {

	public static void main(String[] args) {
		calculateArea(new Circle());
		calculateArea(new Rectangle());
	}

	private static void calculateArea(Figure figure) {
		figure.area();
		
	}

}

package example5;

public class Rectangle {
	private int length, width;
	
	public void area() {
		System.out.println("Rectangle area "+(length*width));
	}
	
	public int getLength() {
		return length;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
}

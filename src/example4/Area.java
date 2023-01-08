package example4;

public class Area {
	private Figure figure;
	public void setFigure(Figure figure) {
		this.figure = figure;
	}
	
	public void calculateArea() {
		this.figure.area();
	}
	
}

package JGrafas;

import pt.iscte.guitoo.*;

public class Bola implements EllipseFigure{

	private static final int HEIGHT = 10;
	private static final int WIDTH = 10;
	private Point location;
	private Color color;
	
	public Bola(int x, int y){
		location = new Point(x, y);
		color = StandardColor.WHITE;
	}
	
	@Override
	public Location getLocation(){
		return location;
	}

	@Override
	public int getHeight(){
		return HEIGHT;
	}

	@Override
	public int getWidth(){
		return WIDTH;
	}
	
	public void setLocation(int x, int y){
		this.location = new Point(x, y);
	}
	
	public Color getFillColor(){
		return color;
	}
	
	public void setColor(Color color){
		this.color = color;
	}

}

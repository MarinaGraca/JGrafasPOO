package JGrafas;

import java.util.*;
import pt.iscte.guitoo.*;

public class Barra implements PolylineFigure{
	
	private static final int offset = 300;
	private static final int WIDTH = 35;
	
	private List<Point> points;
	private Point location;
	private int altura;
	private Color color;
	
	public Barra(int WIDTH, int altura){
		location = new Point(WIDTH, offset);
		points = new ArrayList<>(4);
		points.add(new Point(0, -altura-40));
		points.add(new Point(WIDTH, -altura-40));
		points.add(new Point(WIDTH, -WIDTH));
		points.add(new Point(0, -WIDTH));
		color = StandardColor.WHITE;
	}
	
	@Override
	public Location getLocation(){
		return location;
	}
	
	public int getAltura(){
		return altura;
	}

	@Override
	public List<Point> getPoints(){
		return points;
	}

	public void move(int x, int y){
		location = location.sum(x, y);
	}
	
	@Override
	public Color getFillColor(){
		return color;
	}
	
	public void setColor(Color color){
		this.color = color;
	}

}

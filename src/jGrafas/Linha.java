package JGrafas;

import java.util.*;
import pt.iscte.guitoo.*;

public class Linha implements PolylineFigure{
	
	private List<Point> points;
	private Point location;
	
	public Linha(Point p1, Point p2){
		location = Point.ORIGIN;
		points = new ArrayList<>(2);
		points.add(p1);
		points.add(p2);
	}
	
	@Override
	public Location getLocation(){
		return location;
	}
	
	@Override
	public List<Point> getPoints(){
		return points;
	}

}

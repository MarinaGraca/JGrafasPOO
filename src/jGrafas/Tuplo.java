package JGrafas;

import java.util.*;

public class Tuplo{
	
	private String xx;
	private List<Integer> yy;
	
	public Tuplo(String xx, List<Integer> yy){
		this.xx = xx;
		this.yy = yy;
	}
	
	public String getTuplosX(){
		return xx;
	}
	
	public List<Integer> getTuplosY(){
		return yy;
	}
	
	public int getMax(){
		return Collections.max(yy);
	}

	@Override
	public String toString() {
		return "Tuplo [xx=" + xx + ", yy=" + yy + "]";
	}
	
	
	
}

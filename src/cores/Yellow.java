package cores;

import JGrafas.Tuplo;
import pt.iscte.guitoo.StandardColor;

public class Yellow implements EsquemaCores{

	@Override
	public StandardColor getFillColor(Tuplo t) {
		if(t.getTuplosY().get(0) < 50 && t.getTuplosY().get(1) >= 50)
			return StandardColor.YELLOW;
		return StandardColor.WHITE;
	}
	
	@Override
	public String toString(){
		return "yellow";
	}

}

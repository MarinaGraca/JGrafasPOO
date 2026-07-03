package cores;

import JGrafas.Tuplo;
import pt.iscte.guitoo.StandardColor;

public class RG implements EsquemaCores{

	@Override
	public String toString(){
		return "red&green";
	}

	@Override
	public StandardColor getFillColor(Tuplo t){
		if(t.getTuplosY().get(0) < 50)
			return StandardColor.RED;
		return StandardColor.GREEN;
		
	}

}

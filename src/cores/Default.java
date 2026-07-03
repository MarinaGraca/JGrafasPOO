package cores;

import JGrafas.Tuplo;
import pt.iscte.guitoo.StandardColor;

public class Default implements EsquemaCores{

	@Override
	public String toString(){
		return "default";
	}

	@Override
	public StandardColor getFillColor(Tuplo t){
		return StandardColor.WHITE;
	}

}

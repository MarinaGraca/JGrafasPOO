package filtros;

import JGrafas.Tuplo;

public class Negativas implements FiltroDados{

	@Override
	public boolean isValid(Tuplo t){
		String x = t.getTuplosX();
		
		if(x.length() == 2 && !x.equals("NA") && !x.equals("RE"))
			return true;
		return false;
	}
	
	@Override
	public String getNome(){
		return "negativasPOO";
	}
	
	

}

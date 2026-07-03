package filtros;

import JGrafas.Tuplo;

public class Assid implements FiltroDados{

	@Override
	public boolean isValid(Tuplo t){
		int x = t.getTuplosY().get(0);
		
		if(x >= 20) return true;
		return false;
	}

	@Override
	public String getNome(){
		return "assiduidadePCD";
	}

}

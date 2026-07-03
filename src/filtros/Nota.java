package filtros;

import JGrafas.Tuplo;

public class Nota implements FiltroDados{
	
	@Override
	public boolean isValid(Tuplo t){
		int y = t.getTuplosY().get(1);
		
		if(y >= 50) return true;
		return false;
	}
	
	@Override
	public String getNome(){
		return "notaFinalPCD";
	}

}

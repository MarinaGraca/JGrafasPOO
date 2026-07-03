package JGrafas;

import java.io.*;
import java.util.*;

import filtros.FiltroDados;

public class ConjuntoDados{	

	private String file;
	private List<Tuplo> tuplos;
	private List<FiltroDados> filtrosEscolhidos;

	public ConjuntoDados(String file, List<FiltroDados> filtrosEscolhidos) throws FileNotFoundException{
		this.file = file;
		this.filtrosEscolhidos = filtrosEscolhidos;
		load();
	}

	public String getFilePath(){
		return file;
	}

	public List<Tuplo> getTuplos(){
		return tuplos;
	}

	public void setTuplos(List<Tuplo> tuplos){
		this.tuplos = tuplos;
	}

	private void load() throws FileNotFoundException{
		boolean b = containsText();
		tuplos = new ArrayList<Tuplo>();
		Scanner scanner = new Scanner(new File(file));
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			Tuplo tuplo = getTuplo(line, b);
			if(isValidT(tuplo))
				tuplos.add(tuplo);
		}
		scanner.close();
	}
	
	private boolean isValidT(Tuplo tuplo){
		for(FiltroDados filtro : filtrosEscolhidos)
			if(!filtro.isValid(tuplo))
				return false;
		return true;
	}

	private boolean containsText() throws FileNotFoundException{
		Scanner scanner = new Scanner(new File(file));
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			String[] s = line.split(",");
			String xx = s[0].trim();
			try{
				Integer i = Integer.parseInt(xx);
			} catch(NumberFormatException e){
				scanner.close();
				return true;
			}
		}
		scanner.close();
		return false;
	}

	private Tuplo getTuplo(String line, boolean b){
		String[] s = line.split(",");
		List<Integer> yy = new ArrayList<Integer>();
		String x = null;
		if(b){
			x = s[0].trim();
			int y = Integer.parseInt(s[1].trim());
			yy.add(y);
		} else{
			int y1 = Integer.parseInt(s[0].trim());
			yy.add(y1);
			int y2 = Integer.parseInt(s[1].trim());
			yy.add(y2);
		}
		return new Tuplo(x, yy);
	}

}

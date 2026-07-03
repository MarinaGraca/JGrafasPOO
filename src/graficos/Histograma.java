package graficos;

import java.util.List;

import JGrafas.Barra;
import JGrafas.Tuplo;
import cores.EsquemaCores;
import pt.iscte.guitoo.*;

public class Histograma extends Grafico{
	
	public Histograma(){
		super();
		tipo = "histograma";
	}
	
	@Override
	public void addBarras(){
		List<Figure> children = getChildFigures();
		List<Tuplo> tuplos = dados.getTuplos();
		
		EsquemaCores esquema = super.getEsquema();
		
		int scale = super.getEscala();
		int n = 0;
		for(Tuplo t : tuplos){
			String x = t.getTuplosX();
			int y = t.getTuplosY().get(0);
			
			StandardColor color = esquema.getFillColor(t);
			
			Barra barra = new Barra(35 * scale, y * scale + 50 * (scale - 1));
			barra.setColor(color);
			barra.move(n * 35  * scale, 0 + 45 * (scale - 1));
			children.add(barra);
			
			// eixo x
			children.add(new StaticText(x, (53 + n * 35 )* scale , 280 + 20 * (scale - 1)));
			
			n++;
		}
		
		// eixo y
		Barra linha = new Barra(0, scale * 82 + 45*(scale - 1));
		linha.move(25, -45 + 10  * scale);
		children.add(linha);
		for(int y = 120; y >= 0; y-=20)
			children.add(new StaticText(y, 10, 270-y * scale));
		
	}
	
}

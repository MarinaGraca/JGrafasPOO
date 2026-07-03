package graficos;

import java.util.List;

import JGrafas.Barra;
import JGrafas.Bola;
import JGrafas.Linha;
import JGrafas.Tuplo;
import cores.EsquemaCores;
import pt.iscte.guitoo.*;

public class Linhas extends Grafico{
	
	public Linhas(){
		tipo = "linhas";
	}
	
	@Override
	public void addBarras() {
		List<Figure> children = getChildFigures();
		List<Tuplo> tuplos = dados.getTuplos();
		
		int scale = super.getEscala();
		
		EsquemaCores esquema = super.getEsquema();
		
		for (int i = 0; i < tuplos.size()-1; i++){
			Tuplo tuplo1 = tuplos.get(i);
			Tuplo tuplo2 = tuplos.get(i+1);
			
			int y1 = tuplo1.getTuplosY().get(0);
			int y2 = tuplo2.getTuplosY().get(0);
			
			int x1 = 35 + i * 50 * scale;
			int x2 = 35 + (i+1) * 50 * scale;
			
			Point p1 = new Point(x1, 210-y1*scale - 30*(scale-1));
			Point p2 = new Point(x2, 210-y2*scale - 30*(scale-1));
			
			Linha linha = new Linha(p1, p2);
			children.add(linha);
		}
		
		int n = 0;
		for(Tuplo t : tuplos){
			String x = t.getTuplosX();
			int y = t.getTuplosY().get(0);
			
			StandardColor color = esquema.getFillColor(t);
			
			Bola bola = new Bola(n*50*scale + 35, 210-y*scale - 30*(scale-1));
			bola.setColor(color);
			children.add(bola);
			
			//eixo x
			children.add(new StaticText(x, n*50 * scale + 35, 10 + 280));
			
			n++;
		}
		
		// eixo y
		Barra linhaY = new Barra(0, (117-35)*scale + 50*(scale-1));
		linhaY.move(25, -35 + 5*(scale-1));
		children.add(linhaY);
		for(int y = 60; y >= 0; y-= 20)
			children.add(new StaticText(y, 10, -y*2*scale + 260));
	}

}

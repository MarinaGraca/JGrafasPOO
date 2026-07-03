package graficos;

import java.util.List;

import JGrafas.Barra;
import JGrafas.Bola;
import JGrafas.Linha;
import JGrafas.Tuplo;
import cores.EsquemaCores;
import pt.iscte.guitoo.*;

public class Dispersao extends Grafico{

	public Dispersao(){
		tipo = "dispersao";
	}

	@Override
	public void addBarras(){
		List<Figure> children = getChildFigures();
		List<Tuplo> tuplos = dados.getTuplos();

		EsquemaCores esquema = super.getEsquema();
		int scale = super.getEscala();

		for (Tuplo t : tuplos){
			int x = t.getTuplosY().get(0);
			int y = t.getTuplosY().get(1);
			
			StandardColor color = esquema.getFillColor(t);

			Bola bola = new Bola(x*5*scale + 25, 300 - y*3*scale + 70*(scale-1));
			bola.setColor(color);
			children.add(bola);
		}


		// eixo x
		Linha linhaX = new Linha(new Point(25 , 295 + 70*(scale-1)), new Point(430 + 400*(scale-1), 295 + 70*(scale-1)));
		children.add(linhaX);
		for(int x = 0; x <= 80; x+=8)
			children.add(new StaticText(x, x*5 + 25 + x*5*(scale-1), 320 + 70*(scale-1)));

		// eixo y
		Barra linhaY = new Barra(0, 250 + 100*(scale-1));
		linhaY.move(25, -5 + 70*(scale-1));
		children.add(linhaY);
		for(int y = 96; y >= 0; y-=8)
			children.add(new StaticText(y, 10, -y * 3 + 300 - y*2*(scale-1) + 50*(scale-1)));
	}

}

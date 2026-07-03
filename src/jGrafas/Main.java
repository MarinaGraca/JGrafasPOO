package JGrafas;

import java.io.FileNotFoundException;
import java.util.*;

import cores.Default;
import cores.EsquemaCores;
import cores.RG;
import cores.Yellow;
import filtros.Assid;
import filtros.FiltroDados;
import filtros.Negativas;
import filtros.Nota;
import graficos.Dispersao;
import graficos.Grafico;
import graficos.Histograma;
import graficos.Linhas;
import graficos.TipoGrafico;
import pt.iscte.guitoo.*;

public class Main{
	
	private Window app;
	private StaticText fileName;
	private StaticText scale;
	private List<Figure> children;
	private List<FiltroDados> filtros;
	private List<Flag> flags;
	private Option<EsquemaCores> esquemaOption;

	public Main(){
		
		app = new Window("JGrafas", 900, 400, true);

		fileName = new StaticText("", 100, 20);
		scale = new StaticText("", 100, 20);
		
		esquemaOption = app.addOption("esquemaCores", new Default(), new RG(), new Yellow());
		
		app.addAction("histograma", new SetSpecs(TipoGrafico.HISTOGRAMA));
		app.addAction("dispersao", new SetSpecs(TipoGrafico.DISPERSAO));
		app.addAction("linhas", new SetSpecs(TipoGrafico.LINHAS));
		
		filtros = new ArrayList<>();
		filtros.add(new Negativas());
		filtros.add(new Assid());
		filtros.add(new Nota());
		
		flags = new ArrayList<>();
		for(FiltroDados f : filtros){
			Flag flag = app.addFlag(f.getNome(), false);
			flags.add(flag);
		}
	}

	public void run(){
		app.open();
	}
	
	class SetSpecs extends Action{
		
		private Grafico graf;
		
		public SetSpecs(TipoGrafico tipoGrafico){
			if(tipoGrafico == TipoGrafico.HISTOGRAMA)
				graf = new Histograma();
			else if(tipoGrafico == TipoGrafico.DISPERSAO)
				graf = new Dispersao();
			else
				graf = new Linhas();
			
			addParameter("ficheiro", () -> fileName.getText(), (a) -> !a.isEmpty());
			addParameter("escala", () -> scale.getText(), (a) -> !a.isEmpty());
		}
		
		public void execute(String[] args){
			fileName.setText(args[0]);
			scale.setText(args[1]);
			
			
			List<FiltroDados> filtrosEscolhidos = new ArrayList<>();
			for(int i = 0; i < flags.size(); i++){
				Flag flag = flags.get(i);
				if(flag.isSelected()) {
					FiltroDados filtro = filtros.get(i);
					filtrosEscolhidos.add(filtro);
				}
			}
			
			String s = fileName.getText();
			try{
				ConjuntoDados dados = new ConjuntoDados(s, filtrosEscolhidos);
				int escala = Integer.parseInt(scale.getText());
				
				EsquemaCores esquema = esquemaOption.getSelected();
				
				graf.plot(dados, escala, esquema);
				app.clear();
				app.addFigure(graf);
			} catch(FileNotFoundException e){
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args){
		Main main = new Main();
		main.run();
	}
}

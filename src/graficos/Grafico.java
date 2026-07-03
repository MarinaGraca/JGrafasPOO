package graficos;
import java.util.*;

import JGrafas.ConjuntoDados;
import cores.Default;
import cores.EsquemaCores;
import pt.iscte.guitoo.*;

public abstract class Grafico implements CompositeFigure{

	private Point location;
	private List<Figure> children;
	protected String tipo;
	protected int scale;
	protected ConjuntoDados dados;
	protected EsquemaCores esquema;

	public Grafico(){
		location = Point.ORIGIN;
		children = new ArrayList<>();
		esquema = new Default();
	}

	public void plot(ConjuntoDados dados, int scale, EsquemaCores esquema){
		children.clear();
		setDados(dados);
		setEscala(scale);	
		setEsquema(esquema);
		addBarras();
	}

	public abstract void addBarras();

	public ConjuntoDados getDados(){
		return dados;
	}

	public void setDados(ConjuntoDados dados){
		this.dados = dados;
	}

	@Override
	public Point getLocation(){
		return location;
	}

	public int getEscala(){
		return scale;
	}

	public void setEscala(int scale){
		this.scale = scale;
	}

	@Override
	public List<Figure> getChildFigures(){
		return children;
	}

	public String getTipo(){
		return tipo;
	}

	public EsquemaCores getEsquema(){
		return esquema;
	}

	public void setEsquema(EsquemaCores esquema){
		this.esquema = esquema;
	}

}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Arbitro {
	private List<Periferico> perifericos;
	private int tipoArbitragem;
	
	public Arbitro() {
		perifericos = new ArrayList<Periferico>();
		tipoArbitragem = 0;
	}
	
	private void adicionarPeriferico() {
		Periferico periferico = new Periferico();
		periferico.setNome("USB");
		periferico.setNivelprioridade(1);
		periferico.setTempoExecucao(30);
		
		this.perifericos.add(periferico);
		
		//derivicando se está adicionando corretamente
		for (Iterator iterator = this.perifericos.iterator(); iterator.hasNext(); ) {  
			   Periferico p = (Periferico) iterator.next();  
			   System.out.println (p.getNome());  
		}
	}
	
	public void arbitrar(int tipoArbitragem) {
		this.tipoArbitragem = tipoArbitragem;
		adicionarPeriferico();
	}
}

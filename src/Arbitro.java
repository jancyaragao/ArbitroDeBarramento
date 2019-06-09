import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Arbitro {
	private List<Periferico> perifericos;
	private int tipoArbitragem;
	
	public Arbitro() {
		perifericos = new ArrayList<Periferico>();
		tipoArbitragem = 0;
	}
	// Capturar o periferico com base nas informações do usuário.
	private Periferico capturarPeriferico() {
		Scanner scanner = new Scanner(System.in);
		
		Periferico periferico = new Periferico();
		
		System.out.print("Digite o nome do periferico:");
		periferico.setNome(scanner.nextLine());

		System.out.print("Digite o nivel de prioridade:");
		periferico.setNivelprioridade(Integer.parseInt(scanner.nextLine()));

		System.out.print("Agora digite o tempo de execucao:");
		periferico.setTempoExecucao(Integer.parseInt(scanner.nextLine()));
		
		return periferico;
	}
	// cria uma lista de perifericos 
	private void adicionarPeriferico() {
		int quantidadePerifericos = 0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Digite a quantidade de perifericos que serão adcionado:");
		quantidadePerifericos = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < quantidadePerifericos; i++) {
			Periferico periferico = new Periferico();
			periferico = capturarPeriferico();
			this.perifericos.add(periferico);	
		}		
		
		//verificando se está adicionando corretamente
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

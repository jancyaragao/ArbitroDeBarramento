import java.util.ArrayList;
import java.util.Collections;
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

		System.out.print("Agora digite o tempo de execucao em segundos:");
		periferico.setTempoExecucao(Integer.parseInt(scanner.nextLine()));
		
		return periferico;
	}
	// Preenche a lista de perifericos 
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
	}
	
	private void priorizarFixamente() throws InterruptedException {
		Periferico.ordenacaoCrescente = true;
		
		Collections.sort(this.perifericos);
		
		for (Iterator iterator = this.perifericos.iterator(); iterator.hasNext(); ) {  
			   Periferico p = (Periferico) iterator.next();  
			   System.out.println ("O dispositivo "+p.getNome()+" esta ativo!");
			   Thread.sleep (p.getTempoExecucao() * 1000);
		}
	}
	
	private void priorizarRotativamente() throws InterruptedException {
		Periferico.ordenacaoCrescente = true;
		Scanner scanner = new Scanner(System.in);
		int quantidadeRodadas = 0;
		
		System.out.print("Digite a quantidade de rodadas:");
		quantidadeRodadas = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < quantidadeRodadas; i++) {
			Collections.sort(this.perifericos);
			
			for (Iterator iterator = this.perifericos.iterator(); iterator.hasNext(); ) {  
				   Periferico p = (Periferico) iterator.next();  
				   System.out.println ("O dispositivo "+p.getNome()+" esta ativo!");
				   Thread.sleep (p.getTempoExecucao() * 1000);
			}
			
			Periferico.ordenacaoCrescente = !Periferico.ordenacaoCrescente;
		}
		
		
	}
	
	public void arbitrar(int tipoArbitragem) {
		this.tipoArbitragem = tipoArbitragem;
		adicionarPeriferico();
		if (tipoArbitragem == 1) {
			try {
				priorizarFixamente();	
			}catch (Exception e) {
			
			}
		}else if(tipoArbitragem == 2) {
			try {
				priorizarRotativamente();
			}catch(Exception e){
				
			}
		}
	}
}

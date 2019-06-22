package main.java.arquitetura.controlador;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import main.java.arquitetura.modelo.Periferico;

public class Arbitro {
	private List<Periferico> perifericos;
	
	public Arbitro() {
		perifericos = new ArrayList<Periferico>();
	}
	
	// Capturar o periferico com base nas informações do usuário.
	private Periferico capturarPeriferico(int ordem) {
		Scanner scanner = new Scanner(System.in);
		
		Periferico periferico = new Periferico();
		
		System.out.print("\nDigite o nome do periférico " + ordem + ": ");
		periferico.setNome(scanner.nextLine());

		System.out.print("Digite o nível de prioridade " + ordem + ": ");
		periferico.setNivelprioridade(Integer.parseInt(scanner.nextLine()));

		System.out.print("Agora digite o tempo de execução em segundos: ");
		periferico.setTempoExecucao(Integer.parseInt(scanner.nextLine()));
		
		return periferico;
	}
	
	// Preenche a lista de perifericos 
	public void adicionarPeriferico() {
		int quantidadePerifericos = 0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Digite a quantidade de periféricos que será adicionado: ");
		quantidadePerifericos = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < quantidadePerifericos; i++) {
			Periferico periferico = new Periferico();
			periferico = capturarPeriferico(i + 1);
			this.perifericos.add(periferico);	
		}
	}
	
	public void prioridadeFixa() throws InterruptedException {
		Periferico.ordenacaoCrescente = true;
		
		Collections.sort(this.perifericos);
		
		System.out.println("\nPRIORIDADE FIXA:\n-----------------------------");
		
		for (Iterator iterator = this.perifericos.iterator(); iterator.hasNext(); ) {  
			   Periferico p = (Periferico) iterator.next();  
			   System.out.println ("O dispositivo " + p.getNome() + " está ativo!");
			   Thread.sleep (p.getTempoExecucao() * 1000);
		}
	}
	
	public void prioridadeRotativa() throws InterruptedException {
		Periferico.ordenacaoCrescente = true;
		Scanner scanner = new Scanner(System.in);
		int quantidadeRodadas = 0;
		
		System.out.println("\nPRIORIDADE ROTATIVA:\n-----------------------------");
		
		System.out.print("Digite a quantidade de rodadas: ");
		quantidadeRodadas = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < quantidadeRodadas; i++) {
			Collections.sort(this.perifericos);
			
			for (Iterator iterator = this.perifericos.iterator(); iterator.hasNext(); ) {  
				   Periferico p = (Periferico) iterator.next();  
				   System.out.println ("O dispositivo " + p.getNome() + " está ativo!");
				   Thread.sleep (p.getTempoExecucao() * 1000);
			}
			
			Periferico.ordenacaoCrescente = !Periferico.ordenacaoCrescente;
		}
	}
	
	public void prioridadePorJustica() throws InterruptedException{
		Periferico.ordenacaoCrescente = true;
	
		System.out.println("\nPRIORIDADE POR JUSTIÇA:\n-----------------------------");
		
		while(!this.perifericos.isEmpty()) {
			int contador = 0;
			
			for (Iterator iterator = this.perifericos.iterator(); iterator.hasNext(); ) {  
				   Periferico p = (Periferico) iterator.next();  
				   if(p.getTempoExecucao() > 5) {
					   System.out.println ("O dispositivo " + p.getNome() + " está ativo!");
					   p.setTempoExecucao(p.getTempoExecucao() - 5);
					   Thread.sleep(5000);
				   }else if(p.getTempoExecucao() > 0 && p.getTempoExecucao() <= 5) {
					   System.out.println ("O dispositivo " + p.getNome() + " está ativo!");
					   Thread.sleep (p.getTempoExecucao() * 1000);
					   p.setTempoExecucao(0);
				   }
			}
			
			for(Iterator iterator = this.perifericos.iterator(); iterator.hasNext();) {
				Periferico p = (Periferico) iterator.next(); 
				if(p.getTempoExecucao() == 0) {
					contador++;
				}
			}
			
			if( contador == this.perifericos.size()) {
				this.perifericos.clear();
			}
		}
	}
	
}
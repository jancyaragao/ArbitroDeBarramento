package br.edu.ufrn.imd.arquitetura.main;
//import java.util.Scanner;

import br.edu.ufrn.imd.arquitetura.controler.Arbitro;

public class Main {

	public static void main(String[] args) {
//		int tipoArbitragem = 0;
		Arbitro arbitro = new Arbitro();

		arbitro.adicionarPeriferico();
		try {
			arbitro.prioridadeFixa();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			arbitro.prioridadeRotativa();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			arbitro.prioridadePorJustica();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		tipoArbitragem = exibirArbitragens();
//		arbitro.arbitrar(tipoArbitragem);
	}
	
//	private static int exibirArbitragens() {
//		Scanner scanner = new Scanner(System.in);
//		int opcao = 0;
//		
//		do {
//			System.out.println("Escolha o tipo de arbitragem:");
//			System.out.println("1- Prioridade Fixa.");
//			System.out.println("2- Prioridade Rotativa.");
//			System.out.println("3- Prioridade justa.");
//			
//			opcao = Integer.parseInt(scanner.nextLine());
//			
//		} while(verificarEscolha(opcao));
//		
//		return opcao;
//		
//	}
	
//	private static boolean verificarEscolha(int escolha) {
//		if (escolha < 1) {
//			return true;
//		} else if ( escolha > 3) {
//			return true;
//		}
//		return false;
//	}

}
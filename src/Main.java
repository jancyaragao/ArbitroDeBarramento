import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int tipoArbitragem = 0;
		Arbitro arbitro = new Arbitro();
		
		tipoArbitragem = exibirArbitragens();
		arbitro.arbitrar(tipoArbitragem);
	}
	
	private static int exibirArbitragens() {
		Scanner scanner = new Scanner(System.in);
		int opcao = 0;
		
		do {
			System.out.println("Escolha o tipo de arbitragem:");
			System.out.println("1- Daisy Chaining.");
			System.out.println("2- Prioridade Fixa.");
			System.out.println("3- Prioridade Rotativa.");
			System.out.println("4- Prioridade justa.");
			
			opcao = Integer.parseInt(scanner.nextLine());
			
		}while(verificarEscolha(opcao));
		
		return opcao;
		
	}
	
	private static boolean verificarEscolha(int escolha) {
		if (escolha < 1) {
			return true;
		} else if ( escolha > 4) {
			return true;
		}
		
		return false;
	}

}

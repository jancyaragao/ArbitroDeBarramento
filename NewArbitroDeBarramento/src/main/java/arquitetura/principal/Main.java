package main.java.arquitetura.principal;

import main.java.arquitetura.controlador.Arbitro;

public class Main {

	public static void main(String[] args) {
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
	}
	
}
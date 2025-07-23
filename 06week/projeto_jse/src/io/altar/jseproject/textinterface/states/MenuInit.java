package io.altar.jseproject.textinterface.states;

import java.util.Scanner;

public class MenuInit extends State {
	
	@Override
	public int on () {
		System.out.println("n==== MENU PRINCIPAL ====");
		System.out.println("1. Listar Produtos");
		System.out.println("2. Listar Prateleiras");
		
		System.out.println("Escolha uma opção: ");
		Scanner scanner = new Scanner(System.in); //nao vou fechar o scanner porque pode dar erro mais tarde se tentar ler de novo a entrada padrão do sistema
		return scanner.nextInt();
	}
}

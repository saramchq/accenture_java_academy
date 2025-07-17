package io.altar.jseproject.textinterface;

import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public class TextInterface {

	Scanner scanner = new Scanner(System.in);
	
	//criei duas arraylist p guardar em memória os produtos e prateleiras q forem criados enquanto corre o programa
	//List<Product> produtos = new ArrayList<>();
	//List<Shelf> prateleiras = new ArrayList<>();
	
	ProductRepository productRepo = ProductRepository.getInstance();
	ShelfRepository shelfRepo = ShelfRepository.getInstance();


	public void menu() {
		int opcao = -1; // inicio c uma opçao invalida pq se nao o while nem chega a inicializar uma vez

		while (opcao != 3) { 
			System.out.println("\n----- MENU PRINCIPAL -----");
			System.out.println("1 - Listar produtos");
			System.out.println("2 - Listar prateleiras");
			System.out.println("3 - Sair");
			System.out.print("Escolha uma opção: ");

			if (scanner.hasNextInt()) { // Valida se a entrada do utilizador é um número inteiro
				opcao = scanner.nextInt();
				scanner.nextLine(); // limpa o enter do buffer

				switch (opcao) {
					case 1:
						menuProdutos(); // chama o submenu dos produtos
						break;
					case 2:
						menuPrateleiras(); // chama o submenu das prateleiras
						break;
					case 3:
						System.out.println("Adeus!");
						break;
					default:
						System.out.println("Opção inválida.");
				}
			} else {
				System.out.println("Por favor, insira uma opção válida!");
				scanner.nextLine(); // consome a entrada inválida
			}
		}
	}

	// submenu dos produtos
	private void menuProdutos() {
		int opcao = -1;

		while (opcao != 5) {
			listarProdutos(); // primeiro mostra a lista
			System.out.println("----- GESTÃO DE PRODUTOS -----");
			System.out.println("1 - Criar novo produto");
			System.out.println("2 - Editar um produto existente");
			System.out.println("3 - Consultar o detalhe de um produto");
			System.out.println("4 - Remover um produto");
			System.out.println("5 - Voltar ao menu anterior");
			System.out.print("Escolha uma opção: ");

			if (scanner.hasNextInt()) {
				opcao = scanner.nextInt();
				scanner.nextLine();

				switch (opcao) {
					case 1:
						criarProduto();
						break;
					case 2:
						System.out.println("[Função editar produto ainda por implementar]");
						break;
					case 3:
						System.out.println("[Função consultar produto ainda por implementar]");
						break;
					case 4:
						System.out.println("[Função remover produto ainda por implementar]");
						break;
					case 5:
						System.out.println("Menu reiniciado. Por favor, escolha uma das seguintes opções:\\n");
						break;
					default:
						System.out.println("Opção inválida.");
				}
			} else {
				System.out.println("Por favor, insira uma opção válida!");
				scanner.nextLine();
			}
		}
	}

	// submenu das prateleiras
	private void menuPrateleiras() {
		int opcao = -1;

		while (opcao != 5) {
			listarPrateleiras(); //primeiro mostra a lista
			System.out.println("----- GESTÃO DE PRATELEIRAS -----");
			System.out.println("1 - Criar nova prateleira");
			System.out.println("2 - Editar uma prateleira existente");
			System.out.println("3 - Consultar o detalhe de uma prateleira");
			System.out.println("4 - Remover uma prateleira");
			System.out.println("5 - Voltar ao menu anterior");
			System.out.print("Escolha uma opção: ");

			if (scanner.hasNextInt()) {
				opcao = scanner.nextInt();
				scanner.nextLine();

				switch (opcao) {
					case 1:
						criarPrateleira();
						break;
					case 2:
						System.out.println("[Função editar prateleira ainda por implementar]");
						break;
					case 3:
						System.out.println("[Função consultar prateleira ainda por implementar]");
						break;
					case 4:
						System.out.println("[Função remover prateleira ainda por implementar]");
						break;
					case 5:
						System.out.println("Menu reiniciado. Por favor, escolha uma das seguintes opções:\\n");
						break;
					default:
						System.out.println("Opção inválida.");
				}
			} else {
				System.out.println("Por favor, insira uma opção válida!");
				scanner.nextLine();
			}
		}
	}

	//metodos

	public void criarProduto() {
		System.out.println("----- CRIAR PRODUTO -----");

		// Pede e valida o desconto
		System.out.print("Insira o desconto: ");
		while (!scanner.hasNextDouble()) {
			System.out.println("Por favor, insira um valor válido!");
			scanner.nextLine();
		}
		double desconto = scanner.nextDouble();
		scanner.nextLine();
		
		// Pede e valida o IVA
		System.out.print("Insira o IVA: ");
		while (!scanner.hasNextDouble()) {
			System.out.println("Por favor, insira um valor válido!");
			scanner.nextLine();
		}
		double iva = scanner.nextDouble();
		scanner.nextLine();
		
		// Pede e valida o PVP
		System.out.print("Insira o PVP: ");
		while (!scanner.hasNextDouble()) {
			System.out.println("Por favor, insira um valor válido!");
			scanner.nextLine();
		}
		double pvp = scanner.nextDouble();
		scanner.nextLine();
		
		// Cria o produto e guarda na lista
		Product novoProduto = new Product(desconto, iva, pvp);
		productRepo.create(novoProduto);
		//produtos.add(novoProduto); // guarda 

		System.out.println("Produto criado.");
	}

	public void criarPrateleira() {
		System.out.println("----- CRIAR PRATELEIRA -----");
		
		// Pede e valida a capacidade
		System.out.print("Insira a capacidade: ");
		while (!scanner.hasNextInt()) {
			System.out.println("Por favor, insira um valor válido!");
			scanner.nextLine();
		}
		int capacidade = scanner.nextInt();
		scanner.nextLine();
		
		// Pede e valida o preço de aluguer
		System.out.print("Insira o preço de aluguer: ");
		while (!scanner.hasNextDouble()) {
			System.out.println("Por favor, insira um valor válido!");
			scanner.nextLine();
		}
		double precoAluguer = scanner.nextDouble();
		scanner.nextLine();
		
		// Cria a prateleira e guarda na lista
		Shelf novaPrateleira = new Shelf(capacidade, precoAluguer);
		shelfRepo.create(novaPrateleira); // guarda

	}

	public void listarProdutos() {
		System.out.println("----- LISTA DE PRODUTOS -----");
		// Verifica se há produtos na lista
		if (productRepo.getAll().isEmpty()) {
			System.out.println("Ainda não foram criados produtos.");
			return;
		}
	
		// Percorre e mostra os detalhes de cada produto
		for (Product produto : productRepo.getAll()) {
			System.out.println("ID: " + produto.getId());
			System.out.println("Desconto: " + produto.getDescontoUni());
			System.out.println("IVA: " + produto.getIva());
			System.out.println("PVP: " + produto.getPvp());
			System.out.println("----------------------------");
		}
	}
	
	public void listarPrateleiras() {
		System.out.println("----- LISTA DE PRATELEIRAS -----");
		// Verifica se há prateleiras na lista
		if (shelfRepo.getAll().isEmpty()) {
			System.out.println("Ainda não foram criadas prateleiras.");
			return;
		}

		// Percorre e mostra os detalhes de cada prateleira
		for (Shelf prateleira : shelfRepo.getAll()) {
			System.out.println("ID: " + prateleira.getId());
			System.out.println("Capacidade: " + prateleira.getCapacidade());
			System.out.println("Preço de aluguer: " + prateleira.getPrecoAluguer());
			System.out.println("----------------------------");
		}
	}

}

package io.altar.jseproject.textinterface.states;

import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public class CreateProduct extends State {
	@Override
	public int on() {
		Scanner scanner = new Scanner(System.in); //cria o scanner p ler do teclado
		
		System.out.println("\n===== CRIAR PRODUTO =====");
		
		System.out.println("DESCONTO UNITÁRIO: " ); //pede ao utilizador o valor do desconto e guarda-o
		double desconto = scanner.nextDouble();
		
		System.out.println("IVA: "); //pede o iva e guarda
		double iva = scanner.nextDouble();
		
		System.out.println("PVP: "); //pede o pvp e guarda
		double pvp = scanner.nextDouble();
		
		Product novoProduto = new Product(desconto, iva, pvp); //cria um novo obj product c os dados inseridos
		ProductRepository.getInstance().create(novoProduto); //e usa o repositorio p guarda-lo na memoria
		
		System.out.println("Produto criado com sucesso! ID: " + novoProduto.getId()); //informa o utilizador q o produto foi criado com X id
		scanner.nextLine(); //limpar o buffer antes do nextline pq me deu erro ao escolher s/n
		System.out.print("Deseja associar este produto a prateleiras existentes? (s/n): ");
		String resposta = scanner.nextLine();

		if (resposta.equalsIgnoreCase("s")) {
			boolean continuar = true;

			while (continuar) {
				System.out.print("Insira o ID da prateleira a associar: ");
				if (scanner.hasNextLong()) {
					long idPrateleira = scanner.nextLong();
					scanner.nextLine();

					Shelf prateleira = ShelfRepository.getInstance().getById(idPrateleira);
					if (prateleira != null) {
						prateleira.setIdProduto((long) novoProduto.getId());
						ShelfRepository.getInstance().edit(prateleira);

						novoProduto.getPrateleiras().add(prateleira.getId());
						ProductRepository.getInstance().edit(novoProduto);

						System.out.println("Prateleira associada com sucesso.");
					} else {
						System.out.println("Prateleira com ID " + idPrateleira + " não encontrada.");
					}
				} else {
					System.out.println("ID inválido.");
					scanner.nextLine();
				}

				System.out.print("Deseja associar outra prateleira? (s/n): ");
				String outra = scanner.nextLine();
				if (!outra.equalsIgnoreCase("s")) {
					continuar = false;
				}
			}
		}

		return 0;
	}
}
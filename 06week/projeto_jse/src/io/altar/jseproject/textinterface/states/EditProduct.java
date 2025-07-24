package io.altar.jseproject.textinterface.states;

import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.ProductRepository;

public class EditProduct extends State{
	@Override
	public int on() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n===== EDITAR PRODUTO =====");
		System.out.println("Informe o ID do produto que deseja editar: ");
		
		if(scanner.hasNextLong()) { //verifica se o utilizador inseriu um nr valido
			long id = scanner.nextLong();
			scanner.nextLine(); //limpa o buffer
			
			Product produto = ProductRepository.getInstance().getById(id); //vai buscar produto ao repositorio
			
			if (produto != null) { //se o produto existir
                System.out.println("PRODUTO ENCONTRADO!");
                System.out.println("DESCONTO ATUAL: " + produto.getDescontoUni());
                System.out.println("IVA ATUAL: " + produto.getIva());
                System.out.println("PVP ATUAL: " + produto.getPvp());

                System.out.print("NOVO DESCONTO: ");
                while (!scanner.hasNextDouble()) { //valida q o input é um nr decimal
                    System.out.println("Insira um valor válido.");
                    scanner.nextLine();//limpa o input invalido
                }
                double novoDesconto = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("NOVO IVA: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Insira um valor válido.");
                    scanner.nextLine();
                }
                double novoIva = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("NOVO PVP: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Insira um valor válido.");
                    scanner.nextLine();
                }
                double novoPvp = scanner.nextDouble();
                scanner.nextLine();
                
                //aplica as alteraçoes ao obj
                produto.setDescontoUni(novoDesconto);
                produto.setIva(novoIva);
                produto.setPvp(novoPvp);

                ProductRepository.getInstance().edit(produto);

                System.out.println("Produto atualizado com sucesso.");
            } else {
                System.out.println("Produto com o ID " + id + " não encontrado.");
            }
        } else {
            System.out.println("ID inválido. Insira um número."); //só p caso do utilizador inseirr letras
            scanner.nextLine();
        }

        return 0; //volta p menu principal
    }
}
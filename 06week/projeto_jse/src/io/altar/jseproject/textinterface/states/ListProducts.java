package io.altar.jseproject.textinterface.states;

import java.util.List;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.ProductRepository;

public class ListProducts extends State {
	@Override
	public int on () {
		System.out.println("\n===== LISTA DE PRODUTOS =====");
		
		//chama o metodo estatico getInstance() da class ProductRepository q deevolve a sua instancia unica
		List<Product> produtos = ProductRepository.getInstance().getAll(); //o metodo getAll devolve uma lista com todos os produtos guardados no repositório
		
		if (produtos.isEmpty()) {
			System.out.println(" Não existem produtos registados.");
		} else { 
			for (Product p : produtos ) {
				System.out.println("ID: " + p.getId() + " | PVP: " + p.getPvp() + " | IVA: " + p.getIva() + " | DESCONTO: " + p.getDescontoUni() + " | PRATELEIRAS: " + p.getPrateleiras());
			}
		}
		
		return 0; //volta ao menu inicial
	}
}


//p.getId > herdado da superclass myEntity
//p.getPvp, getIva > do produto
//p.getDescontoUni > desconto aplicado
//p.getPrateleiras > lista de ids das prateleiras onde está o produto
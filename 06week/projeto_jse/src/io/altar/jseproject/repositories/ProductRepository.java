package io.altar.jseproject.repositories;

import io.altar.jseproject.model.Product;

public class ProductRepository extends EntityRepository <Product> {
	//cria o atributo INSTANCE (unico e final)
	private static final ProductRepository INSTANCE = new ProductRepository();
	
	//metodo p aceder a instancia unica
	public static ProductRepository getInstance() {
		return INSTANCE;
	}
	
	//construitor pvd (ngm pode criar instancias de fora)
	private ProductRepository() {}
}

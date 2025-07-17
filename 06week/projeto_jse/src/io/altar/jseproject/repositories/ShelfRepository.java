package io.altar.jseproject.repositories;

import io.altar.jseproject.model.Shelf;

	public class ShelfRepository extends EntityRepository<Shelf> {
		// cria o atributo INSTANCE (unico e final)
		private static final ShelfRepository INSTANCE = new ShelfRepository();

		// metodo p aceder a instancia unica
		public static ShelfRepository getInstance() {
			return INSTANCE;
		}

		// construitor pvd (ngm pode criar instancias de fora)
		private ShelfRepository() {
		}
	}

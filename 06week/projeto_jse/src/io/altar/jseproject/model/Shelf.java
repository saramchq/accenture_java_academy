package io.altar.jseproject.model;

public class Shelf {
	private static int contadorIds = 1;
	private final int id;
	private int capacidade;
	private int idProduto; //aqui é onde guardo o id do produto
	private double precoAluguer;
	
	public Shelf(int capacidade, double precoAluguer) { 
		this.id=contadorIds++;
		this.capacidade = capacidade; 
		this.precoAluguer = precoAluguer;
	}
	//construtor que recebe 3 parametros de entrada, capacidade idproduto e precoaluguer. dar opçao ou n ao utilizador de criar prateleiras com produto la dentro
	
	public int getCapacidade() {
		return capacidade;
	}	
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public double getPrecoAluguer() {
		return precoAluguer;
	}
	public void setPrecoAluguer(double precoAluguer) {
		this.precoAluguer = precoAluguer;
	}
	public int getId() {
		return id;
	}
	
}


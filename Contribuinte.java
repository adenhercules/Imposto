package com.esio.imposto;

public abstract class Contribuinte{
	
	private float rendaBrutaAnual;
	private String nome;
	
	public Contribuinte() {}
	
	public Contribuinte(String nome, float renda) {
		this.nome = nome;
		this.rendaBrutaAnual = renda;
	}
	
	//Renda Anual
	public float getRendaAnual() {
		return this.rendaBrutaAnual;
	}
	public void setRendaAnual(float renda) {
		this.rendaBrutaAnual = renda;
	}
	//nome
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Contribuinte rendaBrutaAnual: " + rendaBrutaAnual + ", nome: " + nome + " ";
	}
	
	
	

}

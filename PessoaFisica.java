package com.esio.imposto;

public class PessoaFisica extends Contribuinte implements Estado{
	
	private String cpf;
	private float gastoSaude;
	private float gastoEducacao;
	
	public PessoaFisica() {}
	
	public PessoaFisica(String nome, float renda, String cpf, float gastoSaude, float gastoEducacao) {
		super(nome, renda);
		this.cpf = cpf;
		this.gastoSaude = gastoSaude;
		this.gastoEducacao = gastoEducacao;
	}
	
	//CPF
	public String getCpf() {
		return this.cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	//Gasto Saude
	public float getGastoSaude() {
		return this.gastoSaude;
	}
	public void setGastoSaude(float gastoSaude) {
		this.gastoSaude = gastoSaude;
	}
	//Gasto Educacao
	public float getGastoEducacao() {
		return this.gastoEducacao;
	}
	public void setGastoEducacao(float gastoEducacao) {
		this.gastoEducacao = gastoEducacao;
	}

	@Override
	public float arrecadaImposto() {
		return this.getRendaAnual() - this.gastoSaude - this.gastoEducacao;
	}

	@Override
	public String toString() {
		return "PessoaFisica 	CPF:"+this.cpf+", Gasto Saude:"+this.gastoSaude+", Gasto Educacao:"+this.gastoEducacao;
	}
	
	
	

}

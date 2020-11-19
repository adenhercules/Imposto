package com.esio.imposto;

public class PessoaJuridica extends Contribuinte implements Estado{
	
	private String cgc;
	private float gastoPessoal;
	private float gastoEquipamento;
	
	public PessoaJuridica() {}
	
	public PessoaJuridica(String nome, float renda, String cgc, float gastoPessoal, float gastoEquipamento) {
		super(nome, renda);
		this.cgc = cgc;
		this.gastoPessoal = gastoPessoal;
		this.gastoEquipamento = gastoEquipamento;
	}
	//cgc
	public String getCgc() {
		return cgc;
	}
	public void setCgc(String cgc) {
		this.cgc = cgc;
	}
	//Gasto Pessoal
	public float getGastoPessoal() {
		return gastoPessoal;
	}
	public void setGastoPessoal(float gastoPessoal) {
		this.gastoPessoal = gastoPessoal;
	}
	//Gasto Equipamento
	public float getGastoEquipamento() {
		return gastoEquipamento;
	}
	public void setGastoEquipamento(float gastoEquipamento) {
		this.gastoEquipamento = gastoEquipamento;
	}

	@Override
	public float arrecadaImposto() {
		return this.getRendaAnual() - this.gastoPessoal - this.gastoEquipamento;
	}

	@Override
	public String toString() {
		return "Pessoa Juridica 	CGC:"+this.cgc+", Gasto Pessoal:"+this.gastoPessoal+", Gasto Equipamento:"
			+this.gastoEquipamento;
	}
	
	

}

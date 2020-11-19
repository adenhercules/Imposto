package com.esio.imposto;

public class Ipva implements Estado{

	private String placaCarro;
	private char marcaCarro;
	private float valorAnual;
	
	public Ipva(String placaCarro, char marcaCarro, float valorAnual) {
		this.placaCarro = placaCarro;
		this.marcaCarro = marcaCarro;
		this.valorAnual = valorAnual;
	}
	//Placa Carro
	public String getPlacaCarro() {
		return placaCarro;
	}
	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}
	//Marca Carro
	public char getMarcaCarro() {
		return marcaCarro;
	}
	public void setMarcaCarro(char marcaCarro) {
		this.marcaCarro = marcaCarro;
	}
	//Valor Anual
	public float getValorAnual() {
		return valorAnual;
	}
	public void setValorAnual(float valorAnual) {
		this.valorAnual = valorAnual;
	}
	@Override
	public float arrecadaImposto() {
		float t=0;
		switch(this.marcaCarro) {
			case 'W':
				t=1000;
				break;
			case 'G':
				t=1200;
				break;
			case 'F':
				t=900;
				break;
			default:
				t=1500;
				break;
		}
		return t;
	}
	@Override
	public String toString() {
		return "IPVA Placa Automovel:"+this.placaCarro+", Marca Automovel="+this.marcaCarro+", Valor Anual:"+this.valorAnual;
	}
	
	
	
	
}

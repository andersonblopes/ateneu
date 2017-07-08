package br.com.ateneu.ads.hotel;

public class Apartamento {

	private int numeroApt;
	private String tipoApt;
	private Double valordiaria;
	private String hospede;
	private int num_dias_ocupacao;
	private Boolean Livre;
	private double consumo;
	
	public Apartamento(){
		setLivre(true);
	}

	public int getNumero() {
		return numeroApt;
	}

	public void setNumero(int numero) {
		this.numeroApt = numero;
	}

	public String getTipoApt() {
		return tipoApt;
	}

	public void setTipoApt(String tipoApt) {
		if (tipoApt.toUpperCase().equals("COMUM")) {
			this.tipoApt = tipoApt;
		} else if (tipoApt.toUpperCase().equals("PADRAO")) {
			this.tipoApt = tipoApt;
		} else {
			this.tipoApt = tipoApt;
		}
	}

	public Double getValorDiaria() {
		return valordiaria;
	}

	public void atribuiValorDiaria(String tipoapartamento) {
		if (tipoapartamento.toUpperCase().equals("COMUM")) {
			this.valordiaria = 100.00;
		} else if (tipoapartamento.toUpperCase().equals("PADRAO")) {
			this.valordiaria = 150.00;
		} else {
			this.valordiaria = 200.00;
		}
	}

	public String getHospede() {
		return hospede;
	}

	public void setHospede(String hospede) {
		this.hospede = hospede;
	}

	public int getNum_dias_ocupacao() {
		return num_dias_ocupacao;
	}

	public void setNum_dias_ocupacao(int num_dias_ocupacao) {
		this.num_dias_ocupacao = num_dias_ocupacao;
	}

	public Boolean getLivre() {
		return Livre;
	}

	public void setLivre(Boolean livre) {
		Livre = livre;
	}

	public double getConsumo() {
		return consumo;
	}

	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

}
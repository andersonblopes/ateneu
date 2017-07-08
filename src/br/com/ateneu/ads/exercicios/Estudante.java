package br.com.ateneu.ads.exercicios;

public class Estudante {

	private String nome;
	private int matricula;
	private char sexo;

	private double[] notas = new double[4];

	public void exibir() {
		System.out.println("Aluno " + this.getNome() + "\nDo sexo: " + this.getSexo() + " \nMatricula numero: "
				+ this.getMatricula() + "");
	}

	public void atribuirNota(int numProva, double nota) {
		notas[numProva - 1] = nota;
	}

	public double lerNota(int numProva) {
		return notas[numProva - 1];
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public double[] getNotas() {
		return notas;
	}

}

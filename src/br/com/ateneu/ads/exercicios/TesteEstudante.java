package br.com.ateneu.ads.exercicios;

public class TesteEstudante {

	public static void main(String[] args) {

		//Instanciando estudante
		Estudante estudante = new Estudante();
		
		//Atribuindo atributos ao estudante
		estudante.setMatricula(2004001);
		estudante.setNome("Maria Silva");
		estudante.setSexo('F');
		
		//Atribuindo notas
		estudante.atribuirNota(1, 7.0);
		estudante.atribuirNota(2, 8.2);
		estudante.atribuirNota(3, 6.0);
		estudante.atribuirNota(4, 5.5);
		
		//Mostrando dados do estudante
		estudante.exibir();
		
		//Exibindo notas
		double[] notas = estudante.getNotas();
		for(int i = 0; i < notas.length; i++){
			System.out.println("Nota "+(i+1)+": "+notas[i]);
		}
		
		//Mostar média das notas
		double media = 0.0;
		for(int i = 0; i < notas.length; i++){
			media += notas[i];
		}
		System.out.println("A média obtida pelo aluno "+estudante.getNome()+" foi de: "+media/4);
			
	}

}

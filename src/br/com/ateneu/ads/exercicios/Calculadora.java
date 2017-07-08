package br.com.ateneu.ads.exercicios;

import java.util.Scanner;

public class Calculadora {

	public static double somar(double x, double y) {
		double soma = x + y;
		return soma;
	}

	public static double subtrair(double a, double b) {
		return (a - b);
	}

	public static double multiplicar(double a, double b) {
		return (a * b);
	}

	public static double dividir(double a, double b) {
		return (a / b);
	}

	public static double expo(double a, double b) {
		for (int i = 0; i < b - 1; i++) {
			a = a * a;
		}
		return a;
	}

	public static void menu() {
		System.out.println("********************");
		System.out.println("1-Somar");
		System.out.println("2-Subtrair");
		System.out.println("3-Multiplicar");
		System.out.println("4-Dividir");
		System.out.println("5-Exponencial");
		System.out.println("0-Sair");
		System.out.println("********************");
	}

	public static void main(String[] args) {

		double a = 0;
		double b = 0;
		int opcao = -1;
		Scanner entrada = new Scanner(System.in);

		do {
			menu();
			opcao = entrada.nextInt();
			if(opcao ==1){
				somar(a,b);
			}else if(opcao == 2){
				subtrair(a, b);
			}
		} while (opcao != 0);
	}
}



/*
	private static Scanner scanner;

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		scanner = new Scanner(System.in);
		System.out.println("====================================");
		System.out.println("CALCULADORA");
		System.out.println("====================================");
		System.out.println("Digite a opção desejada: \n" 
				+ "1 - Adição\n" 
				+ "2 - Subtração\n" 
				+ "3 - Multiplicação\n"
				+ "4 - Divisão\n"
				+ "0 - Encerrar calculadora");
		int operacao = scanner.nextInt();
		while(operacao > 4){
			System.out.println("Opção inválidfa!");
			menu();
		}
		if(operacao == 0){
			System.out.println("Calculadora encerrada!");
			System.exit(0);
		}else{
			obterDados(operacao);
		}
	}

	public static void obterDados(int operacao){
		System.out.println("Digite o primeiro número:");
		double n1 = scanner.nextDouble();
		System.out.println("Digite o segundo número:");
		double n2 = scanner.nextDouble();
		switch (operacao) {
			case 1: somar(n1, n2);break;
			case 2: subtrair(n1, n2);break;
			case 3: multiplicar(n1,n2);break;
			case 4: dividir(n1, n2);break;
		}
	}

	public static void somar(Double n1, Double n2){
		System.out.printf("%.2f + %.2f = %.2f \n\n",n1,n2,n1+n2);
		menu();
	}

	public static void subtrair(Double n1, Double n2){
		System.out.printf("%.2f - %.2f = %.2f \n\n",n1,n2,n1-n2);
		menu();
	}

	public static void multiplicar(Double n1, Double n2){
		System.out.printf("%.2f * %.2f = %.2f \n\n",n1,n2,n1*n2);
		menu();
	}

	public static void dividir(Double n1, Double n2){
		if(n2 == 0){
			System.out.println("Não existe divizão por zero! \n");
		}else{
			System.out.printf("%.2f / %.2f = %.2f \n\n",n1,n2,n1/n2);
		}
		menu();
	}
}*/
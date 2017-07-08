package br.com.ateneu.ads.exercicios;

import javax.swing.JOptionPane;

public class Questao3 {
	public static void main(String[] args) {
		if (Integer.parseInt(JOptionPane.showInputDialog("Digite um numero:")) % 2 == 0) {
			JOptionPane.showMessageDialog(null, "O numero digitado é par", "Resultado",JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "O numero digitado é ímpar", "Resultado",JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
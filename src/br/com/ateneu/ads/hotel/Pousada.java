package br.com.ateneu.ads.hotel;

import java.util.Scanner;

public class Pousada {

	//array do tipo apartamento
	public static Apartamento[] pousada = new Apartamento[2];

	static Scanner leitor = new Scanner(System.in);
	static int cont = 0;

	public static void main(String[] args) {
		menu();
	}

	private static void menu(){
		int menu = 10;
		while(menu !=0){
			System.out.println("¦-------POUSADA GUANABARA----------------¦");
			System.out.println("¦----------------------------------------¦");
			System.out.println("¦       ESCOLHA UMA OPÇÃO                ¦");
			System.out.println("¦----------------------------------------¦");
			System.out.println("¦ 1 - CADASTRAR APARTAMENTO              ¦");
			System.out.println("¦ 2 - ALUGARR APARTAMENTO - (CHECK IN)   ¦");
			System.out.println("¦ 3 - ADICIONAR CONSUMO                  ¦");
			System.out.println("¦ 4 - DESOCUPAR APARTAMENTO - (CHECK OUT)¦");
			System.out.println("¦ 5 - LISTAR APARTAMENTOS                ¦");
			System.out.println("¦ 6 - LISTAR APARTAMENTOS LIVRES         ¦");
			System.out.println("¦ 0 - SAIR                               ¦");
			System.out.println("+----------------------------------------+");

			menu = leitor.nextInt();

			switch (menu) {
			case 1:
				cadastrarApartamento(); break;
			case 2:
				checkIn(); break;
			case 3:		
				ListarApsOcupados();
				System.out.println("Digite o Apartamento para adicionar o valor:");
				int numeroApt = leitor.nextInt();
				System.out.println("Digite o valor que deseja adcionar :");
				double valor = leitor.nextDouble();
				adicionarConsumo(numeroApt, valor);
				break;
			case 4:
				ListarApsOcupados();
				System.out.println("Digite o numero do apartamento que deseja fechar estadia");
				checkOut(leitor.nextInt());
				break;
			case 5:
				ListarAps();
				break;
			case 6:
				ListarApsLivres();
				break;
			case 0:
				System.out.println("Sistema encerrado...");
				System.exit(0);
				break;
			}
		}
	}

	public static void cadastrarApartamento() {
		if(cont < pousada.length){
			for (int i = 0; i < pousada.length; i++) {
				if (pousada[i] == null) {
					pousada[i] = preparaApartamento();
					System.out.println("Apartamento cadastrado com sucesso!");
					cont++;
					break;
				}
			}	
		}else{
			System.out.println("Capacidade de cadastros atingida.");
		}
	}

	private static Apartamento preparaApartamento(){
		Apartamento apartamento = new Apartamento();
		System.out.println("Digite o número do apartamento a ser cadastrado: ");
		int numapselecionado = leitor.nextInt();

		//Verifica se o número já foi utilizado em outro apartamento
		for(int i = 0; i < pousada.length; i++){
			if(pousada[i] != null){
				if(numapselecionado == pousada[i].getNumero()){
					System.out.println("Apartamento já cadastrado nesta pousada, favor reiniciar operação...");
					menu();
				}	
			}
		}

		apartamento.setNumero(numapselecionado);
		int tmp = 0;

		while(tmp < 1 || tmp > 3){
			System.out.println("=====================\nDigite o tipo de apartamento: \n=====================\n 1 - COMUM \n 2 - PADRAO \n 3 - LUXO\n=====================");
			tmp = leitor.nextInt();

			//Atribuindo tipo de apartamento
			switch (tmp) {
			case 1: apartamento.setTipoApt("COMUM"); break;
			case 2: apartamento.setTipoApt("PADRAO"); break;
			case 3: apartamento.setTipoApt("LUXO"); break;	
			}
			apartamento.atribuiValorDiaria(apartamento.getTipoApt());
		}
		return apartamento;
	}

	public static void ListarApsLivres(){
		System.out.println("----------------------------------------------------------------------");
		System.out.println("APARTAMENTOS LIVRES");
		System.out.println("----------------------------------------------------------------------");
		for (int i = 0; i < pousada.length; i++) {
			if(cont == 0){
				System.out.println("Não existem apartamentos cadastrados!!!");
				break;
			}else if(pousada[i] != null && pousada[i].getLivre()){
				System.out.println("Apartamento "+pousada[i].getNumero() + " - "+pousada[i].getTipoApt());
			}
		}
		System.out.println("----------------------------------------------------------------------");
	}
	
	public static void ListarApsOcupados(){
		System.out.println("----------------------------------------------------------------------");
		System.out.println("APARTAMENTOS OCUPADOS");
		System.out.println("----------------------------------------------------------------------");
		for (int i = 0; i < pousada.length; i++) {
			if(cont == 0){
				System.out.println("Não existem apartamentos cadastrados!!!");
				break;
			}else if(pousada[i] != null && !pousada[i].getLivre()){
				System.out.println("Apartamento "+pousada[i].getNumero() + " - "+pousada[i].getTipoApt()+" Hóspede: "+pousada[i].getHospede());
			}
		}
		System.out.println("----------------------------------------------------------------------");
	}

	public static void ListarAps(){
		System.out.println("----------------------------------------------------------------------");
		System.out.println("RELAÇÃO DE APARTAMENTOS");
		System.out.println("----------------------------------------------------------------------");
		if(cont == 0){
			System.out.println("Não existem apartamentos cadastrados!!!");
			System.out.println("----------------------------------------------------------------------");
		}else{
			for (int i = 0; i < pousada.length; i++) {
				if(pousada[i] != null){
					if(!pousada[i].getLivre()){
						System.out.println("Ocupados");
						System.out.println("----------------------------------------------------------------------");
						System.out.println("APARTAMENTO: "+ pousada[i].getNumero());
						System.out.println("TIPO: " + pousada[i].getTipoApt());
						System.out.println("HÓSPEDE" + pousada[i].getHospede());
						System.out.println("DIAS: "+pousada[i].getNum_dias_ocupacao());
						System.out.println("TOTAL DE DIÁRIAS R$ "+pousada[i].getValorDiaria());
						System.out.println("Total de consumo: R$ "+pousada[i].getConsumo());
						System.out.println("TOTAL DA CONTA (parcial): R$ "+pousada[i].getConsumo() + pousada[i].getNum_dias_ocupacao() * pousada[i].getValorDiaria());
						System.out.println("----------------------------------------------------------------------");
					}else{
						System.out.println("Livres");
						System.out.println("----------------------------------------------------------------------");
						System.out.println("APARTAMENTO: "+ pousada[i].getNumero());
						System.out.println("TIPO: " + pousada[i].getTipoApt());
						System.out.println("----------------------------------------------------------------------");
					}
				}
			}
		}	
	}

	private static void checkIn() {	
		System.out.println("----------------------------------------------------------------------");
		System.out.println("CHECKIN");
		System.out.println("----------------------------------------------------------------------");
		ListarApsLivres();
		System.out.println("\nDigite o Apartamento para alugar:");
		int numero = leitor.nextInt();

		Apartamento ap = buscar(numero);
		if(ap != null){
			ap.setLivre(false);
			System.out.println("Digite seu nome");
			ap.setHospede(leitor.next());	
			System.out.println("Quantos dias ficara no aprtamento ?");
			ap.setNum_dias_ocupacao(leitor.nextInt());
			System.out.println(ap.getValorDiaria());
			ap.setConsumo(ap.getNum_dias_ocupacao() * ap.getValorDiaria());
			System.out.println("Apartamento: "+ap.getNumero()+" \nAlugado para o hóspede: "+ap.getHospede());
			System.out.println();
		}
		else{
			System.out.println("Apartamento não cadastrado.");

		}
	}

	public static Apartamento buscar(int numero){
		Apartamento ap = null;
		for (int i = 0; i < pousada.length; i++) {
			if (pousada[i] != null && pousada[i].getNumero() == numero){
				return pousada[i];
			}
		}		
		return ap;		
	}

	private static void checkOut(int numero){
		Apartamento ap = buscar(numero);
		if (ap != null){
			System.out.println("----------------------------------------------------------------------");
			System.out.println("CHECKOUT");
			System.out.println("----------------------------------------------------------------------");
			System.out.println("tem certeza que deseja fazer checkout?");
			if(leitor.next().equalsIgnoreCase("S")){
				System.out.println("----------------------------------------------------------------------");
				System.out.println("Extrato da conta do aparatmento: "+ap.getNumero()+" - "+ap.getTipoApt());
				System.out.println("----------------------------------------------------------------------");
				System.out.println("Hóspede: " + ap.getHospede());
				System.out.println("Dias hospedados: "+ap.getNum_dias_ocupacao());
				System.out.printf("Valor da diária: R$ %.2f",ap.getValorDiaria());
				System.out.printf("\nValor total das diarias: R$ %.2f",ap.getNum_dias_ocupacao() * ap.getValorDiaria());
				System.out.printf("\nTotal de consumo: R$ %.2f",ap.getConsumo());
				System.out.println("\n------------------------------------");
				System.out.printf("TOTAL DA CONTA: R$ %.2f",ap.getConsumo() + ap.getNum_dias_ocupacao() * ap.getValorDiaria());
				System.out.println("\n------------------------------------");
				limparApartamento(ap);
			}
		}
		else{
			System.out.println("Apartamento não cadastrado.");
		}

	}

	private static void adicionarConsumo(int numero, double valor){
		Apartamento ap = buscar(numero);
		if (ap==null){
			System.out.println("Apartamento inexistente!");
		}
		else if (!ap.getLivre()){
			ap.setConsumo(ap.getConsumo() + valor);
			System.out.println("Atualizado com sucesso");
		}else{
			System.out.println("Impossível registar consumo em apartamento sem hóspede!");
		}
	}

	private static String limparApartamento(Apartamento apartamento){
		apartamento.setHospede(null);
		apartamento.setNum_dias_ocupacao(0);
		apartamento.setLivre(true);
		apartamento.setConsumo(0);
		return "Apartamento desocupado com sucesso!";
	}
}

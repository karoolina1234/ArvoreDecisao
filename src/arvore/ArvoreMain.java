package arvore;

import java.io.*;

class ArvoreMain {

	static BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in)); // Entrada de dados.
	static ArvoreDecisao newTree;

	public static void main(String[] args) throws IOException { // classe principal

		newTree = new ArvoreDecisao(); //Instanciando a classe

		generateTree(); //Gerando a �rvore

		System.out.println("\nSa�da da �rvore"); //dados 
		System.out.println("====================");
		newTree.SaidaArvore();

		busca();
	}

	static void generateTree() { //Metodo para gera��o da �rvore
		String dinheiro = "Voc� tem dinheiro?";//salvando as strings em vari�veis para evitar repeti��o de escrita
		String rs = "Voc� gostaria de sair do Rio Grande do Sul?";
		String america = "Voc� gostaria de sair da Am�rica?";
		String praia = "Voc� gosta de praia?";
		String serra = "Voc� gostaria de conhecer a Serra?";
		String lugaresQuentes = "Voc� gosta de lugares quentes?";
		String neve = "Voc� gosta de neve?";
		String raiz = "Voc� gostaria de viajar para fora do brasil?";
		System.out.println("\nGerando �rvore de decis�o");
		System.out.println("======================");
		newTree.criandoRaiz(1, raiz);
		newTree.AddNoSim(1, 2, lugaresQuentes);//adicionando o n� sim
		newTree.AdicionandoNoNao(1, 3, lugaresQuentes);//adicionando o n� n�o
		newTree.AddNoSim(2, 4, praia);
		newTree.AdicionandoNoNao(2, 5, neve);
		newTree.AddNoSim(3, 6, praia);
		newTree.AdicionandoNoNao(3, 7, serra);
		newTree.AddNoSim(4, 8, america);
		newTree.AdicionandoNoNao(4, 9, america);
		newTree.AddNoSim(5, 10, america);
		newTree.AdicionandoNoNao(5, 11, america);
		newTree.AddNoSim(6, 12, rs);
		newTree.AdicionandoNoNao(6, 13, rs);
		newTree.AddNoSim(7, 14, rs);
		newTree.AdicionandoNoNao(7, 15, rs);
		newTree.AddNoSim(8, 16, dinheiro);
		newTree.AdicionandoNoNao(8, 17, dinheiro);
		newTree.AddNoSim(9, 18, dinheiro);
		newTree.AdicionandoNoNao(9, 19, dinheiro);
		newTree.AddNoSim(10, 20, dinheiro);
		newTree.AdicionandoNoNao(10, 21, dinheiro);
		newTree.AddNoSim(11, 22, dinheiro);
		newTree.AdicionandoNoNao(11, 23, dinheiro);
		newTree.AddNoSim(12, 24, dinheiro);
		newTree.AdicionandoNoNao(12, 25, dinheiro);
		newTree.AddNoSim(13, 26, dinheiro);
		newTree.AdicionandoNoNao(13, 27, dinheiro);
		newTree.AddNoSim(14, 28, dinheiro);
		newTree.AdicionandoNoNao(14, 29, dinheiro);
		newTree.AddNoSim(15, 30, dinheiro);
		newTree.AdicionandoNoNao(15, 31, dinheiro);
		newTree.AddNoSim(16, 32, "Seu destino � Ibiza");//n� folhas
		newTree.AdicionandoNoNao(16, 33, "Seu destino � Gran Can�ria �frica");
		newTree.AddNoSim(17, 34, "Seu destino � Fl�rida");
		newTree.AdicionandoNoNao(17, 35, "Seu destino � Haiti");
		newTree.AddNoSim(18, 36, "Seu destino � Dubai");
		newTree.AdicionandoNoNao(18, 37, "Seu destino � Saara");
		newTree.AddNoSim(19, 38, "Seu destino � M�xico");
		newTree.AdicionandoNoNao(19, 39, "Seu destino � Venezuela");
		newTree.AddNoSim(20, 40, "Seu destino � Tallinn");
		newTree.AdicionandoNoNao(20, 41, "Seu destino � Habrin");
		newTree.AddNoSim(21, 42, "Seu destino � Canad�");
		newTree.AdicionandoNoNao(21, 43, "Seu destino � Chile");
		newTree.AddNoSim(22, 44, "Seu destino � Paris");
		newTree.AdicionandoNoNao(22, 45, "Seu destino � Lisboa");
		newTree.AddNoSim(23, 46, "Seu destino � Orlando");
		newTree.AdicionandoNoNao(23, 47, "Seu destino � Passo De Los Libres");
		newTree.AddNoSim(24, 48, "Seu destino � Fernando de Noronha");
		newTree.AdicionandoNoNao(24, 49, "Seu destino � Florian�polis");
		newTree.AddNoSim(25, 50, "Seu destino � Torres");
		newTree.AdicionandoNoNao(25, 51, "Seu destino � Tramanda�");
		newTree.AddNoSim(26, 52, "Seu destino � S�o Paulo");
		newTree.AdicionandoNoNao(26, 53, "Seu destino � Chapec�");
		newTree.AddNoSim(27, 54, "Seu destino � Pelotas");
		newTree.AdicionandoNoNao(27, 55, "Seu destino � Viam�o");
		newTree.AddNoSim(28, 56, "Seu destino � Lages");
		newTree.AdicionandoNoNao(28, 57, "Seu destino � S�o Joaquim");
		newTree.AddNoSim(29, 58, "Seu destino � Gramado");
		newTree.AdicionandoNoNao(29, 59, "Seu destino � Caxias");
		newTree.AddNoSim(30, 60, "Seu destino � Laguna");
		newTree.AdicionandoNoNao(30, 61, "Seu destino � S�o Bento");
		newTree.AddNoSim(31, 62, "Seu destino � Santa Maria");
		newTree.AdicionandoNoNao(31, 63, "Seu destino � Uruguaiana");
	}

	static void busca() throws IOException {
		System.out.println("\nQuery da �rvore de decis�o");
		System.out.println("===================");
		newTree.buscaArvore();

		sair();
	}

	static void sair() throws IOException { //m�todo para sair do sistema
		System.out.println("Sair? (digite \"sim\" ou \"nao\")");
		String answer = keyboardInput.readLine().toLowerCase();
		if (answer.equals("sim"))
			return;
		else {
			if (answer.equals("nao"))
				busca();
			else {
				System.out.println("Erro: Deve responder com \"sim\" ou \"nao\"");
				sair();
			}
		}
	}
}
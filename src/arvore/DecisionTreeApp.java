package arvore;

import java.io.*;

class DecisionTreeApp {

	static BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in)); // Entrada de dados.
	static DecisionTree newTree;

	public static void main(String[] args) throws IOException { // classe principal

		newTree = new DecisionTree(); //Instanciando a classe

		generateTree(); //Gerando a �rvore

		System.out.println("\nSa�da da �rvore"); //dados 
		System.out.println("====================");
		newTree.outputBinTree();

		queryTree();
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
		newTree.createRoot(1, raiz);
		newTree.addYesNode(1, 2, lugaresQuentes);//adicionando o n� sim
		newTree.addNoNode(1, 3, lugaresQuentes);//adicionando o n� n�o
		newTree.addYesNode(2, 4, praia);
		newTree.addNoNode(2, 5, neve);
		newTree.addYesNode(3, 6, praia);
		newTree.addNoNode(3, 7, serra);
		newTree.addYesNode(4, 8, america);
		newTree.addNoNode(4, 9, america);
		newTree.addYesNode(5, 10, america);
		newTree.addNoNode(5, 11, america);
		newTree.addYesNode(6, 12, rs);
		newTree.addNoNode(6, 13, rs);
		newTree.addYesNode(7, 14, rs);
		newTree.addNoNode(7, 15, rs);
		newTree.addYesNode(8, 16, dinheiro);
		newTree.addNoNode(8, 17, dinheiro);
		newTree.addYesNode(9, 18, dinheiro);
		newTree.addNoNode(9, 19, dinheiro);
		newTree.addYesNode(10, 20, dinheiro);
		newTree.addNoNode(10, 21, dinheiro);
		newTree.addYesNode(11, 22, dinheiro);
		newTree.addNoNode(11, 23, dinheiro);
		newTree.addYesNode(12, 24, dinheiro);
		newTree.addNoNode(12, 25, dinheiro);
		newTree.addYesNode(13, 26, dinheiro);
		newTree.addNoNode(13, 27, dinheiro);
		newTree.addYesNode(14, 28, dinheiro);
		newTree.addNoNode(14, 29, dinheiro);
		newTree.addYesNode(15, 30, dinheiro);
		newTree.addNoNode(15, 31, dinheiro);
		newTree.addYesNode(16, 32, "Seu destino � Ibiza");//n� folhas
		newTree.addNoNode(16, 33, "Seu destino � Gran Can�ria �frica");
		newTree.addYesNode(17, 34, "Seu destino � Fl�rida");
		newTree.addNoNode(17, 35, "Seu destino � Haiti");
		newTree.addYesNode(18, 36, "Seu destino � Dubai");
		newTree.addNoNode(18, 37, "Seu destino � Saara");
		newTree.addYesNode(19, 38, "Seu destino � M�xico");
		newTree.addNoNode(19, 39, "Seu destino � Venezuela");
		newTree.addYesNode(20, 40, "Seu destino � Tallinn");
		newTree.addNoNode(20, 41, "Seu destino � Habrin");
		newTree.addYesNode(21, 42, "Seu destino � Canad�");
		newTree.addNoNode(21, 43, "Seu destino � Chile");
		newTree.addYesNode(22, 44, "Seu destino � Paris");
		newTree.addNoNode(22, 45, "Seu destino � Lisboa");
		newTree.addYesNode(23, 46, "Seu destino � Orlando");
		newTree.addNoNode(23, 47, "Seu destino � Passo De Los Libres");
		newTree.addYesNode(24, 48, "Seu destino � Fernando de Noronha");
		newTree.addNoNode(24, 49, "Seu destino � Florian�polis");
		newTree.addYesNode(25, 50, "Seu destino � Torres");
		newTree.addNoNode(25, 51, "Seu destino � Tramanda�");
		newTree.addYesNode(26, 52, "Seu destino � S�o Paulo");
		newTree.addNoNode(26, 53, "Seu destino � Chapec�");
		newTree.addYesNode(27, 54, "Seu destino � Pelotas");
		newTree.addNoNode(27, 55, "Seu destino � Viam�o");
		newTree.addYesNode(28, 56, "Seu destino � Lages");
		newTree.addNoNode(28, 57, "Seu destino � S�o Joaquim");
		newTree.addYesNode(29, 58, "Seu destino � Gramado");
		newTree.addNoNode(29, 59, "Seu destino � Caxias");
		newTree.addYesNode(30, 60, "Seu destino � Laguna");
		newTree.addNoNode(30, 61, "Seu destino � S�o Bento");
		newTree.addYesNode(31, 62, "Seu destino � Santa Maria");
		newTree.addNoNode(31, 63, "Seu destino � Uruguaiana");
	}

	static void queryTree() throws IOException {
		System.out.println("\nQuery da �rvore de decis�o");
		System.out.println("===================");
		newTree.queryBinTree();

		optionToExit();
	}

	static void optionToExit() throws IOException { //m�todo para sair do sistema
		System.out.println("Sair? (digite \"sim\" ou \"nao\")");
		String answer = keyboardInput.readLine().toLowerCase();
		if (answer.equals("sim"))
			return;
		else {
			if (answer.equals("nao"))
				queryTree();
			else {
				System.out.println("Erro: Deve responder com \"sim\" ou \"nao\"");
				optionToExit();
			}
		}
	}
}
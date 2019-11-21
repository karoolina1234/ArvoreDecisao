package arvore;

import java.io.*;

class DecisionTreeApp {

	static BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in)); // Entrada de dados.
	static DecisionTree newTree;

	public static void main(String[] args) throws IOException { // classe principal

		newTree = new DecisionTree(); //Instanciando a classe

		generateTree(); //Gerando a árvore

		System.out.println("\nSaída da árvore"); //dados 
		System.out.println("====================");
		newTree.outputBinTree();

		queryTree();
	}

	static void generateTree() { //Metodo para geração da árvore
		String dinheiro = "Você tem dinheiro?";//salvando as strings em variáveis para evitar repetição de escrita
		String rs = "Você gostaria de sair do Rio Grande do Sul?";
		String america = "Você gostaria de sair da América?";
		String praia = "Você gosta de praia?";
		String serra = "Você gostaria de conhecer a Serra?";
		String lugaresQuentes = "Você gosta de lugares quentes?";
		String neve = "Você gosta de neve?";
		String raiz = "Você gostaria de viajar para fora do brasil?";
		System.out.println("\nGerando árvore de decisão");
		System.out.println("======================");
		newTree.createRoot(1, raiz);
		newTree.addYesNode(1, 2, lugaresQuentes);//adicionando o nó sim
		newTree.addNoNode(1, 3, lugaresQuentes);//adicionando o nó não
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
		newTree.addYesNode(16, 32, "Seu destino é Ibiza");//nó folhas
		newTree.addNoNode(16, 33, "Seu destino é Gran Canária África");
		newTree.addYesNode(17, 34, "Seu destino é Flórida");
		newTree.addNoNode(17, 35, "Seu destino é Haiti");
		newTree.addYesNode(18, 36, "Seu destino é Dubai");
		newTree.addNoNode(18, 37, "Seu destino é Saara");
		newTree.addYesNode(19, 38, "Seu destino é México");
		newTree.addNoNode(19, 39, "Seu destino é Venezuela");
		newTree.addYesNode(20, 40, "Seu destino é Tallinn");
		newTree.addNoNode(20, 41, "Seu destino é Habrin");
		newTree.addYesNode(21, 42, "Seu destino é Canadá");
		newTree.addNoNode(21, 43, "Seu destino é Chile");
		newTree.addYesNode(22, 44, "Seu destino é Paris");
		newTree.addNoNode(22, 45, "Seu destino é Lisboa");
		newTree.addYesNode(23, 46, "Seu destino é Orlando");
		newTree.addNoNode(23, 47, "Seu destino é Passo De Los Libres");
		newTree.addYesNode(24, 48, "Seu destino é Fernando de Noronha");
		newTree.addNoNode(24, 49, "Seu destino é Florianópolis");
		newTree.addYesNode(25, 50, "Seu destino é Torres");
		newTree.addNoNode(25, 51, "Seu destino é Tramandaí");
		newTree.addYesNode(26, 52, "Seu destino é São Paulo");
		newTree.addNoNode(26, 53, "Seu destino é Chapecó");
		newTree.addYesNode(27, 54, "Seu destino é Pelotas");
		newTree.addNoNode(27, 55, "Seu destino é Viamão");
		newTree.addYesNode(28, 56, "Seu destino é Lages");
		newTree.addNoNode(28, 57, "Seu destino é São Joaquim");
		newTree.addYesNode(29, 58, "Seu destino é Gramado");
		newTree.addNoNode(29, 59, "Seu destino é Caxias");
		newTree.addYesNode(30, 60, "Seu destino é Laguna");
		newTree.addNoNode(30, 61, "Seu destino é São Bento");
		newTree.addYesNode(31, 62, "Seu destino é Santa Maria");
		newTree.addNoNode(31, 63, "Seu destino é Uruguaiana");
	}

	static void queryTree() throws IOException {
		System.out.println("\nQuery da árvore de decisão");
		System.out.println("===================");
		newTree.queryBinTree();

		optionToExit();
	}

	static void optionToExit() throws IOException { //método para sair do sistema
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
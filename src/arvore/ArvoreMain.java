package arvore;

import java.io.*;

class ArvoreMain {

	static BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in)); // Entrada de dados.
	static ArvoreDecisao newTree;

	public static void main(String[] args) throws IOException { // classe principal

		newTree = new ArvoreDecisao(); //Instanciando a classe

		generateTree(); //Gerando a árvore

		System.out.println("\nSaída da árvore"); //dados 
		System.out.println("====================");
		newTree.SaidaArvore();

		busca();
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
		newTree.criandoRaiz(1, raiz);
		newTree.AddNoSim(1, 2, lugaresQuentes);//adicionando o nó sim
		newTree.AdicionandoNoNao(1, 3, lugaresQuentes);//adicionando o nó não
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
		newTree.AddNoSim(16, 32, "Seu destino é Ibiza");//nó folhas
		newTree.AdicionandoNoNao(16, 33, "Seu destino é Gran Canária África");
		newTree.AddNoSim(17, 34, "Seu destino é Flórida");
		newTree.AdicionandoNoNao(17, 35, "Seu destino é Haiti");
		newTree.AddNoSim(18, 36, "Seu destino é Dubai");
		newTree.AdicionandoNoNao(18, 37, "Seu destino é Saara");
		newTree.AddNoSim(19, 38, "Seu destino é México");
		newTree.AdicionandoNoNao(19, 39, "Seu destino é Venezuela");
		newTree.AddNoSim(20, 40, "Seu destino é Tallinn");
		newTree.AdicionandoNoNao(20, 41, "Seu destino é Habrin");
		newTree.AddNoSim(21, 42, "Seu destino é Canadá");
		newTree.AdicionandoNoNao(21, 43, "Seu destino é Chile");
		newTree.AddNoSim(22, 44, "Seu destino é Paris");
		newTree.AdicionandoNoNao(22, 45, "Seu destino é Lisboa");
		newTree.AddNoSim(23, 46, "Seu destino é Orlando");
		newTree.AdicionandoNoNao(23, 47, "Seu destino é Passo De Los Libres");
		newTree.AddNoSim(24, 48, "Seu destino é Fernando de Noronha");
		newTree.AdicionandoNoNao(24, 49, "Seu destino é Florianópolis");
		newTree.AddNoSim(25, 50, "Seu destino é Torres");
		newTree.AdicionandoNoNao(25, 51, "Seu destino é Tramandaí");
		newTree.AddNoSim(26, 52, "Seu destino é São Paulo");
		newTree.AdicionandoNoNao(26, 53, "Seu destino é Chapecó");
		newTree.AddNoSim(27, 54, "Seu destino é Pelotas");
		newTree.AdicionandoNoNao(27, 55, "Seu destino é Viamão");
		newTree.AddNoSim(28, 56, "Seu destino é Lages");
		newTree.AdicionandoNoNao(28, 57, "Seu destino é São Joaquim");
		newTree.AddNoSim(29, 58, "Seu destino é Gramado");
		newTree.AdicionandoNoNao(29, 59, "Seu destino é Caxias");
		newTree.AddNoSim(30, 60, "Seu destino é Laguna");
		newTree.AdicionandoNoNao(30, 61, "Seu destino é São Bento");
		newTree.AddNoSim(31, 62, "Seu destino é Santa Maria");
		newTree.AdicionandoNoNao(31, 63, "Seu destino é Uruguaiana");
	}

	static void busca() throws IOException {
		System.out.println("\nQuery da árvore de decisão");
		System.out.println("===================");
		newTree.buscaArvore();

		sair();
	}

	static void sair() throws IOException { //método para sair do sistema
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
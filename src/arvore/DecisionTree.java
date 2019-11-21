package arvore;

import java.io.*;

class DecisionTree {

	private class BinTree {

		private int nodeID; ///declaranado as variaveis
		private String questOrAns = null;
		private BinTree yesBranch = null;
		private BinTree noBranch = null;

		public BinTree(int newNodeID, String newQuestAns) { //Construtor
			nodeID = newNodeID;
			questOrAns = newQuestAns;
		}
	}

	static BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
	BinTree rootNode = null; //inicializndo a raiz com null

	public DecisionTree() {//construtor da classe
	}

	public void createRoot(int newNodeID, String newQuestAns) { //Metodo para criar a raiz
		rootNode = new BinTree(newNodeID, newQuestAns);
		System.out.println("Nó raiz criado " + newNodeID);
	}

	public void addYesNode(int existingNodeID, int newNodeID, String newQuestAns) { //metodo para criar o galho SIM

		if (rootNode == null) {
			System.out.println("Erro: Não existe no raiz!");
			return;
		}

		if (searchTreeAndAddYesNode(rootNode, existingNodeID, newNodeID, newQuestAns)) {
			System.out.println("Nó " + newNodeID + " adicionado no galho \"sim\" do nó " + existingNodeID);
		} else
			System.out.println("Nó " + existingNodeID + " não encontrado");
	}

	private boolean searchTreeAndAddYesNode(BinTree currentNode, int existingNodeID, int newNodeID,
			String newQuestAns) {
		if (currentNode.nodeID == existingNodeID) {

			if (currentNode.yesBranch == null)
				currentNode.yesBranch = new BinTree(newNodeID, newQuestAns);
			else {
				System.out.println("AVISO : Sobrescrevendo o nó anterior " + "(id = " + currentNode.yesBranch.nodeID
						+ ")Linkado com o galho sim do nó " + existingNodeID);
				currentNode.yesBranch = new BinTree(newNodeID, newQuestAns);
			}
			return (true);
		} else {

			if (currentNode.yesBranch != null) {
				if (searchTreeAndAddYesNode(currentNode.yesBranch, existingNodeID, newNodeID, newQuestAns)) {
					return (true);
				} else {

					if (currentNode.noBranch != null) {
						return (searchTreeAndAddYesNode(currentNode.noBranch, existingNodeID, newNodeID, newQuestAns));
					} else
						return (false);
				}
			}
			return (false);
		}
	}

	public void addNoNode(int existingNodeID, int newNodeID, String newQuestAns) { //funcao adicionar no não

		if (rootNode == null) {
			System.out.println("ERRO: não existe raiz!");
			return;
		}

		// Search tree

		if (searchTreeAndAddNoNode(rootNode, existingNodeID, newNodeID, newQuestAns)) {
			System.out.println("Adicionando no " + newNodeID + " \"Nao\" no galho do nó " + existingNodeID);
		} else
			System.out.println("Nó " + existingNodeID + " não foi encontrado");
	}

	private boolean searchTreeAndAddNoNode(BinTree currentNode, int existingNodeID, int newNodeID, String newQuestAns) {
		if (currentNode.nodeID == existingNodeID) {

			if (currentNode.noBranch == null)
				currentNode.noBranch = new BinTree(newNodeID, newQuestAns);
			else {
				System.out.println("Aviso: Sobrescrevendo no anterior " + "(id = " + currentNode.noBranch.nodeID
						+ ") linkado com o galho do nó " + existingNodeID);
				currentNode.noBranch = new BinTree(newNodeID, newQuestAns);
			}
			return (true);
		} else {

			if (currentNode.yesBranch != null) {
				if (searchTreeAndAddNoNode(currentNode.yesBranch, existingNodeID, newNodeID, newQuestAns)) {
					return (true);
				} else {

					if (currentNode.noBranch != null) {
						return (searchTreeAndAddNoNode(currentNode.noBranch, existingNodeID, newNodeID, newQuestAns));
					} else
						return (false);
				}
			} else
				return (false);
		}
	}

	public void queryBinTree() throws IOException {
		queryBinTree(rootNode);
	}

	private void queryBinTree(BinTree currentNode) throws IOException {

		if (currentNode.yesBranch == null) {
			if (currentNode.noBranch == null)
				System.out.println(currentNode.questOrAns);
			else
				System.out.println("ERRO: Faltando o galho sim" + currentNode.questOrAns + "\" question");
			return;
		}
		if (currentNode.noBranch == null) {
			System.out.println("ERRO: Faltando o galho não" + currentNode.questOrAns + "\" question");
			return;
		}

		askQuestion(currentNode);
	}

	private void askQuestion(BinTree currentNode) throws IOException {
		System.out.println(currentNode.questOrAns + " (digite \"sim\" ou \"nao\")");
		String answer = keyboardInput.readLine().toLowerCase();
		if (answer.equals("sim"))
			queryBinTree(currentNode.yesBranch);
		else {
			if (answer.equals("nao"))
				queryBinTree(currentNode.noBranch);
			else {
				System.out.println("ERRO: deve responder com \"sim\" ou \"nao\"");
				askQuestion(currentNode);
			}
		}
	}

	public void outputBinTree() {

		outputBinTree("1", rootNode);
	}

	private void outputBinTree(String tag, BinTree currentNode) {

		if (currentNode == null)
			return;

		System.out.println(
				"[" + tag + "] nodeID = " + currentNode.nodeID + ", questão/resposta = " + currentNode.questOrAns);

		outputBinTree(tag + ".1", currentNode.yesBranch);

		outputBinTree(tag + ".2", currentNode.noBranch);
	}
}
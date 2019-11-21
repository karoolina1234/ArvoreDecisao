package arvore;

import java.io.*;

class ArvoreDecisao {

	private class BinArvore {

		private int nodeID; ///declaranado as variaveis
		private String questoes = null;
		private BinArvore Sim = null;
		private BinArvore Nao = null;

		public BinArvore(int novoId, String NovaQuestao) { //Construtor
			nodeID = novoId;
			questoes = NovaQuestao;
		}
	}

	static BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
	BinArvore RaizNo = null; //inicializndo a raiz com null

	public ArvoreDecisao() {//construtor da classe
	}

	public void criandoRaiz(int novoId, String novaQuestao) { //Metodo para criar a raiz
		RaizNo = new BinArvore(novoId, novaQuestao);
		System.out.println("Nó raiz criado " + novoId);
	}

	public void AddNoSim(int noExistente, int novoNo, String novaQuestao) { //metodo para criar o galho SIM

		if (RaizNo == null) {
			System.out.println("Erro: Não existe no raiz!");
			return;
		}

		if (BuscaArvoreAddNoSim(RaizNo, noExistente, novoNo, novaQuestao)) {
			System.out.println("Nó " + novoNo + " adicionado no galho \"sim\" do nó " + noExistente);
		} else
			System.out.println("Nó " + noExistente + " não encontrado");
	}

	private boolean BuscaArvoreAddNoSim(BinArvore noAtual, int noExistenteID, int novoNoId,
			String novaPergunta) {
		if (noAtual.nodeID == noExistenteID) {

			if (noAtual.Sim == null)
				noAtual.Sim = new BinArvore(novoNoId, novaPergunta);
			else {
				System.out.println("AVISO : Sobrescrevendo o nó anterior " + "(id = " + noAtual.Sim.nodeID
						+ ")Linkado com o galho sim do nó " + noExistenteID);
				noAtual.Sim = new BinArvore(novoNoId, novaPergunta);
			}
			return (true);
		} else {

			if (noAtual.Sim != null) {
				if (BuscaArvoreAddNoSim(noAtual.Sim, noExistenteID, novoNoId, novaPergunta)) {
					return (true);
				} else {

					if (noAtual.Nao != null) {
						return (BuscaArvoreAddNoSim(noAtual.Nao, noExistenteID, novoNoId, novaPergunta));
					} else
						return (false);
				}
			}
			return (false);
		}
	}

	public void AdicionandoNoNao(int noExistenteId, int novoNoID, String novaPergunta) { //funcao adicionar no não

		if (RaizNo == null) {
			System.out.println("ERRO: não existe raiz!");
			return;
		}

		// Search tree

		if (BuscaArvoreEaddNoNao(RaizNo, noExistenteId, novoNoID, novaPergunta)) {
			System.out.println("Adicionando no " + novoNoID + " \"Nao\" no galho do nó " + noExistenteId);
		} else
			System.out.println("Nó " + noExistenteId + " não foi encontrado");
	}

	private boolean BuscaArvoreEaddNoNao(BinArvore noAtual, int noExistente, int novoNoID, String novaPergunta) {
		if (noAtual.nodeID == noExistente) {

			if (noAtual.Nao == null)
				noAtual.Nao = new BinArvore(novoNoID, novaPergunta);
			else {
				System.out.println("Aviso: Sobrescrevendo no anterior " + "(id = " + noAtual.Nao.nodeID
						+ ") linkado com o galho do nó " + noExistente);
				noAtual.Nao = new BinArvore(novoNoID, novaPergunta);
			}
			return (true);
		} else {

			if (noAtual.Sim != null) {
				if (BuscaArvoreEaddNoNao(noAtual.Sim, noExistente, novoNoID, novaPergunta)) {
					return (true);
				} else {

					if (noAtual.Nao != null) {
						return (BuscaArvoreEaddNoNao(noAtual.Nao, noExistente, novoNoID, novaPergunta));
					} else
						return (false);
				}
			} else
				return (false);
		}
	}

	public void buscaArvore() throws IOException {
		buscaArvore(RaizNo);
	}

	private void buscaArvore(BinArvore noAtual) throws IOException {

		if (noAtual.Sim == null) {
			if (noAtual.Nao == null)
				System.out.println(noAtual.questoes);
			else
				System.out.println("ERRO: Faltando o galho sim" + noAtual.questoes + "\" question");
			return;
		}
		if (noAtual.Nao == null) {
			System.out.println("ERRO: Faltando o galho não" + noAtual.questoes + "\" question");
			return;
		}

		FazerPergunta(noAtual);
	}

	private void FazerPergunta(BinArvore noAtual) throws IOException {
		System.out.println(noAtual.questoes + " (digite \"sim\" ou \"nao\")");
		String answer = keyboardInput.readLine().toLowerCase();
		if (answer.equals("sim"))
			buscaArvore(noAtual.Sim);
		else {
			if (answer.equals("nao"))
				buscaArvore(noAtual.Nao);
			else {
				System.out.println("ERRO: deve responder com \"sim\" ou \"nao\"");
				FazerPergunta(noAtual);
			}
		}
	}

	public void SaidaArvore() {

		SaidaDaArvore("1", RaizNo);
	}

	private void SaidaDaArvore(String tag, BinArvore noAtual) {

		if (noAtual == null)
			return;

		System.out.println(
				"[" + tag + "] nodeID = " + noAtual.nodeID + ", questão/resposta = " + noAtual.questoes);

		SaidaDaArvore(tag + ".1", noAtual.Sim);

		SaidaDaArvore(tag + ".2", noAtual.Nao);
	}
}
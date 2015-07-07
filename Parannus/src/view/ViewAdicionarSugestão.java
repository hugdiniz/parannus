package view;

import model.entity.Solicitacao;
import model.service.ServiceHandler;
import model.vo.SolicitacaoVO;

public class ViewAdicionarSugestão {
	public ViewAdicionarSugestão() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Solicitacao solicitacao = (Solicitacao) ServiceHandler.getInstance().recuperarSolicitacaos(new SolicitacaoVO()).iterator().next();
		System.out.println(solicitacao.getSugestao());
	}

}

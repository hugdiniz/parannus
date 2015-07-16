package view;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Collection;

import model.dao.DAO;
import model.entity.Solicitacao;
import model.entity.abstractClass.*;
import model.service.ServiceHandler;
import model.vo.SolicitacaoVO;

public class ViewAdicionarSugestão {
	public ViewAdicionarSugestão() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		//Solicitacao solicitacao = (Solicitacao) ServiceHandler.getInstance().recuperarSolicitacaos(new SolicitacaoVO()).iterator().next();
		//System.out.println(solicitacao.toString());
		//System.out.println(solicitacao.toString().replaceAll("\",\"", "\"%\""));
		//DAO.getInstance().insertOrUpdate(solicitacao);
		SolicitacaoVO solicitacaoVO = new SolicitacaoVO();
		solicitacaoVO.setId(new Long(1));
		Collection solucaos = DAO.getInstance().search(solicitacaoVO, Solicitacao.class);
		System.out.println(DAO.getInstance().search(solicitacaoVO, Solicitacao.class));
		
		System.out.println(DAO.getInstance().search(new SolicitacaoVO(), Solicitacao.class));
		//System.out.println(Entity.createEntity(solicitacao.toString(), new Long(1), Solicitacao.class));
	}

}

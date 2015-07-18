package controller;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Collection;

import model.dao.DAO;
import model.entity.Objetivo;
import model.entity.Solicitacao;
import model.entity.abstractClass.*;
import model.enumerado.PerfilEnum;
import model.exception.LoginException;
import model.exception.ServiceException;
import model.exception.UsuarioException;
import model.service.LoginHandler;
import model.service.ServiceHandler;
import model.vo.ObjetivoVO;
import model.vo.SolicitacaoVO;
import model.vo.UsuarioVO;

public class ViewAdicionarSugestão 
{
	public ViewAdicionarSugestão()
	{
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ServiceException, UsuarioException, LoginException 
	{
		//Solicitacao solicitacao = (Solicitacao) ServiceHandler.getInstance().recuperarSolicitacaos(new SolicitacaoVO()).iterator().next();
		//System.out.println(solicitacao.toString());
		//System.out.println(solicitacao.toString().replaceAll("\",\"", "\"%\""));
		//ServiceHandler.getInstance().manterSolicitacao(new Solicitacao("bla","Nenhum","Inutil"));
		//SolicitacaoVO solicitacaoVO = new SolicitacaoVO();
		//solicitacaoVO.setId(new Long(1));
		//Solicitacao solicitacao = ServiceHandler.getInstance().recuperarSolicitacao(solicitacaoVO);
		
		//System.out.println(DAO.getInstance().search(solicitacaoVO, Solicitacao.class));
		
		//System.out.println(DAO.getInstance().search(new SolicitacaoVO(), Solicitacao.class));
		//System.out.println(Entity.createEntity(solicitacao.toString(), new Long(1), Solicitacao.class));
		//Objetivo objetivo =new Objetivo("Teste um");
		//Objetivo objetivo = ServiceHandler.getInstance().recuperarObjetivo(new ObjetivoVO());
		//ServiceHandler.getInstance().manterObjetivo(objetivo);
		
		//SolicitacaoVO solicitacaoVO = new SolicitacaoVO();
		//solicitacaoVO.setId(new Long(1));
		//Solicitacao solicitacao = ServiceHandler.getInstance().recuperarSolicitacao(solicitacaoVO);
		//solicitacao.addObjetivo(objetivo);
		//ServiceHandler.getInstance().manterSolicitacao(solicitacao);
		
		UsuarioVO usuarioVO = new UsuarioVO();
		usuarioVO.setSenha("focafoca");
		usuarioVO.setLogin("admin");
		usuarioVO.setPerfil(PerfilEnum.GERENTE);
		usuarioVO.setNome("Desenvolvedor");
		LoginHandler.getInstance().criarUsuario(usuarioVO);
	}

}

package teste.unitario;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.entity.Objetivo;
import model.entity.Solicitacao;
import model.exception.SolicitacaoException;

public class SolicitacaoTest {

	@Test
	public void testSolicitacaoStringStringString() {
		
		Solicitacao solicitacao = new Solicitacao("Melhoria na documentação", "Alto", "Melhoria");
				
		assertNotNull("Erro Nulo", solicitacao);
		assertNotNull("Erro Nulo", solicitacao.getImpacto());
		assertEquals("Alto", solicitacao.getImpacto());
		assertNotNull("Erro Nulo", solicitacao.getSugestao());
		assertEquals("Melhoria na documentação", solicitacao.getSugestao());
		assertNotNull("Erro Nulo", solicitacao.getTipo());
		assertEquals("Melhoria", solicitacao.getTipo());
	}

	@Test
	public void testSolicitacaoStringStringStringLong() {
		
		Solicitacao solicitacao = new Solicitacao("Melhoria na documentação", "Alto", "Melhoria",new Long(12));
		
		assertNotNull("Erro Nulo", solicitacao);
		assertNotNull("Erro Nulo", solicitacao.getImpacto());
		assertEquals("Alto", solicitacao.getImpacto());
		assertNotNull("Erro Nulo", solicitacao.getSugestao());
		assertEquals("Melhoria na documentação", solicitacao.getSugestao());
		assertNotNull("Erro Nulo", solicitacao.getTipo());
		assertEquals("Melhoria", solicitacao.getTipo());
		assertNotNull("Erro Nulo", solicitacao.getId());
		assertEquals(new Long(12), solicitacao.getId());
	}

	@Test
	public void testSolicitacao() {
		Solicitacao solicitacao = new Solicitacao();
		assertNotNull("Erro Nulo", solicitacao);
	}

	@Test
	public void testGetObjetivos() {
		
		Objetivo objetivo = new Objetivo("Melhorar caso de uso");
		assertNotNull("Erro Nulo", objetivo);
		assertEquals("Melhorar caso de uso", objetivo.getObjetivoNome());
	}

	@Test
	public void testAddObjetivo() throws SolicitacaoException {
		
		Solicitacao solicitacao = new Solicitacao("Melhoria na documentação", "Alto", "Melhoria");
		Objetivo objetivo = new Objetivo("Melhorar caso de uso");
		solicitacao.addObjetivo(objetivo);
		ArrayList list =  (ArrayList) solicitacao.getObjetivos();
		
		assertFalse(list.isEmpty());
	}


}

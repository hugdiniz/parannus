package teste.unitario;

import static org.junit.Assert.*;

import org.junit.Test;

import model.entity.Objetivo;

public class ObjetivoTest {

	@Test
	public void testObjetivo() {
		
		Objetivo objetivo = new Objetivo("Melhorar caso de uso");
		assertNotNull("Erro Nulo", objetivo);
	}

	@Test
	public void testGetObjetivoNome() {
		
		Objetivo objetivo = new Objetivo("Melhorar caso de uso");
		assertNotNull("Erro Nulo", objetivo);
		assertEquals("Melhorar caso de uso", objetivo.getObjetivoNome());
	}

}

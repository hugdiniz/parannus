package teste.unitario;

import static org.junit.Assert.*;

import org.junit.Test;

import model.entity.Objetivo;
import model.entity.Usuario;
import model.enumerado.PerfilEnum;
import model.exception.UsuarioException;
import model.vo.UsuarioVO;

public class UsuarioTest {

	@Test
	public void testUsuario() {
		
		Usuario usuario = new Usuario("Claudio", "Parannus123","Claudio Silva", PerfilEnum.GERENTE);
		assertNotNull("Erro Nulo", usuario);
		assertEquals("Claudio Silva", usuario.getNome());
	}

	@Test
	public void testValidarCriptografarSenha() throws UsuarioException {
		
		
		UsuarioVO usuarioVO = new UsuarioVO();
		usuarioVO.setLogin("ParannusUsuario");
		usuarioVO.setSenha("Parannus123");
		assertNotNull("Erro Nulo", usuarioVO);
		assertEquals("138a5b1376daaf7021876cd57431f5b2", Usuario.validarCriptografarSenha(usuarioVO));
		
		
	}
	@Test
	public void testValidarSenhaInvalida(){
		
		
		UsuarioVO usuarioVO = new UsuarioVO();
		usuarioVO.setLogin("ParannusUsuario");
		usuarioVO.setSenha("Par");
		assertNotNull("Erro Nulo", usuarioVO);
		try 
		{
			assertEquals("cb6c0944022191538e11ec9cbda20ab5", Usuario.validarCriptografarSenha(usuarioVO));
			fail("Validado sem ser valida");
		} 
		catch (UsuarioException e) 
		{
			assertEquals("erro.usuario.senha.invalida",e.getMessage());			
		}
		
		
	}

	@Test
	public void testGetSenha() {
		
		Usuario usuario = new Usuario("Claudio", "Parannus123","Claudio Silva", PerfilEnum.GERENTE);
		assertNotNull("Erro Nulo", usuario);
		assertEquals("Parannus123", usuario.getSenha());
	}
	

	@Test
	public void testGetNome() {
		
		Usuario usuario = new Usuario("Claudio", "Parannus123","Claudio Silva", PerfilEnum.GERENTE);
		assertNotNull("Erro Nulo", usuario);
		assertEquals("Claudio Silva", usuario.getNome());
	}

	@Test
	public void testGetLogin() {
		
		Usuario usuario = new Usuario("Claudio", "Parannus123","Claudio Silva", PerfilEnum.GERENTE);
		assertNotNull("Erro Nulo", usuario);
		assertEquals("Claudio", usuario.getLogin());
	}

	@Test
	public void testGetPerfil() {
		
		Usuario usuario = new Usuario("Claudio", "Parannus123","Claudio Silva", PerfilEnum.GERENTE);
		assertNotNull("Erro Nulo", usuario);
		assertEquals(PerfilEnum.GERENTE, usuario.getPerfil());
	}

}

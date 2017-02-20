package Usuario;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Exceptions.JogoInvalido;
import Exceptions.NomeInvalido;
import Exceptions.ValorInvalido;
import Usuario.Veterano;
import Usuario.Usuario;

public class VeteranoTest {
	
	private Usuario usuario;
	
	@Before
	public void iniciando() throws NomeInvalido{
		usuario = new Veterano("José Ferreira", "jose.ferreira");
	}

	@Test
	public void testComprarJogo() {
		try{
			usuario.comprarJogo(null);
			Assert.fail("Excecao nao capturada");
		}catch(JogoInvalido e){
			Assert.assertEquals("Jogo Inválido!", e.getMessage());
		}
	}

	@Test
	public void testVeterano() {
		try{
			Usuario teste = new Veterano("", "");
			Assert.fail("Excecao nao capturada");
		}catch(NomeInvalido e){
			Assert.assertEquals("Nome ou Login inválido!", e.getMessage());
		}
		try{
			Usuario teste = new Veterano("", "jose");
			Assert.fail("Excecao nao capturada");
		}catch(NomeInvalido e){
			Assert.assertEquals("Nome ou Login inválido!", e.getMessage());
		}
		try{
			Usuario teste = new Veterano("joaquim", "");
			Assert.fail("Excecao nao capturada");
		} catch (NomeInvalido e) {
			Assert.assertEquals("Nome ou Login inválido!", e.getMessage());
		}
		try{
			Usuario teste = new Veterano("joaquim", "joaquim");
		} catch (NomeInvalido e) {
			Assert.assertEquals("Nome ou Login inválido!", e.getMessage());
		}
	}

	@Test
	public void testadicionaQuantia() {
		try{
			usuario.adicionarQuantia(0);
			Assert.fail("Excecao nao capturada");
		}catch(ValorInvalido e){
			Assert.assertEquals("Valor menor ou igual a zero não permitidio!", e.getMessage());
		}
		try{
			usuario.adicionarQuantia(-2);
			Assert.fail("Excecao nao capturada");
		}catch(ValorInvalido e){
			Assert.assertEquals("Valor menor ou igual a zero não permitidio!", e.getMessage());
		}
		try{
			usuario.adicionarQuantia(5);
		}catch(ValorInvalido e){
			Assert.fail("Excecao capturada sem motivo");
		}
	}

	@Test
	public void testRegistrarJogada() {
		try{
			usuario.registrarJogada("", 0, false);
			Assert.fail("Excecao nao capturada");
		}catch(NomeInvalido e){
			Assert.assertEquals("Nome do jogo inválido!", e.getMessage());
		}catch(ValorInvalido e){
			Assert.fail("Excecao NomeInvalido nao capturada");
		}
		try{
			usuario.registrarJogada("dota2", 0, false);
			Assert.fail("Excecao nao capturada");
		}catch(NomeInvalido e){
			Assert.fail("Excecao ValorInvalido nao capturada");
		}catch(ValorInvalido e){
			Assert.assertEquals("Score menor ou igual a zero!", e.getMessage());
		}
		try{
			usuario.registrarJogada("dota2", 4, false);
			
		}catch(NomeInvalido e){
			Assert.fail("Excecao capturada sem motivo");
		}catch(ValorInvalido e){
			Assert.fail("Excecao capturada sem motivo");
		}
	}
}


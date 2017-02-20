package Jogo;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import Exceptions.JogabilidadeInvalida;
import Exceptions.NomeInvalido;
import Exceptions.ValorInvalido;

public class TestRPG {
	
	private Jogo jogo;
	private Set<Jogabilidade> jogabilidade;
	
	@Before
	public void setUp() throws NomeInvalido, ValorInvalido, JogabilidadeInvalida {
		jogabilidade = new HashSet<>();
		jogabilidade.add(Jogabilidade.ONLINE);
		jogabilidade.add(Jogabilidade.MULTIPLAYER);
		RPG rpg = new RPG("Dota2", 1.99, jogabilidade);
		jogo = rpg;
	}

	@Test
	public void testRegistraJogada() {
		
	}

	@Test
	public void testRPG() {
		fail("Not yet implemented");
	}

}

package Jogo;

import Exceptions.NomeInvalido;
import Exceptions.ValorInvalido;

public class RPG extends Jogo{

	public RPG(String nome, double preco) throws NomeInvalido, ValorInvalido{
		super (nome, preco);
	}

	@Override
	public int registraJogada(int score, boolean concluiu) {
		// TODO Auto-generated method stub
		return 0;
	}

}

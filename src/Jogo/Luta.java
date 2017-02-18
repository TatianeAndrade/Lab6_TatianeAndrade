package Jogo;

import Exceptions.NomeInvalido;
import Exceptions.ValorInvalido;

public class Luta extends Jogo{

	public Luta(String nome, double preco) throws NomeInvalido, ValorInvalido{
		super (nome, preco);
	}

	@Override
	public int registraJogada(int score, boolean concluiu) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

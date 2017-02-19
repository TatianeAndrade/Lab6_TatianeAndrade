package Jogo;

import Exceptions.NomeInvalido;
import Exceptions.ValorInvalido;

public class Luta extends Jogo{
	
	private int x2pExtra;

	public Luta(String nome, double preco) throws NomeInvalido, ValorInvalido{
		super (nome, preco);
		x2pExtra = 0;
	}

	@Override
	public int registraJogada(int score, boolean concluiu) throws ValorInvalido {
		if (score <= 0){
			throw new ValorInvalido("Score menor ou igual a zero!");
		}else if (score > this.scoreMaximo){
			this.scoreMaximo = score;
			x2pExtra = score/1000;
		}
		this.quantidadeDeJogadas += 1;
		if (concluiu){
			this.jogadasZeradas += 1;
		}
		return x2pExtra;
	}
	
}

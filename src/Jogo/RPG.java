package Jogo;

import java.util.Set;

import Exceptions.JogabilidadeInvalida;
import Exceptions.NomeInvalido;
import Exceptions.ValorInvalido;

public class RPG extends Jogo{
	
	private int x2pExtra;

	public RPG(String nome, double preco, Set<Jogabilidade> jogabilidade) throws NomeInvalido, ValorInvalido, JogabilidadeInvalida{
		super (nome, preco, jogabilidade);
		x2pExtra = 10;
	}

	@Override
	public int registraJogada(int score, boolean concluiu) throws ValorInvalido {
		if (score <= 0){
			throw new ValorInvalido("Score menor ou igual a zero!");
		}else if (score > this.scoreMaximo){
			this.scoreMaximo = score;			
		}
		this.quantidadeDeJogadas += 1;
		if (concluiu){
			this.jogadasZeradas += 1;
		}
		return x2pExtra;
	}

	@Override
	public String toString() {
		String string = "";
		String separador = System.lineSeparator();
		string += "+ " + getNome() + " - RPG:" + separador;
		string += "==> Jogou " + getQuantidadeDeJogadas() + " vez(es)" + separador;
		string += "==> Zerou " + getJogadasZeradas() + " vez(es)" + separador;
		string += "==> Maior score: " + getScoreMaximo() + separador;
		return string;
	}

}

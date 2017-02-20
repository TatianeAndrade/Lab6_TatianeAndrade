package Usuario;

import java.util.ArrayList;

import Exceptions.JogoInvalido;
import Exceptions.NomeInvalido;
import Jogo.Jogo;

public class Veterano extends Usuario{
	
	public Veterano(String nome, String login) throws NomeInvalido {
		super (nome, login);
		x2p = 1000;
	}
	
	public Veterano (String nome, String login, int x2p, double quantia, ArrayList<Jogo> jogos) throws NomeInvalido{
		super (nome, login);
		this.jogos = jogos;
		this.quantia = quantia;
		this.x2p = x2p;
	}

	@Override
	public void comprarJogo(Jogo jogo) throws JogoInvalido {
		if (jogo == null){
			throw new JogoInvalido("Jogo Inválido!");
		}else if (jogos.contains(jogo)){
			throw new JogoInvalido("Usuário já possui o jogo informado!");
		}else if (jogo.getPreco() >= this.quantia){
				jogos.add(jogo);
				this.quantia -= (jogo.getPreco() - jogo.getPreco() * 0.20);
				x2p += (15 * jogo.getPreco());
		}
	}

	@Override
	public String toString() {
		String string = "";
		String separador = System.lineSeparator();
		string += getLogin() + separador;
		string += getNome() + " - Jogador Veterano" + separador;
		string += "Lista de Jogos:" + separador;
		for (Jogo jogo : jogos) {
			string += jogo.toString() + separador;
		}
		string += separador;
		string += "Total de preço dos jogos: R$ " + totalDeJogos() + separador;
		return string;
	}
}

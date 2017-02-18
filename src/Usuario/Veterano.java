package Usuario;

import Exceptions.JogoInvalido;
import Exceptions.NomeInvalido;
import Jogo.Jogo;

public class Veterano extends Usuario{
	
	public Veterano(String nome, String login) throws NomeInvalido {
		super (nome, login);
		x2p = 1000;
	}

	@Override
	public void comprarJogo(Jogo jogo) throws JogoInvalido {
		if (jogo == null){
			throw new JogoInvalido("Jogo Inválido!");
		}else if (jogo.getPreco() >= this.quantia){
				jogos.add(jogo);
				this.quantia -= (jogo.getPreco() - jogo.getPreco() * 0.20);
				x2p += (15 * jogo.getPreco());
		}
	}
}

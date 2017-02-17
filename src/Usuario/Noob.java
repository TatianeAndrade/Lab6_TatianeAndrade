package Usuario;

import Exceptions.JogoInvalido;
import Exceptions.NomeInvalido;
import Jogo.Jogo;

public class Noob extends Usuario{
	
	public Noob(String nome) throws NomeInvalido {
		super(nome);
		x2p = 0;
	}

	@Override
	public void comprarJogo(Jogo jogo) throws JogoInvalido {
		if (jogo == null){
			throw new JogoInvalido("Jogo Inválido!");
		}else if (jogo.getPreco() >= this.quantia){
				jogos.add(jogo);
				this.quantia -= (jogo.getPreco() - jogo.getPreco() * 0.10);
				x2p += (10 * jogo.getPreco());
		}
	}	
}

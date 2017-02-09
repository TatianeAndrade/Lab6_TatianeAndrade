
public class Noob extends Usuario{

	
	public Noob(String nome) {
		super(nome);
	}

	@Override
	public void comprarJogo(Jogo jogo) {
		if (jogo.getPreco() >= this.quantia){
				jogos.add(jogo);
				quantia -= (jogo.getPreco() - jogo.getPreco() * 0.10);
		}
	}

}

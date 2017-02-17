package Usuario;
import java.util.ArrayList;

import Exceptions.JogoInvalido;
import Exceptions.NomeInvalido;
import Jogo.Jogo;



public abstract class Usuario {
	
	protected String nome;
	protected ArrayList<Jogo> jogos;
	protected double quantia;
	protected int x2p;

	public Usuario(String nome) throws NomeInvalido{
		if (nome.trim().equals("") || nome == null){
			throw new NomeInvalido("Nome vazio ou null!");
		}
		this.nome = nome;
		this.jogos = new ArrayList<>();
		this.quantia = 0;
	}
	
	public abstract void comprarJogo(Jogo jogo) throws JogoInvalido;
	
	public void registraJogada(String nomeDoJogo, int score, boolean zerou){
		for (Jogo jogo : jogos) {
			if (jogo.equals(nomeDoJogo))
				x2p += jogo.registraJogada(score, zerou);
		}
	}

	public void adicionarQuantia(double quantia){
		this.quantia += quantia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jogos == null) ? 0 : jogos.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (jogos == null) {
			if (other.jogos != null)
				return false;
		} else if (!jogos.equals(other.jogos))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}


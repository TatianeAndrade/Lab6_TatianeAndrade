package Usuario;
import java.util.ArrayList;

import Exceptions.JogoInvalido;
import Exceptions.NomeInvalido;
import Exceptions.ValorInvalido;
import Jogo.Jogo;

public abstract class Usuario {
	
	protected String nome;
	protected ArrayList<Jogo> jogos;
	protected double quantia;
	protected int x2p;
	protected String login;

	public Usuario(String nome, String login) throws NomeInvalido{
		if (nome.trim().equals("") || nome == null){
			throw new NomeInvalido("Nome ou Login inválido!");
		}
		this.nome = nome;
		this.jogos = new ArrayList<>();
		this.quantia = 0;
	}
	
	public abstract void comprarJogo(Jogo jogo) throws JogoInvalido;
	
	public void registraJogada(String nomeDoJogo, int score, boolean zerou) throws NomeInvalido, ValorInvalido{
		if (nomeDoJogo.trim().equals("") || nomeDoJogo == null){
			throw new NomeInvalido("Nome do jogo inválido!");
		}else if (score <= 0){
			throw new ValorInvalido("Score menor ou igual a zero!");
		}
		for (Jogo jogo : jogos) {
			if (jogo.equals(nomeDoJogo))
				x2p += jogo.registraJogada(score, zerou);
		}
	}

	public void adicionarQuantia(double quantia){
		this.quantia += quantia;
	}
	
	public String getNome() {
		return nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
	
}


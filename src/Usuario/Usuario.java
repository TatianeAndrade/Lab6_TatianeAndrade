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
		if (nome.trim().equals("") || nome == null || login.trim().equals("") || login == null){
			throw new NomeInvalido("Nome ou Login inválido!");
		}
		this.nome = nome;
		this.login = login;
		this.jogos = new ArrayList<>();
		this.quantia = 0;
	}
	
	public abstract void comprarJogo(Jogo jogo) throws JogoInvalido;
	
	public void registrarJogada(String nomeDoJogo, int score, boolean zerou) throws NomeInvalido, ValorInvalido{
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

	public void adicionarQuantia(double quantia) throws ValorInvalido{
		if (quantia <= 0){
			throw new ValorInvalido("Valor menor ou igual a zero não permitidio!");
		}
		this.quantia += quantia;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getLogin() {
		return login;
	}
	
	public int getX2p(){
		return x2p;
	}
	
	public ArrayList<Jogo> getJogos() {
		return jogos;
	}

	public double getQuantia() {
		return quantia;
	}

	public double totalDeJogos(){
		double total = 0;
		for (Jogo jogo : jogos) {
			total += jogo.getPreco();
		} 
		return total;
	}

	@Override
	public abstract String toString();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
			if(!(obj instanceof Usuario))
				return false;
			Usuario novo = (Usuario) obj;
			return novo.getLogin().equals(getLogin());
	}
	
}


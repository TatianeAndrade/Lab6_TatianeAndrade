package Jogo;

import java.util.Set;

import Exceptions.JogabilidadeInvalida;
import Exceptions.NomeInvalido;
import Exceptions.ValorInvalido;

public abstract class Jogo {
	
	private String nome;
	private double preco;
	protected int scoreMaximo;
	protected int quantidadeDeJogadas;
	protected int jogadasZeradas;
	protected Set<Jogabilidade> jogabilidade;

	public Jogo(String nome, double preco, Set<Jogabilidade> jogailidade) throws NomeInvalido, ValorInvalido, JogabilidadeInvalida{
		if (nome.trim().equals("") || nome == null){
			throw new NomeInvalido("Nome vazio ou null!");
		} else if (preco <= 0){
			throw new ValorInvalido("Preço menor ou igual a zero!");
		}
		if (jogabilidade == null){
			throw new JogabilidadeInvalida("Jogabilidade inválida!");
		}
		this.nome = nome;
		this.preco = preco;
		this.scoreMaximo = 0;
		this.quantidadeDeJogadas = 0;
		this.jogadasZeradas = 0;
		this.jogabilidade = jogabilidade;
		
	}
	
	public abstract int registraJogada (int score, boolean concluiu) throws ValorInvalido;

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}
	
	public int getScoreMaximo() {
		return scoreMaximo;
	}

	public int getQuantidadeDeJogadas() {
		return quantidadeDeJogadas;
	}

	public int getJogadasZeradas() {
		return jogadasZeradas;
	}

	@Override
	public abstract String toString();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Jogo))
			return false;
		Jogo novo = (Jogo) obj;
		return novo.getNome().equals(getNome());
	}
		
}

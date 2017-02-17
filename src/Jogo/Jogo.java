package Jogo;

import Exceptions.NomeInvalido;
import Exceptions.PrecoInvalido;

public class Jogo {
	
	private String nome;
	private double preco;
	private int score;
	private int quantidadeDeJogadas;
	private int jogadasZeradas;

	public Jogo(String nome, double preco) throws NomeInvalido, PrecoInvalido{
		if (nome.trim().equals("") || nome == null){
			throw new NomeInvalido("Nome vazio ou null!");
		} else if (preco <= 0){
			throw new PrecoInvalido("Preço menor ou igual a zero!");
		}
		this.nome = nome;
		this.preco = preco;
		this.score = 0;
		this.quantidadeDeJogadas = 0;
		this.jogadasZeradas = 0;		
	}
	
	public int registraJogada (int score, boolean concluiu){
		int xp = 0;
		return xp;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getScore() {
		return score;
	}

	public int getQuantidadeDeJogadas() {
		return quantidadeDeJogadas;
	}

	public int getJogadasZeradas() {
		return jogadasZeradas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Jogo))
			return false;
		Jogo other = (Jogo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		return true;
	}
	
	
	
	

}

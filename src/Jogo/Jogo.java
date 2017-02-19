package Jogo;

import Exceptions.NomeInvalido;
import Exceptions.ValorInvalido;

public abstract class Jogo {
	
	private String nome;
	private double preco;
	protected int scoreMaximo;
	protected int quantidadeDeJogadas;
	protected int jogadasZeradas;

	public Jogo(String nome, double preco) throws NomeInvalido, ValorInvalido{
		if (nome.trim().equals("") || nome == null){
			throw new NomeInvalido("Nome vazio ou null!");
		} else if (preco <= 0){
			throw new ValorInvalido("Preço menor ou igual a zero!");
		}
		this.nome = nome;
		this.preco = preco;
		this.scoreMaximo = 0;
		this.quantidadeDeJogadas = 0;
		this.jogadasZeradas = 0;		
	}
	
	public abstract int registraJogada (int score, boolean concluiu) throws ValorInvalido;

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

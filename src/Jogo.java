
public class Jogo {
	
	private String nome;
	private double preco;
	private int score;
	private int quantidadeDeJogadas;
	private int jogadasZeradas;

	public Jogo(String nome, double preco) {
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
	
	

}

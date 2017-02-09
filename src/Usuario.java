import java.util.ArrayList;


public abstract class Usuario {
	
	protected String nome;
	protected ArrayList<Jogo> jogos;
	protected double quantia;
	protected int x2p;

	public Usuario(String nome) {
		this.nome = nome;
		this.jogos = new ArrayList<>();
		this.quantia = 0;
	}
	
	public abstract void comprarJogo(Jogo jogo);
		

	public void adicionarQuantia(double quantia){
		this.quantia += quantia;
	}
}

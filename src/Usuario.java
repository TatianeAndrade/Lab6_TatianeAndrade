import java.util.ArrayList;


public class Usuario {
	
	private String nome;
	private ArrayList<Jogo> jogos;
	private double quantia;

	public Usuario(String nome) {
		this.nome = nome;
		this.jogos = new ArrayList<>();
		this.quantia = 0;
	}
	
	public void comprarJogo(Jogo jogo){
		if (jogo.getPreco() >= this.quantia){
			jogos.add(jogo);
			quantia -= jogo.getPreco();
		}
		
	}

	public void adicionarQuantia(){
		
	}
}

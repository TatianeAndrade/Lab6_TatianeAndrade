package Loja;

import java.util.HashMap;
import java.util.Map;

import Exceptions.JogoInvalido;
import Exceptions.LoginInvalido;
import Exceptions.NomeInvalido;
import Exceptions.UsuarioInvalido;
import Exceptions.ValorInvalido;
import Jogo.Jogo;
import Usuario.Noob;
import Usuario.Usuario;
import Usuario.Veterano;

public class Loja {
	
	private Map<String, Usuario> usuarios;

	public Loja(){
		this.usuarios = new HashMap<>();
	}
	
	public void adicionarUsuario (Usuario usuario){
		try{
			if (usuario == null){
				throw new UsuarioInvalido("Usuário null não permitido!");
			}else if (this.usuarios.containsKey(usuario.getNome())){
				throw new UsuarioInvalido("Usuário já existe!");
			}
			this.usuarios.put(usuario.getLogin(), usuario);
		}catch (UsuarioInvalido e){
			e.printStackTrace();
		}
	}
	
	public void adicionaValor(String login, double valor){
		try{
			if (login.trim().equals("") || login == null){
				throw new LoginInvalido("Login vazio ou null não permitido!");
			}else if (this.usuarios.containsKey(login)){
				usuarios.get(login).adicionarQuantia(valor);
			}else{
				throw new LoginInvalido("Login Inexistente!");
			}
		}catch (LoginInvalido e){
			e.printStackTrace();
		}catch (ValorInvalido e){
			e.printStackTrace();
		}
	}
	
	public void comprarJogo(String login, Jogo jogo){
		try{
			if (login.trim().equals("") || login == null){
					throw new LoginInvalido("Login vazio ou null não permitido!");
			}else if (this.usuarios.containsKey(login)){
				usuarios.get(login).comprarJogo(jogo);
			}else{
				throw new LoginInvalido("Login Inexistente!");
			}
		}catch (LoginInvalido e){
			e.printStackTrace();
		}catch (JogoInvalido e){
			e.printStackTrace();
		}
	}
		
	public void upgrade(String login){
		try{
			Usuario usuario = usuarios.get(login);
			if(usuarios.containsKey(login)){
				if(usuarios.get(login).getX2p() >= 1000){
					if (usuarios.get(login) instanceof Noob){
						Usuario veterano = new Veterano(usuario.getNome(), usuario.getLogin(), usuario.getX2p(), usuario.getQuantia(), usuario.getJogos());
						usuarios.remove(login);
						usuarios.put(login, veterano);
					}else {
						throw new UsuarioInvalido("Usuario ja é veterano!");
					}
				}else {
					throw new UsuarioInvalido("Usuario não preenche os requisitos de upgrade!");
				}
			}
		}catch(NomeInvalido e){
			e.printStackTrace();
		}catch(UsuarioInvalido e){
			e.printStackTrace();
		}
	}
	
	public void imprimir(){
		System.out.println(toString());
	}

	@Override
	public String toString() {
		String string = "";
		String separador = System.lineSeparator();
		string += "=== Central P2-CG ===" + separador;
		string += separador;
		for (Usuario usuario : usuarios.values()) {
			string += usuario.toString();
		}
		string += "--------------------------------------------";
		return string;
	}

}

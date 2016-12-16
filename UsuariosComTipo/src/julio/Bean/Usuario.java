package julio.Bean;

import java.io.Serializable;
import java.lang.reflect.Field;

public class Usuario implements Serializable {	

	private long id;
	private String nome;
	private String email;
	private String senha;
	private long tipo;
	private String tipoUsuario;

	public Usuario() {
	}

	public Usuario(String nome, String email, String senha, long tipo) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
	}
	
	public Usuario(String nome, String email, String senha, long tipo, String tipoUsuario) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
		this.tipoUsuario = tipoUsuario;
	}

	public Usuario(long id, String nome, String email, String senha, long tipo) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
	}

	public boolean isValid() throws IllegalArgumentException, IllegalAccessException {
		Field[] campos = this.getClass().getDeclaredFields();
		for (Field field : campos) {
			if (field.getType() == String.class && !field.getName().equals("tipoUsuario") && field.get(this) == null) {				
				return false;
			}
			if (field.getName().equals("tipo") && field.getLong(this) == 0) {				
				return false;
			}
		}
		return true;
	}	
	
	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public long getTipo() {
		return tipo;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setTipo(long tipo) {
		this.tipo = tipo;
	}

}

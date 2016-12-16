package julio.Bean;

import java.io.Serializable;

public class TipoUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String nome;

	public TipoUsuario() {
	}
	
	public TipoUsuario(String nome){
		this.nome = nome;
	}

	public TipoUsuario(long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

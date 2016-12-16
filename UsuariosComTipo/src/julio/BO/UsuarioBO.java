package julio.BO;

import java.sql.Connection;
import java.util.List;

import julio.Bean.Usuario;
import julio.DAO.UsuarioDAO;

public abstract class UsuarioBO {
	
	public static int cadastrar(Usuario u, Connection con) throws Exception{
		if(u == null)
			throw new Exception("Objeto Usuario esperado");
		if(con == null)
			throw new Exception("Objeto Connection esperado");
		if(!u.isValid())
			throw new Exception("Objecto Usuario inválido");
		return new UsuarioDAO().cadastrar(u, con);
	}
	
	public static List<Usuario> listar(Connection con) throws Exception{
		return new UsuarioDAO().listar(con);
	}
	
	public static Usuario buscarPorLogin(String email, String senha, Connection con) throws Exception{
		if(email == null || email.equals(""))
			throw new Exception("Email de usuário invalido");
		if(senha == null || senha.equals(""))
			throw new Exception("Senha de usuário invalido");
		if(con == null)
			throw new Exception("Objeto Connection esperado");
		return new UsuarioDAO().buscarPorLogin(email, senha, con);
	}

}

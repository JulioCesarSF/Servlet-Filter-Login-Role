package julio.BO;

import java.sql.Connection;
import java.util.List;

import julio.Bean.TipoUsuario;
import julio.DAO.TipoUsuarioDAO;

public abstract class TipoUsuarioBO {
	
	public static int cadastrar(TipoUsuario tU, Connection con) throws Exception{
		if(tU == null)
			throw new Exception("Objeto TipoUsuario esperado");
		if(con == null)
			throw new Exception("Objeto Connection esperado");
		if(tU.getNome().equals(""))
			throw new Exception("Sem nome definido");
		return new TipoUsuarioDAO().cadastrar(tU, con);
	}
	
	public static List<TipoUsuario> listar(Connection con) throws Exception{
		return new TipoUsuarioDAO().listar(con);
	}

}

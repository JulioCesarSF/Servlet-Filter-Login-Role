package julio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import julio.Bean.TipoUsuario;

public class TipoUsuarioDAO implements InterfaceDAO<TipoUsuario> {

	private PreparedStatement pStmt = null;
	private ResultSet rS = null;
	
	@Override
	public int cadastrar(TipoUsuario entidade, Connection con) throws Exception {
		String sql = new String("INSERT INTO T_TIPO_USUARIO (CD_TIPO_USUARIO, NM_TIPO) VALUES(SQ_TIPO_USUARIO.NEXTVAL, ?)");
		pStmt = con.prepareStatement(sql);
		pStmt.setString(1, entidade.getNome());			
		return pStmt.executeUpdate();
	}
	
	@Override
	public int deletar(long cd, Connection con) throws Exception {
		String sql = new String("DELETE FROM T_TIPO_USUARIO WHERE CD_TIPO_USUARIO = ?");
		pStmt = con.prepareStatement(sql);
		pStmt.setLong(1, cd);		
		return pStmt.executeUpdate();
	}
	@Override
	public int alterar(TipoUsuario entidade, Connection con) throws Exception {
		String sql = new String("UPDATE T_TIPO_USUARIO SET (NM_TIPO=?) WHERE CD_TIPO_USUARIO=?");
		pStmt = con.prepareStatement(sql);
		pStmt.setString(1, entidade.getNome());
		pStmt.setLong(2, entidade.getId());
		return pStmt.executeUpdate();
	}
	@Override
	public TipoUsuario buscarPorId(long cd, Connection con) throws Exception {
		String sql = new String("SELECT (CD_TIPO_USUARIO, NM_TIPO) WHERE CD_TIPO_USUARIO=?");
		pStmt = con.prepareStatement(sql);
		pStmt.setLong(1, cd);
		rS = pStmt.executeQuery();		
		TipoUsuario tU = null;		
		if(rS.next()){
			tU = new TipoUsuario(rS.getLong("CD_TIPO_USUARIO"), rS.getString("NM_TIPO"));
		}		
		return tU;
	}
	@Override
	public List<TipoUsuario> listar(Connection con) throws Exception {
		String sql = new String("SELECT CD_TIPO_USUARIO, NM_TIPO FROM T_TIPO_USUARIO");
		pStmt = con.prepareStatement(sql);
		rS = pStmt.executeQuery();		
		List<TipoUsuario> lista = new ArrayList<>();		
		while(rS.next()){
			lista.add(new TipoUsuario(rS.getLong("CD_TIPO_USUARIO"), rS.getString("NM_TIPO")));
		}		
		return lista;
	}
}

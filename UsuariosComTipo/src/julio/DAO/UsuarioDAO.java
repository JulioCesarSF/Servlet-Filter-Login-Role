package julio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import julio.Bean.Usuario;

public class UsuarioDAO implements InterfaceDAO<Usuario> {

	private PreparedStatement pStmt = null;
	private ResultSet rS = null;

	@Override
	public int cadastrar(Usuario entidade, Connection con) throws Exception {
		String sql = new String(
				"INSERT INTO T_USUARIO (CD_USUARIO, NM_USUARIO, DS_EMAIL, DS_PASSWORD, CD_TIPO_USUARIO) VALUES (SQ_USUARIO.NEXTVAL, ?,?,?,?)");
		pStmt = con.prepareStatement(sql);
		pStmt.setString(1, entidade.getNome());
		pStmt.setString(2, entidade.getEmail());
		pStmt.setString(3, entidade.getSenha());
		pStmt.setLong(4, entidade.getTipo());
		return pStmt.executeUpdate();
	}

	@Override
	public int deletar(long cd, Connection con) throws Exception {
		String sql = new String("DELETE FROM T_USUARIO WHERE CD_USUARIO=?");
		pStmt = con.prepareStatement(sql);
		pStmt.setLong(1, cd);
		return pStmt.executeUpdate();
	}

	@Override
	public int alterar(Usuario entidade, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Usuario buscarPorId(long cd, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listar(Connection con) throws Exception {
		String sql = new String("SELECT CD_USUARIO, NM_USUARIO, DS_EMAIL, DS_PASSWORD, CD_TIPO_USUARIO FROM T_USUARIO");
		pStmt = con.prepareStatement(sql);
		rS = pStmt.executeQuery();
		List<Usuario> lista = new ArrayList<>();
		while (rS.next()) {
			lista.add(new Usuario(rS.getLong("CD_USUARIO"), rS.getString("NM_USUARIO"), rS.getString("DS_EMAIL"),
					rS.getString("DS_PASSWORD"), rS.getLong("CD_TIPO_USUARIO")));
		}
		return lista;
	}

	public Usuario buscarPorLogin(String email, String senha, Connection con) throws Exception {
		Usuario u = null;

		String sql = new String(
				"SELECT U.CD_USUARIO, U.NM_USUARIO, U.DS_EMAIL, U.DS_PASSWORD, U.CD_TIPO_USUARIO, TU.NM_TIPO "
				+ "FROM T_USUARIO U INNER JOIN T_TIPO_USUARIO TU "
				+ "ON(U.CD_TIPO_USUARIO=TU.CD_TIPO_USUARIO) "
				+ "WHERE DS_EMAIL=? AND DS_PASSWORD=?");
		pStmt = con.prepareStatement(sql);
		pStmt.setString(1, email);
		pStmt.setString(2, senha);
		rS = pStmt.executeQuery();

		if (rS.next()) {
			u = new Usuario();
			u.setId(rS.getLong("CD_USUARIO"));
			u.setNome(rS.getString("NM_USUARIO"));
			u.setEmail(rS.getString("DS_EMAIL"));
			u.setSenha(rS.getString("DS_PASSWORD"));
			u.setTipo(rS.getLong("CD_TIPO_USUARIO"));
			u.setTipoUsuario(rS.getString("NM_TIPO"));
		}

		return u;
	}

}

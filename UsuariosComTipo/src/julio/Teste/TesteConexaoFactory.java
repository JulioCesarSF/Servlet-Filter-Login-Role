package julio.Teste;

import java.sql.Connection;

import julio.Conexao.ConexaoFactory;

public class TesteConexaoFactory {

	public static void main(String[] args) {
		Connection con = null;
		
		try {
			con = ConexaoFactory.getInst().getConnection("youtube", "1234");
			System.out.println("Conectou");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null){
					con.close();
					System.out.println("Desconectou");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}

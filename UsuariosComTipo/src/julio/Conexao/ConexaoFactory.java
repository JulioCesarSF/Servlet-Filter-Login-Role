package julio.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public final class ConexaoFactory {
	
	private static  ConexaoFactory con;
	private static Connection connection;
	
	private ConexaoFactory(){}
	
	public static ConexaoFactory getInst(){
		if(con == null){
			con = new ConexaoFactory();
		}
		return con;
	}
	
	public Connection getConnection(String usuario, String senha) throws Exception{
		if(connection == null || connection.isClosed()){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", usuario, senha);
		}
		return connection;
	}
	
	public void fechar() throws Exception{
		if(connection != null && !connection.isClosed()){
			connection.close();
		}
	}

}

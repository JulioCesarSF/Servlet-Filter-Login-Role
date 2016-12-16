package julio.DAO;

import java.sql.Connection;
import java.util.List;

public interface InterfaceDAO<T> {
	
	int cadastrar(T entidade, Connection con) throws Exception;
	int deletar(long cd, Connection con) throws Exception;
	int alterar(T entidade, Connection con) throws Exception;
	T buscarPorId(long cd, Connection con) throws Exception;
	List<T> listar(Connection con) throws Exception;

}

package julio.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import julio.BO.TipoUsuarioBO;
import julio.Bean.TipoUsuario;
import julio.Conexao.ConexaoFactory;

@SuppressWarnings("serial")
@WebServlet("/TipoUsuario")
public class TipoUsuarioServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = new String(req.getParameter("acao"));

		switch (acao) {
		case "cadastrar":			
			cadastrar(req, resp);
			break;

		default:
			break;
		}
	}

	private void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		Connection con = null;		
		try {			
			con = ConexaoFactory.getInst().getConnection("youtube", "1234");
			HashMap<String, String> p = getParametros(req);
			TipoUsuario tU = new TipoUsuario(p.get("NM_TIPO_USUARIO"));
			if(TipoUsuarioBO.cadastrar(tU, con) == 1){				
				req.setAttribute("mensagem", "Cadastrado com sucesso!");
				req.setAttribute("tipoMensagem", "alert alert-dismissable alert-success");
			}			
		} catch (Exception e) {			
			req.setAttribute("mensagem", "Não cadastrado " + e.getMessage());
			req.setAttribute("tipoMensagem", "alert alert-dismissable alert-danger");			
			//e.printStackTrace();
		}finally {
			try {
				List<TipoUsuario> lista = TipoUsuarioBO.listar(con);
				req.setAttribute("lista", lista);				
			} catch (Exception e) {				
				e.printStackTrace();
			}
			req.setAttribute("pagina", "tipoUsuario");
			req.getRequestDispatcher("/Paginas/cadastroTipoUsuario.jsp").forward(req, resp);
		}
				
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("tipoUsuario") == null){
			req.getRequestDispatcher("/Paginas/Login.jsp").forward(req, resp);
		}else if(!req.getSession().getAttribute("tipoUsuario").equals("Admin")){
			req.getRequestDispatcher("/Paginas/Logado.jsp").forward(req, resp);
		}
		
		Connection con = null;		
		try {			
			con = ConexaoFactory.getInst().getConnection("youtube", "1234");
			List<TipoUsuario> lista = TipoUsuarioBO.listar(con);
			req.setAttribute("lista", lista);				
		} catch (Exception e) {				
			e.printStackTrace();
		}
		req.setAttribute("pagina", "tipoUsuario");
		req.getRequestDispatcher("/Paginas/cadastroTipoUsuario.jsp").forward(req, resp);
	}
	
	@Override
	public void destroy() {		
		super.destroy();
		try {
			ConexaoFactory.getInst().fechar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private HashMap<String, String> getParametros(HttpServletRequest req) throws IOException{
		HashMap<String, String> parametros = new HashMap<>();		
		Enumeration<String> p = req.getParameterNames();		
		while(p.hasMoreElements()){
			String param = p.nextElement();
			String value = req.getParameter(param);
			parametros.put(param, value);
		}
		
		return parametros;		
	}

}

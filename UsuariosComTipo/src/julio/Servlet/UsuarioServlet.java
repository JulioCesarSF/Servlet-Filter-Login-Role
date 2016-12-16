package julio.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import julio.BO.TipoUsuarioBO;
import julio.BO.UsuarioBO;
import julio.Bean.TipoUsuario;
import julio.Bean.Usuario;
import julio.Conexao.ConexaoFactory;

@SuppressWarnings("serial")
@WebServlet("/Usuario")
public class UsuarioServlet extends HttpServlet {

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
		String nome = req.getParameter("NM_USUARIO");
		String email = req.getParameter("DS_EMAIL");
		String senha = req.getParameter("DS_PASSWORD");
		String tipo = req.getParameter("CD_TIPO_USUARIO");

		Connection con = null;

		try {
			con = ConexaoFactory.getInst().getConnection("youtube", "1234");			
			Usuario u = new Usuario(nome, email, senha, Long.parseLong(tipo));
			if (UsuarioBO.cadastrar(u, con) == 1) {
				req.setAttribute("mensagem", "Cadastrado com sucesso!");
				req.setAttribute("tipoMensagem", "alert alert-dismissable alert-success");
			}
		} catch (Exception e) {
			req.setAttribute("mensagem", "Não cadastrado " + e.getMessage());
			req.setAttribute("tipoMensagem", "alert alert-dismissable alert-danger");
			e.printStackTrace();
		} finally {
			try {
				List<Usuario> lista = UsuarioBO.listar(con);
				List<TipoUsuario> tipos = TipoUsuarioBO.listar(con);
				req.setAttribute("lista", lista);
				req.setAttribute("tipos", tipos);				
			} catch (Exception e) {
				e.printStackTrace();
			}
			req.setAttribute("pagina", "usuario"); 
			req.getRequestDispatcher("/Paginas/cadastroUsuario.jsp").forward(req, resp);
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
			List<Usuario> lista = UsuarioBO.listar(con);
			List<TipoUsuario> tipos = TipoUsuarioBO.listar(con);
			req.setAttribute("lista", lista);
			req.setAttribute("tipos", tipos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("pagina", "usuario");
		req.getRequestDispatcher("/Paginas/cadastroUsuario.jsp").forward(req, resp);
	}

	@Override
	public void destroy() {
		try {
			ConexaoFactory.getInst().fechar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package julio.Servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import julio.BO.UsuarioBO;
import julio.Bean.Usuario;
import julio.Conexao.ConexaoFactory;

@SuppressWarnings("serial")
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usuario = new String(req.getParameter("DS_EMAIL"));
		String senha = new String(req.getParameter("DS_PASSWORD"));

		Connection con = null;

		try {
			con = ConexaoFactory.getInst().getConnection("youtube", "1234");
			Usuario u = UsuarioBO.buscarPorLogin(usuario, senha, con);

			if (u == null) {
				req.setAttribute("mensagem", "Usuário/Senha inválidos!");
				req.setAttribute("tipoMensagem", "alert alert-dismisable alert-danger");
				req.getRequestDispatcher("./Paginas/Login.jsp").forward(req, resp);
			} else {
				HttpSession session = req.getSession();
				session.setAttribute("nome", u.getNome());
				session.setAttribute("tipoUsuario", u.getTipoUsuario());
				session.setMaxInactiveInterval(30 * 60); // 30 minutos
				Cookie cookie = new Cookie("usuario", u.getEmail());
				resp.addCookie(cookie);
				req.getRequestDispatcher("./Paginas/Logado.jsp").forward(req, resp);
			}

		} catch (Exception e) {
			req.setAttribute("mensagem", "Ops! " + e.getMessage());
			req.setAttribute("tipoMensagem", "alert alert-dismisable alert-danger");
			req.getRequestDispatcher("./Paginas/Login.jsp").forward(req, resp);
			e.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		HttpSession session = req.getSession(false);				
		if (session != null) {
			session.invalidate();
		}
		req.getRequestDispatcher("./Paginas/Login.jsp").forward(req, resp);		
	}

}

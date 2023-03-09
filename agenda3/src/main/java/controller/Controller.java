package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if (action.equals("/main")) {
			contatos(request, response);
			dao.testeconexao();

		} else if (action.equals("insert")) {
			novoContato(request, response);
		} else if (action.equals("select")) {
			listarContato(request, response);
		} else if (action.equals("update")) {
			editarContato(request, response);
		} else if (action.equals("delete")) {
			removerContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	/** CRUD LISTAR OS CONTATOS **/
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JavaBeans> lista = dao.listarContatos();
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}

	/** CRUD NOVO CONTATO **/
		private void novoContato(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			System.out.println("PARAMETROS PASSADOS NO REQUEST:");
			System.out.println(request.getParameter("nome"));
			System.out.println(request.getParameter("fone"));
			System.out.println(request.getParameter("email"));
			
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		
		System.out.println("PARAMETROS JA NO JAVABEANS CONTATOS:");
		System.out.println(contato.getNome());
		System.out.println(contato.getFone());
		System.out.println(contato.getEmail());
			dao.inserirContato(contato);
			response.sendRedirect("agenda.jsp");
			
		}
	// TODO Auto-generated method stub

	/** CRUD LISTAR O CONTATO **/
	private void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/** CRUD EDITAR CONTATO **/
	private void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/** CRUD REMOVER CONTATO **/
	private void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}

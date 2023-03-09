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

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		//System.out.println(action);
		if (action.equals("/main")) {			
			contatos(request, response);
			
		} else if (action.equals("/insert")) {
			novoContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}

		// teste de conexao
		// dao.testeConexao();
	}

	// LISTAR CONTATOS
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// CRIANDO OBJETO QUE IRA RECEBER OS DADOS JAVABEANS (VETOR DINAMICO)
		ArrayList<JavaBeans> lista = dao.listarContatos();

		// ENCAMINHAR A LISTA AO DOCUMENTO AGENDA.JSP
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
		
				

		// teste de recebimento da lista
//		for (int i = 0; i < lista.size(); i++) {
//			System.out.println(lista.get(i).getIdcon());
//			System.out.println(lista.get(i).getNome());
//			System.out.println(lista.get(i).getFone());
//			System.out.println(lista.get(i).getEmail());
	}

	

	// NOVO CONTATO
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// teste de recebimento dos dados do formulario
//		System.out.println(request.getParameter("nome"));
//		System.out.println(request.getParameter("fone"));
//		System.out.println(request.getParameter("email"));

		// setar as variaveis JavaBeans
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));

		// INVOCAR O MÉTDO inserirContato passando o objeto contato
		dao.inserirContato(contato);

		// redirecionar para o documento agenda.jsp
		response.sendRedirect("main");

		// testando se os dados estao no objeto contato
//		System.out.println(contato.getNome());
//		System.out.println(contato.getFone());
//		System.out.println(contato.getEmail());

	}

}

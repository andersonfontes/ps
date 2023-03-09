package controller;

import java.io.IOException;
import java.text.Normalizer.Form;
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);

		} else if (action.equals("/insert")) {
			novoContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/delete")) {
			removerContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// LISTAR CONTATOS (SERVLET / CONTROLLER)
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// CRIANDO OBJETO QUE IRA RECEBER OS DADOS JAVABEANS (VETOR DINAMICO)
		ArrayList<JavaBeans> lista = dao.listarContatos();

		// ENCAMINHAR A LISTA AO DOCUMENTO AGENDA.JSP
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}

	// NOVO CONTATO (SERVLET / CONTROLLER)
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// setar as variaveis JavaBeans
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));

		// INVOCAR O MÉTODO inserirContato passando o objeto contato
		dao.inserirContato(contato);

		// redirecionar para o documento agenda.jsp
		response.sendRedirect("main");
	}

	// EDITAR CONTATO (SERVLET / CONTROLLER)
	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		contato.setIdcon(idcon);
		// EXECUTAR O METODO SELECIONAR CONTATO
		dao.selecionarContato(contato);
		// setar os atributos do formulario c/ o conteudo JavaBeans

		request.setAttribute("idcon", contato.getIdcon());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("fone", contato.getFone());
		request.setAttribute("email", contato.getEmail());
		// encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setIdcon(request.getParameter("idcon"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		dao.alterarContato(contato);

		// redirecionar para o documento agenda.jsp atualizando as alterações
		response.sendRedirect("main");
	}

	// EXCLUIR CONTATO (SERVLET / CONTROLLER)
	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		contato.setIdcon(idcon);
		//TESTE: System.out.println(idcon);
		dao.apagarContato(contato);

		// redirecionar para o documento agenda.jsp atualizando as alterações
		response.sendRedirect("main");
	}
}

// testando se os dados estao no objeto contato
//System.out.println(contato.getIdcon());





































//System.out.println(contato.getNome());System.out.println(contato.getFone());
//	System.out.println(contato.getEmail());

// teste de recebimento da lista do LISTAR CONTATOS
//	for (int i = 0; i < lista.size(); i++) {
//		System.out.println(lista.get(i).getIdcon());
//		System.out.println(lista.get(i).getNome());
//		System.out.println(lista.get(i).getFone());
//		System.out.println(lista.get(i).getEmail());

// teste de conexao
// dao.testeConexao();

// teste de recebimento dos dados do formulario NOVO CONTATO
//	System.out.println(request.getParameter("nome"));
//	System.out.println(request.getParameter("fone"));
//	System.out.println(request.getParameter("email"));
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet2
 */
@WebServlet("/HelloServlet2")
public class HelloServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter saida = response.getWriter();
	saida.println("<!doctype html>");
	saida.println("<html><head>");
	saida.println("<title>teste titulo</title>");
	saida.println("</head >");
	saida.println("<body>");
	saida.println("<h1>teste h1</h1>");
	ArrayList<String> produtos = new ArrayList<String>();
	produtos.add("banana");
	produtos.add("maca");
	produtos.add("pera");
//	produtos.forEach(produtos.get(e)){
//		saida.println(produtos(e));
	}
	}
	//saida.println(produtos.get(0));
	//saida.println(produtos.get(1));
	saida.println(produtos.get(2));
	saida.println("</body>");
	saida.println("</html>");
	
	
	}

	private Consumer<? super String> println(Iterator<String> iterator) {
		// TODO Auto-generated method stub
		return null;
	}

}

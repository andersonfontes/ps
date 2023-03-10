package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class DAO {
	/** modulo de conexao **/
	// PARAMETROS DE CONEXAO

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&ServerTimezone=UTC";
	private String user = "and";
	private String password = "1234";

	// METODO DE CONEXAO
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	/** CRUD CREATE (CLASSE DAO) **/
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome,fone,email) values (?,?,?)";
		try {
			Connection con = conectar();

			// Preparar a query para execução no BD
			PreparedStatement pst = con.prepareStatement(create);

			// Substituir parametros (?) pelo contaeudo das variaveis JavBEans
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());

			// executar a query
			pst.executeUpdate();

			// Encerrar a conexao com o BD
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD READ (CLASSE DAO) **/
	public ArrayList<JavaBeans> listarContatos() {

		// Criando objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> contatos = new ArrayList<>();

		String read = "select * from contatos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			// o laço abaixo sera executado enquanto houver contatos
			while (rs.next()) {
				// variaveis de apoio que recebem os dados do banco
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				// populando o ArrayList
				contatos.add(new JavaBeans(idcon, nome, fone, email));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CRUD SELECT (CLASSE DAO) **/
	public void selecionarContato(JavaBeans contato) {
		Connection con = conectar();
		String read2 = "select * from contatos where idcon=?";
		try {
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getIdcon());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD UPDATE (CLASSE DAO) **/
	public void alterarContato(JavaBeans contato) {
		String create = "update contatos  set nome=?, fone=?,email=? where idcon=?;";

		try {
			Connection con = conectar();

			// Preparar a query para execução no BD
			PreparedStatement pst = con.prepareStatement(create);

			// Substituir parametros (?) pelo contaeudo das variaveis JavaBeans

			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcon());

			// executar a query
			pst.executeUpdate();
//
//			// Encerrar a conexao com o BD
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD DELETE (CLASSE DAO) **/
	public void apagarContato(JavaBeans contato) {
		String delete = "delete from contatos where idcon=?;";

		try {
			Connection con = conectar();

			// Preparar a query para execução no BD
			PreparedStatement pst = con.prepareStatement(delete);

			// Substituir parametros (?) pelo contaeudo das variaveis JavaBeans
			pst.setString(1, contato.getIdcon());

			// executar a query
			pst.executeUpdate();

			// Encerrar a conexao com o BD
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	
	
	// teste conexao
//	public void testeConexao()
//	{
//		try {
//			Connection con = conectar();
//			System.out.println(con);
//			con.close();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
}

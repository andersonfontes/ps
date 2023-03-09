package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class DAO {
	/** modulo de conexao **/
	// PARAMETROS DE CONEXAO

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/db_candidatos2?useTimezone=true&ServerTimezone=UTC";
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
	
	// teste conexao
	public void TesteConexao()
	{
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void inserirVaga(JBvaga vaga) {
		String create="INSERT INTO VAGA(data,descricao,nome,salario) values ('?','?','?','?') ";
		try {
			//abrir a conexao bd
			Connection con = conectar();
			PreparedStatement pst= con.prepareStatement(create);
			//substituir parametros ? pelas variaveis
			pst.setString(1, vaga.getData());
			pst.setString(2, vaga.getDescricao());
			pst.setString(3, vaga.getNome());
			pst.setString(4, vaga.getSalario());
			// executa query
			pst.executeUpdate();
			//encerra conexao
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}

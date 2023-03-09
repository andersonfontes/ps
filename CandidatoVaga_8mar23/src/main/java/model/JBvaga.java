package model;

public class JBvaga {
	public String idvaga;
	public String data;
	public String descricao;
	public String nome;
	public String salario;
	
	
	public JBvaga() {
		super();
		
	}
	public JBvaga(String idvaga, String data, String descricao, String nome, String salario) {
		super();
		this.idvaga = idvaga;
		this.data = data;
		this.descricao = descricao;
		this.nome = nome;
		this.salario = salario;
	}
	public String getIdvaga() {
		return idvaga;
	}
	public void setIdvaga(String idvaga) {
		this.idvaga = idvaga;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	
}

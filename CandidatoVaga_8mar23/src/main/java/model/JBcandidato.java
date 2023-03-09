package model;

public class JBcandidato {

	private String idcandidato;
	private String email;
	private String nome_candidato;
	private String rg;
	private String codvaga;
	
	
	public JBcandidato() {
		super();
		
	}
	public JBcandidato(String idcandidato, String email, String nome_candidato, String rg, String codvaga) {
		super();
		this.idcandidato = idcandidato;
		this.email = email;
		this.nome_candidato = nome_candidato;
		this.rg = rg;
		this.codvaga = codvaga;
	}
	public String getIdcandidato() {
		return idcandidato;
	}
	public void setIdcandidato(String idcandidato) {
		this.idcandidato = idcandidato;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome_candidato() {
		return nome_candidato;
	}
	public void setNome_candidato(String nome_candidato) {
		this.nome_candidato = nome_candidato;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCodvaga() {
		return codvaga;
	}
	public void setCodvaga(String codvaga) {
		this.codvaga = codvaga;
	}
	
}

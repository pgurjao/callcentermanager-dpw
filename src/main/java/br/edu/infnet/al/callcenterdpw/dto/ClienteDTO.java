package br.edu.infnet.al.callcenterdpw.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class ClienteDTO {
	
	@Id
	@GeneratedValue
	private Long idCliente;
	private Long idContrato;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String endereco;
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="idContrato", referencedColumnName="id", insertable=false, updatable=false)
	private ContratoDTO contrato;
	
	public ClienteDTO() {
		
	}

	public ClienteDTO(long idCliente, String nome, String cpf, String email, String telefone, String endereco,
			long idContrato) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.idContrato = idContrato;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getIdContrato() {
		return idContrato;
	}	

}

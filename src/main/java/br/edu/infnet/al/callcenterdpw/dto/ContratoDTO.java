package br.edu.infnet.al.callcenterdpw.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="contrato")
public class ContratoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
	private long idContrato;
	@NotBlank@NotNull
	private String cpf;
	@NotBlank@NotNull
	private String descricao;
	@NotBlank@NotNull
	private Date validade;
	@NotBlank@NotNull
	private int nivelPrioridade;

	public ContratoDTO() {
		
	}
	
	public ContratoDTO(long idContrato, String cpf, String descricao, Date validade, int nivelPrioridade) {
		this.idContrato = idContrato;
		this.cpf = cpf;
		this.descricao = descricao;
		this.validade = validade;
		this.nivelPrioridade = nivelPrioridade;
	}	
	
	public boolean validarCpf (String cpf) {
		
		ClienteDTO cliente = new ClienteDTO();

		if(cliente.validarCpf(cpf)) {
			return true;
		}

		return false;
	}
	
	public boolean validarDescricao (String descricao) {

		if(descricao.length() >= 3) {
			return true;
		}

		return false;
	}
	
	public boolean validarNivelPrioridade (int nivelPrioridade) {

		if(nivelPrioridade >= 0) {
			return true;
		}

		return false;
	}
	
	public boolean validarValidade (Date validade) {

		System.out.println(validade.toString() );

		return true;
	}
	
		public long getIdContrato() {
			return idContrato;
		}
		public void setIdContrato(long idContrato) {
			this.idContrato = idContrato;
		}
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public Date getValidade() {
			return validade;
		}
		public void setValidade(Date validade) {
			this.validade = validade;
		}
		public int getNivelPrioridade() {
			return nivelPrioridade;
		}
		public void setNivelPrioridade(int nivelPrioridade) {
			this.nivelPrioridade = nivelPrioridade;
		}

}


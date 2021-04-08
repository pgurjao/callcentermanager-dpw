package br.edu.infnet.al.callcenterdpw.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="contrato")
public class ContratoDTO {
	
    @Id
    @GeneratedValue
	private long idContrato;
	private String cpf;
	private String descricao;
	private Date validade;
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


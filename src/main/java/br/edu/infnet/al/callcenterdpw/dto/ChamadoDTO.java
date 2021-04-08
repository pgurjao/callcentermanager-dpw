package br.edu.infnet.al.callcenterdpw.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="chamado")
public class ChamadoDTO {
	
	@Id
	@GeneratedValue
	private long idChamado;
	private long idCliente;
	private long idProduto;
	private int numeroSerieProduto; 
	private String descricaoResumida;
	private String detalhamentoCompleto;
	private int codigoErro;
	private String status;
	private String resultado;
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="idCliente", referencedColumnName="id", insertable=false, updatable=false)
	private ClienteDTO cliente;
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="idProduto", referencedColumnName="id", insertable=false, updatable=false)
	private ProdutoDTO produto;


	public ChamadoDTO() {
		
	}


	public ChamadoDTO(int idChamado, int idCliente, int idProduto, int numeroSerieProduto, String descricaoResumida,
			String detalhamentoCompleto, int codigoErro, String status, String resultado) {
		this.idChamado = idChamado;
		this.idCliente = idCliente;
		this.idProduto = idProduto;
		this.numeroSerieProduto = numeroSerieProduto;
		this.descricaoResumida = descricaoResumida;
		this.detalhamentoCompleto = detalhamentoCompleto;
		this.codigoErro = codigoErro;
		this.status = status;
		this.resultado = resultado;
	}


	public long getIdChamado() {
		return idChamado;
	}


	public long getIdCliente() {
		return idCliente;
	}


	public long getIdProduto() {
		return idProduto;
	}


	public int getNumeroSerieProduto() {
		return numeroSerieProduto;
	}


	public void setNumeroSerieProduto(int numeroSerieProduto) {
		this.numeroSerieProduto = numeroSerieProduto;
	}


	public String getDescricaoResumida() {
		return descricaoResumida;
	}


	public void setDescricaoResumida(String descricaoResumida) {
		this.descricaoResumida = descricaoResumida;
	}


	public String getDetalhamentoCompleto() {
		return detalhamentoCompleto;
	}


	public void setDetalhamentoCompleto(String detalhamentoCompleto) {
		this.detalhamentoCompleto = detalhamentoCompleto;
	}


	public int getCodigoErro() {
		return codigoErro;
	}


	public void setCodigoErro(int codigoErro) {
		this.codigoErro = codigoErro;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getResultado() {
		return resultado;
	}


	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
}





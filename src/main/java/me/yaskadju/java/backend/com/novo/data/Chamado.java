package me.yaskadju.java.backend.com.novo.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import me.yaskadju.java.backend.com.novo.enumerado.chamado.Status;
import me.yaskadju.java.backend.com.novo.enumerado.chamado.Tipo;

@Entity
@Table
public class Chamado implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_registro", nullable = false, updatable = false)
	private Date dataRegistro;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 16, nullable = false)
	private Tipo tipo;
	
	@ManyToOne(optional = false)
	@JoinColumn(nullable = false)
	private Usuario usuario;
	
	@Column(length = 64, nullable = false)
	private String assunto;
	
	@Column(length = 2048, nullable = false)
	private String mensagem;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 8, nullable = false)
	private Status status;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "usuario_status", nullable = false)
	private Usuario usuarioStatus;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Usuario getUsuarioStatus() {
		return usuarioStatus;
	}

	public void setUsuarioStatus(Usuario usuarioStatus) {
		this.usuarioStatus = usuarioStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chamado other = (Chamado) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Chamado [id=" + id + ", dataRegistro=" + dataRegistro + ", tipo=" + tipo + ", usuario=" + usuario
				+ ", assunto=" + assunto + ", mensagem=" + mensagem + ", status=" + status + ", usuarioStatus="
				+ usuarioStatus + "]";
	}
	
}

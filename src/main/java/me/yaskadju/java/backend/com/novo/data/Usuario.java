package me.yaskadju.java.backend.com.novo.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import me.yaskadju.java.backend.com.novo.enumerado.usuario.Tipo;

@Entity
@Table
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 64, nullable = false, unique = true)
	private String login;
	
	@XmlTransient
	@Column(length = 128, nullable = false)
	private String senha;
	
	@Column(length = 64, nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private boolean ativo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_registro", nullable = false, updatable = false)
	private Date dataRegistro;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 16, nullable = false)
	private Tipo tipo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
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
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", nome=" + nome + ", ativo=" + ativo + ", dataRegistro="
				+ dataRegistro + ", tipo=" + tipo + "]";
	}
	
}

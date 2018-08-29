package me.yaskadju.java.backend.com.novo.business;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import me.yaskadju.java.backend.com.novo.data.Usuario;
import me.yaskadju.java.backend.com.novo.enumerado.usuario.Tipo;
import me.yaskadju.java.backend.com.novo.infra.HibernateUtil;

public class UsuarioBus {
	
	public static Usuario selecionarAluno() {
		// TODO Remover metodo temporario
		
		Usuario aluno = (Usuario) HibernateUtil.getSessionFactory()
				.openSession()
				.createQuery("from Usuario where login = :login")
				.setString("login", "aluno")
				.uniqueResult();
		
		if(aluno == null) {
			aluno = new Usuario();
			aluno.setLogin("aluno");
			aluno.setSenha(DigestUtils.sha256Hex("123"));
			aluno.setNome("Aluno Teste");
			aluno.setTipo(Tipo.SUPORTE);
			aluno.setDataRegistro(new Date());
			aluno.setAtivo(true);
			
			UsuarioBus usuarioBus = new UsuarioBus();
			usuarioBus.inserir(aluno);	
		}
		
		return aluno;
	}
	
	public Long inserir(Usuario usuario) {
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(usuario);
		t.commit();
		return usuario.getId();
		
	}
	
	public Usuario selecionar(long id) {
		
		return (Usuario) HibernateUtil.getSessionFactory()
				.openSession()
				.get(Usuario.class, id);
		
	}
	
}

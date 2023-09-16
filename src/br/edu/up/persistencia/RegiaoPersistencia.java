package br.edu.up.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.entidade.Regiao;

public class RegiaoPersistencia {
	public static boolean incluir(Regiao regiao){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(regiao);
			manager.getTransaction().commit();
			return true;			
		}
		catch(Exception e){
			return false;
		}
	}
	public static boolean alterar(Regiao regiao){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(regiao);
			manager.getTransaction().commit();
			return true;			
			
		}
		catch(Exception e){
			return false;
		}
	}
	public static boolean excluir(Regiao regiao){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.remove(regiao);
			manager.getTransaction().commit();
			return true;			
			
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public static Regiao procurarPorNome(Regiao regiao){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Regiao where nomeRegiao = :param");
		consulta.setParameter("param", regiao.getNomeRegiao());
		List<Regiao> regioes = consulta.getResultList();
		if(!regioes.isEmpty()){
			return regioes.get(0);
		}
		return null;
	}
	public static Regiao procurarPorId(Regiao regiao){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Regiao where id = :param");
		consulta.setParameter("param", regiao.getId());
		List<Regiao> regioes = consulta.getResultList();
		if(!regioes.isEmpty()){
			return regioes.get(0);
		}
		return null;
	}
	public static List<Regiao> getRegioes(Regiao regiao){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Regiao where nomeRegiao like :param");
		consulta.setParameter("param", "%" + regiao.getNomeRegiao() + "%");
		List<Regiao> regioes = consulta.getResultList();
		return regioes;
	}
}
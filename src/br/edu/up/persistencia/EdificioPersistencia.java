package br.edu.up.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.entidade.Edificio;



public class EdificioPersistencia {
	public static boolean incluir(Edificio edificio){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(edificio);
			manager.getTransaction().commit();
			return true;			
		}
		catch(Exception e){
			return false;
		}
	}
	public static boolean alterar(Edificio edificio){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(edificio);
			manager.getTransaction().commit();
			return true;			
			
		}
		catch(Exception e){
			return false;
		}
	}
	public static boolean excluir(Edificio edificio){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.remove(edificio);
			manager.getTransaction().commit();
			return true;			
			
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public static Edificio procurarPorNome(Edificio edificio){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Edificio where nomeEdificio = :param");
		consulta.setParameter("param", edificio.getNomeEdificio());
		List<Edificio> edificios = consulta.getResultList();
		if(!edificios.isEmpty()){
			return edificios.get(0);
		}
		return null;
	}
	public static Edificio procurarPorId(Edificio edificio){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Edificio where id = :param");
		consulta.setParameter("param", edificio.getId());
		List<Edificio> edificios = consulta.getResultList();
		if(!edificios.isEmpty()){
			return edificios.get(0);
		}
		return null;
	}
	public static List<Edificio> getEdificios(Edificio edificio){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Edificio where nomeEdificio like :param");
		consulta.setParameter("param", "%" + edificio.getNomeEdificio() + "%");
		List<Edificio> edificios = consulta.getResultList();
		return edificios;
	}
}

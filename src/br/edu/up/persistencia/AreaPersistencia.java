package br.edu.up.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.entidade.Animal;
import br.edu.up.entidade.Area;

public class AreaPersistencia {
	public static boolean incluir(Area area){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(area);
			manager.getTransaction().commit();
			return true;			
		}
		catch(Exception e){
			return false;
		}
	}
	public static boolean alterar(Area area){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(area);
			manager.getTransaction().commit();
			return true;			
			
		}
		catch(Exception e){
			return false;
		}
	}
	public static boolean excluir(Area area){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.remove(area);
			manager.getTransaction().commit();
			return true;			
			
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public static Area procurarPorId(Area area){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Area where id = :param");
		consulta.setParameter("param", area.getId());
		List<Area> areas = consulta.getResultList();
		if(!areas.isEmpty()){
			return areas.get(0);
		}
		return null;
	}
	public static Area procurarPorNome(Area area){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Area where nomeArea = :param");
		consulta.setParameter("param", area.getNomeArea());
		List<Area> areas = consulta.getResultList();
		if(!areas.isEmpty()){
			return areas.get(0);
		}
		return null;
	}
	public static List<Area> getAreas(Area area){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Area where nomeArea like :param");
		consulta.setParameter("param", "%" + area.getNomeArea() + "%");
		List<Area> areas = consulta.getResultList();
		return areas;
	}
}

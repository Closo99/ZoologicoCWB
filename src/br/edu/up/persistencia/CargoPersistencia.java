package br.edu.up.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.entidade.Animal;
import br.edu.up.entidade.Cargo;

public class CargoPersistencia {
	public static boolean incluir(Cargo cargo){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(cargo);
			manager.getTransaction().commit();
			return true;			
		}
		catch(Exception e){
			return false;
		}
	}
	public static boolean alterar(Cargo cargo){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(cargo);
			manager.getTransaction().commit();
			return true;			
			
		}
		catch(Exception e){
			return false;
		}
	}
	public static boolean excluir(Cargo cargo){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.remove(cargo);
			manager.getTransaction().commit();
			return true;			
			
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public static Cargo procurarPorNome(Cargo cargo){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Cargo where nomeCargo = :param");
		consulta.setParameter("param", cargo.getNomeCargo());
		List<Cargo> cargos = consulta.getResultList();
		if(!cargos.isEmpty()){
			return cargos.get(0);
		}
		return null;
	}
	public static Cargo procurarPorId(Cargo cargo){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Cargo where id = :param");
		consulta.setParameter("param", cargo.getId());
		List<Cargo> cargos = consulta.getResultList();
		if(!cargos.isEmpty()){
			return cargos.get(0);
		}
		return null;
	}
	public static List<Cargo> getCargos(Cargo cargo){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Cargo where nomeCargo like :param");
		consulta.setParameter("param", "%" + cargo.getNomeCargo() + "%");
		List<Cargo> cargos = consulta.getResultList();
		return cargos;
	}
}

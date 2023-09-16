package br.edu.up.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.entidade.Animal;

public class AnimalPersistencia {
	public static boolean incluir(Animal animal){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(animal);
			manager.getTransaction().commit();
			return true;			
		}
		catch(Exception e){
			return false;
		}
	}
	public static boolean alterar(Animal animal){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(animal);
			manager.getTransaction().commit();
			return true;			
			
		}
		catch(Exception e){
			return false;
		}
	}
	public static boolean excluir(Animal animal){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.remove(animal);
			manager.getTransaction().commit();
			return true;			
			
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public static Animal procurarPorNome(Animal animal){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Animal where nome = :param");
		consulta.setParameter("param", animal.getNome());
		List<Animal> animais = consulta.getResultList();
		if(!animais.isEmpty()){
			return animais.get(0);
		}
		return null;
	}
	public static Animal procurarPorId(Animal animal){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Animal where id = :param");
		consulta.setParameter("param", animal.getId());
		List<Animal> animais = consulta.getResultList();
		if(!animais.isEmpty()){
			return animais.get(0);
		}
		return null;
	}
	public static List<Animal> getAnimais(Animal animal){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Animal where nome like :param");
		consulta.setParameter("param", "%" + animal.getNome() + "%");
		List<Animal> animais = consulta.getResultList();
		return animais;
	}
}

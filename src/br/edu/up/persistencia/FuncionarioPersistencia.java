package br.edu.up.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.entidade.Funcionario;

public class FuncionarioPersistencia {
	public static boolean incluir(Funcionario funcionario){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(funcionario);
			manager.getTransaction().commit();
			return true;			
		}
		catch(Exception e){
			return false;
		}
	}
	public static boolean alterar(Funcionario funcionario){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(funcionario);
			manager.getTransaction().commit();
			return true;			
			
		}
		catch(Exception e){
			return false;
		}
	}
	public static boolean excluir(Funcionario funcionario){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.remove(funcionario);
			manager.getTransaction().commit();
			return true;			
			
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public static Funcionario procurarPorCPF(Funcionario funcionario){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Funcionario where cpf = :param");
		consulta.setParameter("param", funcionario.getCpf());
		List<Funcionario> funcionarios = consulta.getResultList();
		if(!funcionarios.isEmpty()){
			return funcionarios.get(0);
		}
		return null;
	}
	public static Funcionario procurarPorNome(Funcionario funcionario){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Funcionario where nomeFuncionario = :param");
		consulta.setParameter("param", funcionario.getNomeFuncionario());
		List<Funcionario> funcionarios = consulta.getResultList();
		if(!funcionarios.isEmpty()){
			return funcionarios.get(0);
		}
		return null;
	}
	public static Funcionario procurarPorId(Funcionario funcionario){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Funcionario where id = :param");
		consulta.setParameter("param", funcionario.getId());
		List<Funcionario> funcionarios = consulta.getResultList();
		if(!funcionarios.isEmpty()){
			return funcionarios.get(0);
		}
		return null;
	}
	public static List<Funcionario> getFuncionarios(Funcionario funcionario){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Funcionario where nomeFuncionario like :param");
		consulta.setParameter("param", "%" + funcionario.getNomeFuncionario() + "%");
		List<Funcionario> funcionarios = consulta.getResultList();
		return funcionarios;
	}
}

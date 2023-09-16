package br.edu.up.front;

import br.edu.up.entidade.Animal;
import br.edu.up.entidade.Area;
import br.edu.up.entidade.Cargo;
import br.edu.up.entidade.Edificio;
import br.edu.up.entidade.Funcionario;
import br.edu.up.entidade.Regiao;
import br.edu.up.persistencia.AnimalPersistencia;
import br.edu.up.persistencia.AreaPersistencia;
import br.edu.up.persistencia.CargoPersistencia;
import br.edu.up.persistencia.EdificioPersistencia;
import br.edu.up.persistencia.FuncionarioPersistencia;
import br.edu.up.persistencia.RegiaoPersistencia;

public class AppPesquisar {
	

	public AppPesquisar() {
		String opc = "";
		String nome;		
		
		do {
			nome = Console.readString("Termo de pesquisa: ").toUpperCase();
			pesquisarRegiao(nome);
			pesquisarArea(nome);
			pesquisarAnimal(nome);
			pesquisarEdificio(nome);
			pesquisarCargo(nome);
			pesquisarFuncionario(nome);
			
			opc = Console.readString("\nDeseja realizar nova pesquisa(S/N)? ").toUpperCase();
		}while(opc.equals("S"));
	}
	
	private static void pesquisarRegiao (String nome) {
		Regiao objRegiao = new Regiao();
		objRegiao.setNomeRegiao(nome);
		if(!RegiaoPersistencia.getRegioes(objRegiao).isEmpty()) {
			System.out.println("\nRegiões encontradas:");
			for(Regiao item: RegiaoPersistencia.getRegioes(objRegiao)) {
				System.out.println("\nID: " + item.getId());
				System.out.println("Nome: " + item.getNomeRegiao());
				System.out.println("................");
			}
		}
	}
	
	private static void pesquisarArea(String nome){
		Area objArea = new Area();
		objArea.setNomeArea(nome);
		if(!AreaPersistencia.getAreas(objArea).isEmpty()) {
			System.out.println("Areas encontradas: ");
			for(Area item: AreaPersistencia.getAreas(objArea)) {
				System.out.println("\nID: " + item.getId());
				System.out.println("Nome: " + item.getNomeArea());
				System.out.println("................");
			}
		}
	}
	
	private static void pesquisarAnimal(String nome){
		Animal objAnimal = new Animal();
		objAnimal.setNome(nome);
		if(!AnimalPersistencia.getAnimais(objAnimal).isEmpty()) {
			System.out.println("Animais encontrados:");
			for(Animal item: AnimalPersistencia.getAnimais(objAnimal)) {
				System.out.println("\nID: " + item.getId());
				System.out.println("Nome: " + item.getNome());
				System.out.println("................");
			}
		}
	}
	
	private static void pesquisarEdificio(String nome){
		Edificio objEdificio = new Edificio();
		objEdificio.setNomeEdificio(nome);
		if(!EdificioPersistencia.getEdificios(objEdificio).isEmpty()) {
			System.out.println("Edificios encontrados:");
			for(Edificio item: EdificioPersistencia.getEdificios(objEdificio)) {
				System.out.println("\nID: " + item.getId());
				System.out.println("Nome: " + item.getNomeEdificio());
				System.out.println("................");
			}
		}
	}
	
	private static void pesquisarCargo(String nome){
		Cargo objCargo = new Cargo();
		objCargo.setNomeCargo(nome);
		if(!CargoPersistencia.getCargos(objCargo).isEmpty()) {
			System.out.println("Cargos encontrados:");
			for(Cargo item: CargoPersistencia.getCargos(objCargo)) {
				System.out.println("\nID: " + item.getId());
				System.out.println("Nome: " + item.getNomeCargo());
				System.out.println("................");
			}
		}
	}
	
	private static void pesquisarFuncionario(String nome){
		Funcionario objFuncionario = new Funcionario();
		objFuncionario.setNomeFuncionario(nome);
		if(!FuncionarioPersistencia.getFuncionarios(objFuncionario).isEmpty()) {
			System.out.println("Funcionarios encontrados:");
			for(Funcionario item: FuncionarioPersistencia.getFuncionarios(objFuncionario)) {
				System.out.println("\nID: " + item.getId());
				System.out.println("Nome: " + item.getNomeFuncionario());
				System.out.println("................");
			}
		} else {
			System.out.println("\n\nNome nao encontrado...");
		}
	}
}

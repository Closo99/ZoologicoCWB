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

public class AppListar {
	public AppListar() {
		int opc;
		do{
			System.out.println("\n\n*** LISTAR ***");
			System.out.println("1 - Listar Regioes");
			System.out.println("2 - Listar Areas");
			System.out.println("3 - Listar Edifícios");
			System.out.println("4 - Listar Cargos");
			System.out.println("5 - Listar Funcionarios");
			System.out.println("6 - Listar Animais");
			System.out.println("7 - Voltar");
			opc = Console.readInt("Opção: ");
			switch(opc){
				case 1:
					listarRegiao();
					break;
				case 2:
					listarArea();
					break;
				case 3:
					listarEdificio();
					break;
				case 4:
					listarCargo();
					break;
				case 5:
					listarFuncionario();
					break;
				case 6:
					listarAnimal();
					break;			
			}
		}while(opc != 7);
	}
	
	private static void listarRegiao(){
		System.out.println("\n\n*** LISTAGEM DE REGIOES ***");
		Regiao objRegiao = new Regiao();
		objRegiao.setNomeRegiao(Console.readString("Informe uma parte do nome da regiao que deseja listar: ").toUpperCase());
		if(!RegiaoPersistencia.getRegioes(objRegiao).isEmpty()) {
			for(Regiao item: RegiaoPersistencia.getRegioes(objRegiao)) {
				System.out.println("\nID: " + item.getId());
				System.out.println("Nome: " + item.getNomeRegiao());
				System.out.println("................");
			}
		} else {
			System.out.println("\n\nNome nao encontrado...");
		}
	}
	
	private static void listarArea(){
		System.out.println("\n\n*** LISTAGEM DE AREAS ***");
		Area objArea = new Area();
		objArea.setNomeArea(Console.readString("Informe uma parte do nome da area que deseja listar: ").toUpperCase());
		if(!AreaPersistencia.getAreas(objArea).isEmpty()) {
			for(Area item: AreaPersistencia.getAreas(objArea)) {
				System.out.println("\nID: " + item.getId());
				System.out.println("Nome: " + item.getNomeArea());
				System.out.println("................");
			}
		} else {
			System.out.println("\n\nNome nao encontrado...");
		}
	}
	
	private static void listarEdificio(){
		System.out.println("\n\n*** LISTAGEM DE EDIFICIOS ***");
		Edificio objEdificio = new Edificio();
		objEdificio.setNomeEdificio(Console.readString("Informe uma parte do nome do edificio que deseja listar: ").toUpperCase());
		if(!EdificioPersistencia.getEdificios(objEdificio).isEmpty()) {
			for(Edificio item: EdificioPersistencia.getEdificios(objEdificio)) {
				System.out.println("\nID: " + item.getId());
				System.out.println("Nome: " + item.getNomeEdificio());
				System.out.println("................");
			}
		} else {
			System.out.println("\n\nNome nao encontrado...");
		}
	}
	
	private static void listarCargo(){
		System.out.println("\n\n*** LISTAGEM DE CARGOS ***");
		Cargo objCargo = new Cargo();
		objCargo.setNomeCargo(Console.readString("Informe uma parte do nome do cargo que deseja listar: ").toUpperCase());
		if(!CargoPersistencia.getCargos(objCargo).isEmpty()) {
			for(Cargo item: CargoPersistencia.getCargos(objCargo)) {
				System.out.println("\nID: " + item.getId());
				System.out.println("Nome: " + item.getNomeCargo());
				System.out.println("................");
			}
		} else {
			System.out.println("\n\nNome nao encontrado...");
		}
	}
	
	private static void listarFuncionario(){
		System.out.println("\n\n*** LISTAGEM DE FUNCIONARIOS ***");
		Funcionario objFuncionario = new Funcionario();
		objFuncionario.setNomeFuncionario(Console.readString("Informe uma parte do nome do funcionario que deseja listar: ").toUpperCase());
		if(!FuncionarioPersistencia.getFuncionarios(objFuncionario).isEmpty()) {
			for(Funcionario item: FuncionarioPersistencia.getFuncionarios(objFuncionario)) {
				System.out.println("\nID: " + item.getId());
				System.out.println("Nome: " + item.getNomeFuncionario());
				System.out.println("................");
			}
		} else {
			System.out.println("\n\nNome nao encontrado...");
		}
	}
	
	private static void listarAnimal(){
		System.out.println("\n\n*** LISTAGEM DE ANIMAIS ***");
		Animal objAnimal = new Animal();
		objAnimal.setNome(Console.readString("Informe uma parte do nome do animal que deseja listar: ").toUpperCase());
		if(!AnimalPersistencia.getAnimais(objAnimal).isEmpty()) {
			for(Animal item: AnimalPersistencia.getAnimais(objAnimal)) {
				System.out.println("\nID: " + item.getId());
				System.out.println("Nome: " + item.getNome());
				System.out.println("................");
			}
		} else {
			System.out.println("\n\nNome nao encontrado...");
		}
	}
}

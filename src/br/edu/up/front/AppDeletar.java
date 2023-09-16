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

public class AppDeletar {
	public AppDeletar() {
		int opc;
		do{
			System.out.println("\n\n*** EXCLUSÃO ***");
			System.out.println("1 - Deletar Região");
			System.out.println("2 - Deletar Area");
			System.out.println("3 - Deletar Edifício");
			System.out.println("4 - Deletar Cargo");
			System.out.println("5 - Deletar Funcionário");
			System.out.println("6 - Deletar Animal");
			System.out.println("7 - Voltar");
			opc = Console.readInt("Opção: ");
			switch(opc){
				case 1:
					deletarRegiao();
					break;
				case 2:
					deletarArea();
					break;
				case 3:
					deletarEdificio();
					break;
				case 4:
					deletarCargo();
					break;
				case 5:
					deletarFuncionario();
					break;
				case 6:
					deletarAnimal();
					break;
			}
		}while(opc != 7);
	}
	public static void deletarRegiao() {
		System.out.println("\n\n*** DELETAR REGIÃO ***");
		Regiao objRegiao = new Regiao();
		objRegiao.setNomeRegiao(Console.readString("Informe o nome da região: ").toUpperCase());
		objRegiao = RegiaoPersistencia.procurarPorNome(objRegiao);
		if(objRegiao != null) {
			if(RegiaoPersistencia.excluir(objRegiao) == true) {
				System.out.println("\n\nRegião excluída com sucesso...");
			}
			else {
				System.out.println("\n\nRegião não encontrada...");
			}
		}
	}
	public static void deletarArea() {
		System.out.println("\n\n*** DELETAR ÁREA ***");
		Area objArea = new Area();
		objArea.setNomeArea(Console.readString("Informe o nome da área: ").toUpperCase());
		objArea = AreaPersistencia.procurarPorNome(objArea);
		if(objArea != null) {
			if(AreaPersistencia.excluir(objArea) == true) {
				System.out.println("\n\nÁrea excluída com sucesso...");
			}
		}
		else {
			System.out.println("\n\nÁrea não encontrada...");
		}
	}
	public static void deletarEdificio() {
		System.out.println("\n\n*** DELETAR EDIFÍCIO ***");
		Edificio objEdificio = new Edificio();
		objEdificio.setNomeEdificio(Console.readString("Informe o nome do edifício: ").toUpperCase());
		objEdificio = EdificioPersistencia.procurarPorNome(objEdificio);
		if(objEdificio != null) {
			if(EdificioPersistencia.excluir(objEdificio) == true) {
				System.out.println("\n\nEdifício excluído com sucesso...");
			}
		}
		else {
			System.out.println("\n\nEdifício não encontrado...");
		}
	}
	public static void deletarCargo() {
		System.out.println("\n\n*** DELETAR CARGO ***");
		Cargo objCargo = new Cargo();
		objCargo.setNomeCargo(Console.readString("Informe o nome do cargo: ").toUpperCase());
		objCargo = CargoPersistencia.procurarPorNome(objCargo);
		if(objCargo != null) {
			if(CargoPersistencia.excluir(objCargo) == true) {
				System.out.println("\n\nCargo excluído com sucesso...");
			}
		}
		else {
			System.out.println("\n\nCargo não encontrado...");
		}
	}
	public static void deletarFuncionario() {
		System.out.println("\n\n*** DELETAR FUNCIONÁRIO ***");
		Funcionario objFuncionario = new Funcionario();
		objFuncionario.setNomeFuncionario(Console.readString("Informe o nome do funcionário: ").toUpperCase());
		objFuncionario = FuncionarioPersistencia.procurarPorNome(objFuncionario);
		if(objFuncionario != null) {
			if(FuncionarioPersistencia.excluir(objFuncionario) == true) {
				System.out.println("\n\nFuncionário excluído com sucesso...");
			}
		}
		else {
			System.out.println("\n\nFuncionário não encontrado...");
		}
	}
	public static void deletarAnimal() {
		System.out.println("\n\n*** DELETAR ANIMAL ***");
		Animal objAnimal = new Animal();
		objAnimal.setNome(Console.readString("Informe o nome do animal: ").toUpperCase());
		objAnimal = AnimalPersistencia.procurarPorNome(objAnimal);
		if(objAnimal != null) {
			if(AnimalPersistencia.excluir(objAnimal) == true) {
				System.out.println("\n\nAnimal excluído com sucesso...");
			}
		}
		else {
			System.out.println("\n\nAnimal não encontrado...");
		}
	}
}

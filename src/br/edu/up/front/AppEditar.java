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

public class AppEditar {
	public AppEditar() {
		int opc;
		do{
			System.out.println("\n\n*** EDIÇÃO ***");
			System.out.println("1 - Editar Região");
			System.out.println("2 - Editar Area");
			System.out.println("3 - Editar Edifício");
			System.out.println("4 - Editar Cargo");
			System.out.println("5 - Editar Funcionário");
			System.out.println("6 - Editar Animal");
			System.out.println("7 - Voltar");
			opc = Console.readInt("Opção: ");
			switch(opc){
				case 1:
					editarRegiao();
					break;
				case 2:
					editarArea();
					break;
				case 3:
					editarEdificio();
					break;
				case 4:
					editarCargo();
					break;
				case 5:
					editarFuncionario();
					break;
				case 6:
					editarAnimal();
					break;
			}
		}while(opc != 7);
	}
	
	public static void editarRegiao() {
		System.out.println("\n\n*** EDITAR REGIÃO ***");
		Regiao objRegiao = new Regiao();
		objRegiao.setNomeRegiao(Console.readString("Informe o nome da região: ").toUpperCase());
		objRegiao = RegiaoPersistencia.procurarPorNome(objRegiao);
		if(objRegiao != null) {
			System.out.println("\n\n-------------------------");
			System.out.println("Nome da Regiao: " + objRegiao.getNomeRegiao());
			System.out.println("-------------------------");
			objRegiao.setNomeRegiao(Console.readString("Informe o novo nome da região: ").toUpperCase());
			if(RegiaoPersistencia.alterar(objRegiao) == true) {
				System.out.println("\n\nRegião alterada com sucesso...");
			}
			else {
				System.out.println("\n\nÁrea não alterada...");
			}
		}
		else {
			System.out.println("\n\nRegião não encontrada...");
		}
	}
	public static void editarArea() {
		System.out.println("\n\n*** EDITAR ÁREA ***");
		Area objArea = new Area();
		objArea.setNomeArea(Console.readString("Informe o nome da área: ").toUpperCase());
		objArea = AreaPersistencia.procurarPorNome(objArea);
		if(objArea != null) {
			System.out.println("\n\n-------------------------");
			System.out.println("Nome da área: " + objArea.getNomeArea());
			System.out.println("Capacidade da área: " + objArea.getCapacidadeEspaco());
			System.out.println("Espaco livre atual: " + objArea.getEspacoLivre());
			System.out.println("-------------------------");
			objArea.setNomeArea(Console.readString("Informe o novo nome da área: ").toUpperCase());
			objArea.setCapacidadeEspaco(Console.readInt("Informe a nova capacidade da área: "));
			objArea.setEspacoLivre(Console.readInt("Informe o espaco livre atual da área: "));
			if(objArea.getEspacoLivre() > objArea.getCapacidadeEspaco()) {
				do {
					objArea.setEspacoLivre(Console.readInt("O espaco livre nao pode ser maior que a capacidade da área!\nInforme um valor igual ou menor: "));
				}while(objArea.getEspacoLivre() > objArea.getCapacidadeEspaco());
			}
			if(AreaPersistencia.alterar(objArea) == true) {
				System.out.println("\n\nÁrea alterada com sucesso...");
			}
			else {
				System.out.println("\n\nÁrea não alterada");
			}
		}
		else {
			System.out.println("\n\nÁrea não encontrada...");
		}
	}
	public static void editarEdificio() {
		System.out.println("\n\n*** EDITAR EDIFÍCIO ***");
		Edificio objEdificio = new Edificio();
		objEdificio.setNomeEdificio(Console.readString("Informe o nome do edifício: "));
		objEdificio = EdificioPersistencia.procurarPorNome(objEdificio);
		if(objEdificio != null) {
			System.out.println("\n\n-------------------------");
			System.out.println("Nome do edifício: " + objEdificio.getNomeEdificio());			
			System.out.println("-------------------------");
			objEdificio.setNomeEdificio(Console.readString("Informe o novo nome do edifício: ").toUpperCase());
			if(EdificioPersistencia.alterar(objEdificio) == true) {
				System.out.println("\n\nEdifício alterado com sucesso...");
			}
			else {
				System.out.println("\n\nEdifício não alterado...");
			}
		}
		else {
			System.out.println("\n\nEdifício não encontrado...");
		}
	}
	public static void editarCargo() {
		System.out.println("\n\n*** EDITAR CARGO ***");
		Cargo objCargo = new Cargo();
		objCargo.setNomeCargo(Console.readString("Informe o nome do cargo: "));
		objCargo = CargoPersistencia.procurarPorNome(objCargo);
		if(objCargo != null) {
			System.out.println("\n\n-------------------------");
			System.out.println("Nome do cargo: " + objCargo.getNomeCargo());
			System.out.println("Salário do cargo: R$" + objCargo.getSalario());
			System.out.println("Atribuições do cargo: " + objCargo.getAtribuicoes());
			System.out.println("-------------------------");
			objCargo.setNomeCargo(Console.readString("Informe o novo nome do cargo: "));
			objCargo.setSalario(Console.readFloat("Informe o novo salário do cargo: "));
			objCargo.setAtribuicoes(Console.readString("Informe as novas atribuições do cargo: "));
			if(CargoPersistencia.alterar(objCargo) == true) {
				System.out.println("\n\nCargo alterado com sucesso...");
			}
			else {
				System.out.println("\n\nCargo não alterado...");
			}
		}
		else {
			System.out.println("\n\nCargo não encontrado...");
		}
	}
	public static void editarFuncionario() {
		System.out.println("\n\n*** EDITAR FUNCIONÁRIO ***");
		Funcionario objFuncionario = new Funcionario();
		objFuncionario.setNomeFuncionario(Console.readString("Informe o nome do funcionário: ").toUpperCase());
		objFuncionario = FuncionarioPersistencia.procurarPorNome(objFuncionario);
		if(objFuncionario != null) {
			System.out.println("\n\n-------------------------");
			System.out.println("Nome do funcionário: " + objFuncionario.getNomeFuncionario());
			System.out.println("CPF do funcionário: " + objFuncionario.getCpf());
			System.out.println("Cargo do funcionário: " + objFuncionario.getCargo().getNomeCargo());
			System.out.println("-------------------------");
			objFuncionario.setNomeFuncionario(Console.readString("Informe a alteração do nome: ").toUpperCase());
			objFuncionario.setCpf(Console.readString("Informe o novo CPF: "));
			Cargo objCargo = new Cargo();
			objCargo.setNomeCargo(Console.readString("Informe o nome do novo cargo: ").toUpperCase());
			objCargo = CargoPersistencia.procurarPorNome(objCargo);
			if(objCargo != null) {
				objFuncionario.setCargo(objCargo);
				if(FuncionarioPersistencia.alterar(objFuncionario) == true) {
					System.out.println("\n\nFuncionário alterado com sucesso...");
				}
				else {
					System.out.println("Funcionário não alterado...");
				}
			}
			else {
				System.out.println("\n\nCargo não encontrado...");
			}
		}
		else {
			System.out.println("\n\nFuncionário não encontrado...");
		}
	}
	public static void editarAnimal() {
		System.out.println("\n\n*** EDITAR ANIMAL ***");
		Animal objAnimal = new Animal();
		objAnimal.setNome(Console.readString("Informe o nome do animal: ").toUpperCase());
		objAnimal = AnimalPersistencia.procurarPorNome(objAnimal);
		if(objAnimal != null) {
			System.out.println("\n\n-------------------------");
			System.out.println("Nome do animal: " + objAnimal.getNome());
			System.out.println("Tipo do animal: " + objAnimal.getTipo());
			System.out.println("Ordem do animal: " + objAnimal.getOrdem());
			System.out.println("Alimentação do animal: " + objAnimal.getAlimentacao());
			System.out.println("Gênero do animal: " + objAnimal.getGenero());
			System.out.println("Idade do animal: " + objAnimal.getIdade());
			System.out.println("Peso do animal: " + objAnimal.getPeso());
			System.out.println("Tamanho do animal: " + objAnimal.getTamanho());
			System.out.println("Area do animal: " + objAnimal.getArea().getNomeArea());
			System.out.println("-------------------------");
			Area objArea1 = new Area();
			objArea1 = objAnimal.getArea();
			objArea1.getAnimais().remove(objAnimal);
			objArea1.setEspacoLivre(objArea1.getEspacoLivre() + 1);
			AreaPersistencia.alterar(objArea1);
			objAnimal.setNome(Console.readString("Informe o novo nome do animal: ").toUpperCase());
			objAnimal.setAlimentacao(Console.readString("Informe a nova alimentação do animal: "));
			objAnimal.setIdade(Console.readInt("Informe a nova idade do animal: "));
			objAnimal.setPeso(Console.readFloat("Informe o novo peso do animal: "));
			objAnimal.setTamanho(Console.readFloat("Informe o novo tamanho do animal: "));
			Area objArea2 = new Area();
			objArea2.setNomeArea(Console.readString("Informe o ID da nova área do animal: "));
			objArea2 = AreaPersistencia.procurarPorId(objArea2);
			if(objArea2 != null) {
				objAnimal.setArea(objArea2);
				if(AnimalPersistencia.alterar(objAnimal) == true) {
					objArea2.getAnimais().add(objAnimal);
					objArea2.setEspacoLivre(objArea2.getEspacoLivre() + 1);
					AreaPersistencia.alterar(objArea2);
					System.out.println("\n\nAnimal alterado com sucesso...");
				}
				else {
					System.out.println("\n\nAnimal não alterado...");
				}
			}
			else {
				System.out.println("\n\nÁrea não encontrada...");
			}
		}
		else {
			System.out.println("\n\nAnimal não encontrado...");
		}
	}
}

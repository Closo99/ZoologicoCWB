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

public class AppConsultar {
	public AppConsultar() {
		int opc;
		do{
			System.out.println("\n\n*** CONSULTA ***");
			System.out.println("1 - Consultar Regiao");
			System.out.println("2 - Consultar Area");
			System.out.println("3 - Consultar Edificio");
			System.out.println("4 - Consultar Cargo");
			System.out.println("5 - Consultar Funcionario");
			System.out.println("6 - Consultar Animal");
			System.out.println("7 - Voltar");
			opc = Console.readInt("Opção: ");
			switch(opc){
				case 1:
					consultarRegiao();
					break;
				case 2:
					consultarArea();
					break;
				case 3:
					consultarEdificio();
					break;
				case 4:
					consultarCargo();
					break;
				case 5:
					consultarFuncionario();
					break;
				case 6:
					consultarAnimal();
					break;			
			}
		}while(opc != 7);
	}
	
	
	public static void consultarRegiao() {
		System.out.println("\n\n*** CONSULTAR REGIAO ***");
		Regiao objRegiao = new Regiao();
		objRegiao.setNomeRegiao(Console.readString("Informe o nome da regiao: ").toUpperCase());
		objRegiao = RegiaoPersistencia.procurarPorNome(objRegiao);
		if(objRegiao != null) {
			System.out.println("\n\n-------------------------");
			System.out.println("ID da Regiao: " + objRegiao.getId());
			System.out.println("Nome da Regiao: " + objRegiao.getNomeRegiao());
			if(!objRegiao.getAreas().isEmpty()) {
				System.out.println("..........AREAS NA REGIAO:");
				for(Area area : objRegiao.getAreas()) {
					System.out.println("ID: " + area.getId());
					System.out.println("Nome: " + area.getNomeArea());
					System.out.println("................");
				}
			}
			if(!objRegiao.getEdificios().isEmpty()) {
				System.out.println("..........EDIFICIOS NA REGIAO:");
				for(Edificio edificio : objRegiao.getEdificios()) {
					System.out.println("ID: " + edificio.getId());
					System.out.println("Nome: " + edificio.getNomeEdificio());
					System.out.println("................");
				}
			}
			System.out.println("-------------------------");
		}
		else {
			System.out.println("\n\nRegiao nao encontrada...");
		}
	}
	public static void consultarArea() {
		System.out.println("\n\n*** CONSULTAR AREA ***");
		Area objArea = new Area();
		objArea.setNomeArea(Console.readString("Informe o nome da area: ").toUpperCase());
		objArea = AreaPersistencia.procurarPorNome(objArea);
		if(objArea != null) {
			System.out.println("\n\n-------------------------");
			System.out.println("ID da Area: " + objArea.getId());
			System.out.println("Nome da Area: " + objArea.getNomeArea());
			System.out.println("Capacidade da Area: " + objArea.getCapacidadeEspaco());
			System.out.println("Espaço livre na Area: " + objArea.getEspacoLivre());
			System.out.println("Regiao da Area: " + objArea.getRegiao().getNomeRegiao());
			System.out.println("-------------------------");
		}
		else {
			System.out.println("\n\nArea não encontrada...");
		}
	}
	public static void consultarEdificio() {
		System.out.println("\n\n*** CONSULTAR EDIFICIO ***");
		Edificio objEdificio = new Edificio();
		objEdificio.setNomeEdificio(Console.readString("Informe o nome do edificio: ").toUpperCase());
		objEdificio = EdificioPersistencia.procurarPorNome(objEdificio);
		if(objEdificio != null) {
			System.out.println("\n\n-------------------------");
			System.out.println("ID do Edificio: " + objEdificio.getId());
			System.out.println("Nome do Edificio: " + objEdificio.getNomeEdificio());
			System.out.println("Regiao do Edificio: " + objEdificio.getRegiao().getNomeRegiao());
			System.out.println("-------------------------");
		}
		else {
			System.out.println("\n\nEdifício não encontrado...");
		}
	}
	public static void consultarCargo() {
		System.out.println("\n\n*** CONSULTAR CARGO ***");
		Cargo objCargo = new Cargo();
		objCargo.setNomeCargo(Console.readString("Informe o nome do cargo: ").toUpperCase());
		objCargo = CargoPersistencia.procurarPorNome(objCargo);
		if(objCargo != null) {
			System.out.println("\n\n-------------------------");
			System.out.println("Nome do Cargo: " + objCargo.getNomeCargo());
			System.out.println("Salário do Cargo: R$" + objCargo.getSalario());
			System.out.println("Atribuicoes do Cargo: " + objCargo.getAtribuicoes());
			System.out.println("-------------------------");
		}
		else {
			System.out.println("\n\nCargo não encontrado...");
		}
	}
	public static void consultarFuncionario() {
		System.out.println("\n\n*** CONSULTAR FUNCIONÁRIO ***");
		Funcionario objFuncionario = new Funcionario();
		objFuncionario.setNomeFuncionario(Console.readString("Informe o nome do funcionário: ").toUpperCase());
		objFuncionario = FuncionarioPersistencia.procurarPorNome(objFuncionario);
		if(objFuncionario != null) {
			System.out.println("\n\n-------------------------");
			System.out.println("ID do Funcionário: " + objFuncionario.getId());
			System.out.println("Nome do Funcionário: " + objFuncionario.getNomeFuncionario());
			System.out.println("CPF do Funcionário: " + objFuncionario.getCpf());
			System.out.println("Cargo do Funcionário: " + objFuncionario.getCargo().getNomeCargo());
			System.out.println("Salário: R$" + objFuncionario.getCargo().getSalario());
			System.out.println("-------------------------");
		}
		else {
			System.out.println("\n\nFuncionário não encontrado...");
		}
	}
	public static void consultarAnimal() {
		System.out.println("\n\n*** CONSULTAR ANIMAL ***");
		Animal objAnimal = new Animal();
		objAnimal.setNome(Console.readString("Informe o nome do animal: ").toUpperCase());
		objAnimal = AnimalPersistencia.procurarPorNome(objAnimal);
		if(objAnimal != null) {
			System.out.println("\n\n-------------------------");
			System.out.println("ID do Animal: " + objAnimal.getId());
			System.out.println("Nome do Animal: " + objAnimal.getNome());
			System.out.println("Tipo do Animal: " + objAnimal.getTipo());
			System.out.println("Ordem do Animal: " + objAnimal.getOrdem());
			System.out.println("Gênero do Animal: " + objAnimal.getGenero());
			System.out.println("Alimentação do Animal: " + objAnimal.getAlimentacao());
			System.out.println("Idade do Animal: " + objAnimal.getIdade());
			System.out.println("Peso do Animal(kg): " + objAnimal.getPeso());
			System.out.println("Tamanho do Animal(m):" + objAnimal.getTamanho());
			System.out.println("Área do Animal: " + objAnimal.getArea().getNomeArea());
			System.out.println("-------------------------");
		}
	}
}

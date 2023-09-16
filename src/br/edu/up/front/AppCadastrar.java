package br.edu.up.front;

import br.edu.up.entidade.Animal;
import br.edu.up.entidade.Area;
import br.edu.up.entidade.Cargo;
import br.edu.up.entidade.Edificio;
import br.edu.up.entidade.Funcionario;
import br.edu.up.entidade.Regiao;
import br.edu.up.negocio.FuncionarioNegocio;
import br.edu.up.persistencia.AnimalPersistencia;
import br.edu.up.persistencia.AreaPersistencia;
import br.edu.up.persistencia.CargoPersistencia;
import br.edu.up.persistencia.EdificioPersistencia;
import br.edu.up.persistencia.FuncionarioPersistencia;
import br.edu.up.persistencia.RegiaoPersistencia;

public class AppCadastrar {
	public AppCadastrar() {
		int opc;
		do{
			System.out.println("\n\n*** CADASTRO ***");
			System.out.println("1 - Cadastrar Região");
			System.out.println("2 - Cadastrar Área");
			System.out.println("3 - Cadastrar Edifício");
			System.out.println("4 - Cadastrar Cargo");
			System.out.println("5 - Cadastrar Funcionário");			
			System.out.println("6 - Cadastrar Animal");
			System.out.println("7 - Voltar");
			opc = Console.readInt("Opção: ");
			switch(opc){
				case 1:
					cadastrarRegiao();
					break;
				case 2:
					cadastrarArea();
					break;
				case 3:
					cadastrarEdificio();
					break;
				case 4:
					cadastrarCargo();
					break;
				case 5:
					cadastrarFuncionario();
					break;
				case 6:
					cadastrarAnimal();
					break;
			}
		}while(opc != 7);
	}
	
	
	private static void cadastrarRegiao(){
		System.out.println("\n\n*** CADASTRAR REGIAO ***");
		Regiao objRegiao = new Regiao();
		objRegiao.setNomeRegiao(Console.readString("\n\nInforme o nome da regiao: ").toUpperCase());
		if(RegiaoPersistencia.procurarPorNome(objRegiao) == null) {
			if(RegiaoPersistencia.incluir(objRegiao) == true) {
				System.out.println("\n\nCadastro da Regiao bem sucedida...");
			}
			else {
				System.out.println("\n\nCadastro da Regiao mal sucedida...");
			}
		}
		else {
			System.out.println("\n\nRegiao já cadastrada...");
		}
	}
	private static void cadastrarArea(){
		System.out.println("\n\n*** CADASTRAR AREA ***");
		Regiao objRegiao = new Regiao();
		objRegiao.setNomeRegiao(Console.readString("Informe o nome da região onde deseja cadastrar a Area: ").toUpperCase());
		objRegiao = RegiaoPersistencia.procurarPorNome(objRegiao);
		if(objRegiao != null) {
			Area objArea = new Area();
			objArea.setNomeArea(Console.readString("Informe o nome da Area: ").toUpperCase());		
			if(AreaPersistencia.procurarPorNome(objArea) == null) {
				objArea.setCapacidadeEspaco(Console.readInt("Informe a capacidade da Area: "));
				objArea.setEspacoLivre(objArea.getCapacidadeEspaco());
				objArea.setRegiao(objRegiao);
				if(AreaPersistencia.incluir(objArea) == true) {
					objRegiao.getAreas().add(objArea);
					RegiaoPersistencia.alterar(objRegiao);
					System.out.println("\n\nCadastro da Área bem sucedido...");					
				}
				else {
					System.out.println("\n\nCadastro da Área mal sucedido...");
				}
			}
			else {
				System.out.println("\n\nÁrea já cadastrada...");
			}
		}
		else {
			System.out.println("\n\nRegião não encontrada...");
		}
	}
	private static void cadastrarEdificio() {
		System.out.println("\n\n*** CADASTRAR EDIFÍCIO ***");
		Regiao objRegiao = new Regiao();
		objRegiao.setNomeRegiao(Console.readString("Informe o nome da região onde deseja cadastrar o edifício: ").toUpperCase());
		objRegiao = RegiaoPersistencia.procurarPorNome(objRegiao);
		if(objRegiao != null) {
			Edificio objEdificio = new Edificio();
			objEdificio.setNomeEdificio(Console.readString("Informe o nome do edifício: ").toUpperCase());
			if(EdificioPersistencia.procurarPorNome(objEdificio) == null) {
				objEdificio.setRegiao(objRegiao);
				if(EdificioPersistencia.incluir(objEdificio) == true) {					
					objRegiao.getEdificios().add(objEdificio);
					RegiaoPersistencia.alterar(objRegiao);				
					System.out.println("\n\nCadastro do Edifício bem sucedido...");
				}
				else {
					System.out.println("\n\nCadastro do Edifício mal sucedido...");
				}
			}
			else {
				System.out.println("\n\nEdifício já cadastrado...");
			}
		}
		else {
			System.out.println("\n\nRegião não encontrada...");
		}
	}
	private static void cadastrarCargo() {
		System.out.println("\n\n*** CADASTRAR CARGO ***");
		Cargo objCargo = new Cargo();
		objCargo.setNomeCargo(Console.readString("Informe o nome do cargo: ").toUpperCase());
		if(CargoPersistencia.procurarPorNome(objCargo) == null) {
			objCargo.setAtribuicoes(Console.readString("Informe as atribuições do cargo: "));
			objCargo.setSalario(Console.readFloat("Informe o salário do cargo: R$"));
			if(CargoPersistencia.incluir(objCargo) == true) {
				System.out.println("\n\nCadastro do cargo bem sucedido...");
			}
		}
		else {
			System.out.println("\n\nCargo já cadastrado...");
		}
	}
	private static void cadastrarFuncionario() {
		System.out.println("\n\n*** CADASTRAR FUNCIONÁRIO ***");
		Cargo objCargo = new Cargo();
		objCargo.setNomeCargo(Console.readString("Informe o nome do cargo: ").toUpperCase());
		objCargo = CargoPersistencia.procurarPorNome(objCargo);
		if(objCargo != null) {
			Funcionario objFuncionario = new Funcionario();
			objFuncionario.setCpf(Console.readString("Informe o CPF do funcionário: "));
			if(FuncionarioNegocio.isCPF(objFuncionario.getCpf())) {
				if(FuncionarioPersistencia.procurarPorCPF(objFuncionario) == null) {
					objFuncionario.setNomeFuncionario(Console.readString("Informe o nome do funcionário: ").toUpperCase());
					objFuncionario.setCargo(objCargo);
					if(FuncionarioPersistencia.incluir(objFuncionario) == true) {
						objCargo.getFuncionarios().add(objFuncionario);
						CargoPersistencia.alterar(objCargo);
						System.out.println("\n\nCadastro do funcionário bem sucedido");
					}
				}
				else {
					System.out.println("\n\nCPF já cadastrado...");
				}
			}
			else {
				System.out.println("\n\nCPF inválido...");
			}
		}
		else {
			System.out.println("\n\nCargo inexistente...");
		}		
	}
	private static void cadastrarAnimal() {
		System.out.println("\n\n*** CADASTRAR ANIMAL ***");
		Area objArea = new Area();
		objArea.setNomeArea(Console.readString("Informe o nome da área: ").toUpperCase());
		objArea = AreaPersistencia.procurarPorNome(objArea);
		if(objArea != null) {
			if(objArea.getEspacoLivre() >= 1) {
				Animal objAnimal = new Animal();
				objAnimal.setNome(Console.readString("Informe o nome do animal: ").toUpperCase());
				if(AnimalPersistencia.procurarPorNome(objAnimal) == null) {
					objAnimal.setTipo(Console.readString("Informe o tipo do animal: "));
					objAnimal.setOrdem(Console.readString("Informe a ordem do animal: "));
					objAnimal.setAlimentacao(Console.readString("Informe a alimentação do animal: "));
					objAnimal.setGenero(Console.readString("Informe o gênero do animal: "));
					objAnimal.setIdade(Console.readInt("Informe a idade do animal: "));
					objAnimal.setPeso(Console.readFloat("Informe o peso do animal(kg): "));
					objAnimal.setTamanho(Console.readFloat("Informe o tamanho do animal(m): "));
					objAnimal.setArea(objArea);
					if(AnimalPersistencia.incluir(objAnimal) == true) {
						objArea.getAnimais().add(objAnimal);
						objArea.setEspacoLivre(objArea.getEspacoLivre() - 1);
						AreaPersistencia.alterar(objArea);
						System.out.println("\n\nCadastro do animal bem sucedido...");
					}
					else {
						System.out.println("\n\nCadastro do animal mal sucedido...");
					}
				}
				else {
					System.out.println("\n\nAnimal já cadastrado...");
				}
			}
			else {
				System.out.println("\n\nEspaco livre na area insuficiente...");
			}
		}
		else {
			System.out.println("\n\nÁrea não encontrada...");
		}
	}
}

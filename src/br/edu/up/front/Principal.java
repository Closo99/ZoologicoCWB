package br.edu.up.front;

public class Principal {

	public static void main(String[] args) {
		int opc;
		do{
			System.out.println("\n\n");
			System.out.println("*** MENU PRINCIPAL ***");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Pesquisar");
			System.out.println("3 - Listar");
			System.out.println("4 - Consultar");
			System.out.println("5 - Editar");
			System.out.println("6 - Deletar");
			System.out.println("7 - Sair");
			opc = Console.readInt("Opção: ");
			switch(opc){
				case 1:
					new AppCadastrar();
					break;
				case 2:
					new AppPesquisar();
					break;
				case 3:
					new AppListar();
					break;
				case 4:
					new AppConsultar();
					break;
				case 5:
					new AppEditar();
					break;
				case 6:
					new AppDeletar();
					break;
			}
		}while(opc != 7);

	}

}

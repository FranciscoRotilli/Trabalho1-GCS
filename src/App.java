import java.util.*;

public class App {
    private Equipe equipe;
    private Scanner in;

    public App(){
        equipe = new Equipe();
        in = new Scanner(System.in);
    }

    public void executar() {
        int opcao;
        menu();
        System.out.println("Digite a opção desejada: ");
        opcao = in.nextInt();

//        adicionar os métodos
        switch (opcao){
            case 1:
                addFuncionario();
                break;

            case 2:

                break;

            case 3:

                break;

            case 4:

                break;

            case 5:

                break;

            case 6:

                break;

            case 7:

                break;

            case 8:

                break;

            case 9:

                break;

            case 10:

                break;

            case 11:

                break;

            case 12:

                break;
        }
    }

    public void menu(){
        System.out.println("=============================");
        System.out.println("[1] - Cadastrar funcionário");
        System.out.println("[2] - Editar o nome de um funcionário");
        System.out.println("[3] - Editar o email de um funcionário");
        System.out.println("[4] - Cadastrar equipamento");
        System.out.println("[5] - Status de um equipamento");
        System.out.println("[6] - Buscar funcionário");
        System.out.println("[7] - Buscar equipamento");
        System.out.println("[8] - Registrar um pedido de manutenção");
        System.out.println("[9] - Atualizar um pedido de manutenção");
        System.out.println("[10] - Gerar relatório");
        System.out.println("[11] - Gerar histórico de manutenção");
        System.out.println("[12] - "); // Opcao adicional ainda não implementada
    }

    public void addFuncionario(){
        String nome, email;
        System.out.println("=============================");
        System.out.println("Digite o nome do cliente");
            nome = in.next();

        System.out.println("Digite o email do cliente");
            email = in.next();

        if(equipe.cadastraFuncionario(nome, email))
            System.out.println("Cliente cadastrado com sucesso");
        else
            System.out.println("Erro, nome ou email inválido");
    }
}

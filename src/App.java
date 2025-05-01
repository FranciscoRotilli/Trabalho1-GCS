import java.time.LocalDate;
import java.util.*;

public class App {
    private Equipe equipe;
    private Scanner in;
    private Equipamentos equipamentos;
    private Manutencoes manutencoes;

    public App(){
        equipe = new Equipe();
        in = new Scanner(System.in);
        equipamentos = new Equipamentos();
        manutencoes = new Manutencoes();
    }

    public void executar() {
        int opcao=0;
        do {
            menu();
            System.out.println("Digite a opção desejada: ");
            opcao = in.nextInt();

//        adicionar os métodos
        switch (opcao){
            case 1:
                addFuncionario();
                break;

            case 2:
                alteraNome();
                break;

            case 3:
                alteraEmail();
                break;

            case 4:
                addEquipamento();
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
                gerarRelatorioEquipamentos();
                break;
            
            case 11:

                break;

            case 12:
            acompanharManutencoesPendentesEAtivas();
            break;
        }

        }while (opcao != 0);
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
        System.out.println("[12] - Acompanhar manutenções pendentes e atrasadas");

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

    public void alteraNome(){
        String nome;
        System.out.println("=============================");
        System.out.println("Digite o nome do cliente que deseja alterar");
            nome = in.next();
        ArrayList<Funcionario> funcionarios = equipe.encontraFuncionario(nome);
        if(funcionarios.size() > 0){
            System.out.println("Digite o novo nome do cliente");
                nome = in.next();
            for (Funcionario funcionario : funcionarios) {
                if (equipe.alteraNome(funcionario, nome)) {
                    System.out.println("Nome alterado com sucesso");
                } else {
                    System.out.println("Erro, nome inválido ou já cadastrado");
                }
            }
        }
    }

    public void alteraEmail(){
        String email;   
        System.out.println("=============================");
        System.out.println("Digite o nome do cliente que deseja alterar");
            email = in.next();
        ArrayList<Funcionario> funcionarios = equipe.encontraFuncionario(email);
        if(funcionarios.size() > 0){
            System.out.println("Digite o novo email do cliente");
                email = in.next();
            for (Funcionario funcionario : funcionarios) {
                if (equipe.alteraEmail(funcionario, email)) {
                    System.out.println("Email alterado com sucesso");
                } else {
                    System.out.println("Erro, email inválido ou já cadastrado");
                }
            }
        }
    }
    public void addEquipamento(){
        String nome, descricao, pesquisaFuncionario;
        Equipamento.Tipo tipo;
        double valorAquisicao;
        Funcionario responsavel;
        int opcao;

        System.out.println("Digite o nome do equipamento");
        nome=in.next();
        System.out.println("Digite o tipo do equipamento (digite: FIXO ou MOVEL.)");
        tipo = Equipamento.Tipo.valueOf(in.next());
        System.out.println("Dê uma descrição do equipamento: ");
        descricao = in.next();
        System.out.println("Digite o valor do equipamento: ");
        valorAquisicao = in.nextDouble();
        System.out.println("Digite o nome ou email do responsavel pelo equipamento: ");
        pesquisaFuncionario=in.next();
        System.out.println("Resultados da esquisa: ");
        for(int i=0; i<equipe.encontraFuncionario(pesquisaFuncionario).size(); i++) {
            System.out.println("\n"+"["+i+"] " +"Nome: "+ equipe.encontraFuncionario(pesquisaFuncionario).get(i).getNomeCompleto()+", Email: "+equipe.encontraFuncionario(pesquisaFuncionario).get(i).getEmail());
        }
        System.out.println("\nEscolha o responsavel pelo equipamento digitando o numero a esquerda do funcionario desejado: ");
        opcao=in.nextInt();
        responsavel=equipe.encontraFuncionario(pesquisaFuncionario).get(opcao);

        if(equipamentos.cadastraEquipamento(nome, tipo, descricao, valorAquisicao, responsavel)){
            System.out.println("Equipamento cadastrado com sucesso.");
        }
        else{
            System.out.println("Erro: Equipamento nao cadastrado.");
        }
    }
        public void acompanharManutencoesPendentesEAtivas() {
    System.out.println("Acompanhamento de Manutenções Pendentes e Atrasadas:");
    for (Manutencao manutencao : manutencoes.getManutencoes()) {
        // Verificar se a manutenção ainda está pendente (status 0 ou 1)
        if (manutencao.getStatus() == 0 || manutencao.getStatus() == 1) {
            System.out.println("Equipamento: " + manutencao.getEquipamento().getNome());
            System.out.println("Problema: " + manutencao.getDescProblema());
            System.out.println("Responsável: " + manutencao.getResponsavel().getNomeCompleto());

            // Verificar se a manutenção está atrasada
            if (manutencao.getStatus() == 1 && manutencao.getDataRetorno() == null) {
                if (manutencao.getDataPedido().plusDays(7).isBefore(LocalDate.now())) {  // Exemplo: atraso de 7 dias
                    System.out.println("Status: Atrasada (mais de 7 dias)");
                } else {
                    System.out.println("Status: Em andamento");
                }
            } else if (manutencao.getStatus() == 0) {
                System.out.println("Status: Solicitada, aguardando atendimento");
            }

            System.out.println("----------------------------");
        }
    }
    }

    public void gerarRelatorioEquipamentos() {
        ArrayList<Equipamento> listaEquipamentos = equipamentos.getEquipamentos();
    
        if (listaEquipamentos.isEmpty()) {
            System.out.println("Nenhum equipamento cadastrado.");
            return;
        }
    
        System.out.println("Relatório de Equipamentos:\n");
        for (Equipamento e : listaEquipamentos) {
            String nome = e.getNome();
            String responsavel = e.getResponsavel().getNomeCompleto();
    
            int manutencoesConcluidas = 0;
            boolean emAndamento = false;
    
            for (Manutencao m : e.getManutencoes()) {
                if (m.getStatus() == 2) {
                    manutencoesConcluidas++;
                } else if (m.getStatus() == 1) {
                    emAndamento = true;
                }
            }
    
            System.out.print("Equipamento: " + nome);
            System.out.print(" | Responsável: " + responsavel);
            System.out.print(" | Manutenções Concluídas: " + manutencoesConcluidas);
            if (emAndamento) {
                System.out.print(" | [Em manutenção]");
            }
            System.out.println();  
    }
    
}
}

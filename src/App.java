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
        criar_dados_iniciais();
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
                busca();
                break;

            case 7:

                break;

            case 8:

                break;

            case 9:
                gerarRelatorioEquipamentos();
                break;
            
            case 10:

                break;

            case 11:
                acompanharManutencoesPendentesEAtivas();
                break;
        }

        }while (opcao != 0);
    }

    public void criar_dados_iniciais(){
        // Cria 6 funcionários com nomes em homenagem a figuras icônicas na tecnologia

        equipe.cadastraFuncionario("Linus Torvalds", "linus.torvalds@gcssolucoesdigitais.com.br");
        equipe.cadastraFuncionario("John Carmack", "john.carmack@gcssolucoesdigitais.com.br");
        equipe.cadastraFuncionario("Ada Lovelace", "ada.lovelace@gcssolucoesdigitais.com.br");
        equipe.cadastraFuncionario("Dennis Ritchie", "dennis.ritchie@gcssolucoesdigitais.com.br");
        equipe.cadastraFuncionario("Steve Wozniak", "steve.wosniak@gcssolucoesdigitais.com.br");
        equipe.cadastraFuncionario("Grace Hopper", "grace.hopper@gcssolucoesdigitais.com.br");

        // Cria 7 equipamentos e os cadastra na mesma hora

        equipamentos.cadastraEquipamento("Laptop Dell XPS", Equipamento.Tipo.MOVEL, "Laptop de alto desempenho com 16GB RAM", 4500.00, equipe.encontraFuncionarioPorMatricula(102));
        equipamentos.cadastraEquipamento("Macbook Pro M4", Equipamento.Tipo.MOVEL, "Laptop de alto desempenho com 16GB RAM", 12000.00, equipe.encontraFuncionarioPorMatricula(102));
        equipamentos.cadastraEquipamento("Servidor Lenovo Thinksystem", Equipamento.Tipo.FIXO, "Servidor Linux", 9500.00, equipe.encontraFuncionarioPorMatricula(101));
        equipamentos.cadastraEquipamento("Laptop HP G9", Equipamento.Tipo.MOVEL, "Laptop de médio desempenho com 8GB RAM", 2699.00, equipe.encontraFuncionarioPorMatricula(103));
        equipamentos.cadastraEquipamento("Laptop HP G9", Equipamento.Tipo.MOVEL, "Laptop de médio desempenho com 8GB RAM", 2699.00, equipe.encontraFuncionarioPorMatricula(104));
        equipamentos.cadastraEquipamento("HP Neverstop Laser", Equipamento.Tipo.FIXO, "Impressora de alto nível", 500.00, equipe.encontraFuncionarioPorMatricula(106));
        equipamentos.cadastraEquipamento("Laptop Dell XPS", Equipamento.Tipo.MOVEL, "Laptop de alto desempenho com 16GB RAM", 4500.00, equipe.encontraFuncionarioPorMatricula(106));
        // Cria 1 equipamento e depois o cadastra (Não funciona pois não há funcionalidade de criar um equipamento e depois adiciona-lo a lista)

        // Equipamento e = new Equipamento("Macbook Air M1", "Laptop de médio desempenho com 8GB RAM", LocalDate.of(2023, 5, 15), 5000.00, equipe.encontraFuncionarioPorMatricula(106), Equipamento.Tipo.MOVEL)
        // equipamentos.equipamentos.add(e)

    }

    public void menu(){
        System.out.println("=============================");
        System.out.println("[1] - Cadastrar funcionário");
        System.out.println("[2] - Editar o nome de um funcionário");
        System.out.println("[3] - Editar o email de um funcionário");
        System.out.println("[4] - Cadastrar equipamento");
        System.out.println("[5] - Status de um equipamento");
        System.out.println("[6] - Buscar funcionário/equipamento");
        System.out.println("[7] - Registrar um pedido de manutenção");
        System.out.println("[8] - Atualizar um pedido de manutenção");
        System.out.println("[9] - Gerar relatório");
        System.out.println("[10] - Gerar histórico de manutenção");
        System.out.println("[11] - Acompanhar manutenções pendentes e atrasadas");

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
        int matricula;
        Funcionario f;
        System.out.println("=============================");
        System.out.println("Digite a matrícula do Cliente que deseja alternar:");
        matricula = in.nextInt();
        f = equipe.encontraFuncionarioPorMatricula(matricula);
        System.out.println("Digite o novo nome do cliente:");
        String nome = in.next();
        if (equipe.alteraNome(f, nome)) {
            System.out.println("Nome alterado com sucesso");
        } else {
            System.out.println("Erro, nome inválido ou já cadastrado");
        }
    }
        

    public void alteraEmail(){
        int matricula;
        Funcionario f;
        System.out.println("=============================");
        System.out.println("Digite a matrícula do Cliente que deseja alternar:");
        matricula = in.nextInt();
        f = equipe.encontraFuncionarioPorMatricula(matricula);
        System.out.println("Digite o novo Email do cliente:");
        String nome = in.next();
        if (equipe.alteraNome(f, nome)) {
            System.out.println("Email alterado com sucesso");
        } else {
            System.out.println("Erro, Email inválido ou já cadastrado");
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
    public void busca() {
        String entrada;
        System.out.println("Digite a pesquisa aqui: ");
        in.nextLine();
        entrada = in.nextLine();
        ArrayList<Funcionario> resultadoFuncionarios = equipe.encontraFuncionario(entrada);
        ArrayList<Equipamento> resultadoEquipamentos = equipamentos.encontraEquipamentos(entrada);

        ArrayList<Object> resultados = new ArrayList<>();
        resultados.addAll(resultadoFuncionarios);
        resultados.addAll(resultadoEquipamentos);

        if (resultados.isEmpty()) {
            System.out.println("Nenhum resultado encontrado.");
            System.out.println("============================");
        } else {
            System.out.println("Resultados da pesquisa: ");
        }
        for (Object resultado : resultados) {
            Funcionario f;
            Equipamento e;
            if (resultado instanceof Funcionario) {
                f = (Funcionario) resultado;
                System.out.println("=================== Funcionário ===================");
                System.out.println(f);
                ArrayList<Equipamento> equipamentosResponsavel = equipamentos.encontraEquipamentosPorResponsavel(f);
                if (!equipamentosResponsavel.isEmpty()) {
                    System.out.println(
                        "------------------------------------------------" +
                        "\nEquipamentos sob responsabilidade: " +
                        "\n------------------------------------------------"
                    );
                    for (Equipamento eq : equipamentosResponsavel) {
                        System.out.println(eq);
                    }
                }
            } else if (resultado instanceof Equipamento) {
                e = (Equipamento) resultado;
                System.out.println("=================== Equipamento ===================");
                System.out.println(equipamentos.geraRelatorio(e));
            }
            System.out.println("===================================================");
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
            String responsavel = e.getResponsavelCompra().getNomeCompleto();
    
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

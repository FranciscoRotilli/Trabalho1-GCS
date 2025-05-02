import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Equipe equipe;
    private final Scanner in;
    private final Equipamentos equipamentos;

    public App() {
        equipe = new Equipe();
        in = new Scanner(System.in);
        equipamentos = new Equipamentos();
    }

    public void executar() {
        criar_dados_iniciais();
        int opcao = 0;
        do {
            menu();
            System.out.println("Digite a opção desejada: ");
            opcao = in.nextInt();

            switch (opcao) {
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
                    consultaStatusEquipamento();
                    break;

                case 6:
                    alteraStatusEquipamento();
                    break;

                case 7:
                    busca();
                    break;

                case 8:
                    registraPedidoManutencao();
                    break;

                case 9:
                    atualizarPedidoManutencao();
                    break;

                case 10:
                    gerarRelatorioEquipamentos();
                    break;

                case 11:
                    exibirHistoricoManutencao();
                    break;

                case 12:
                    acompanharManutencoesPendentesEAtivas();
                    break;

                default:
                    System.out.println("Opção inválida! Para sair digite 0.");
            }

        } while (opcao != 0);
    }

    public void criar_dados_iniciais() {
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
        equipamentos.cadastraEquipamento("Laptop Dell XPS", Equipamento.Tipo.MOVEL, "Laptop de alto desempenho com 16GB RAM", 4500.00, equipe.encontraFuncionarioPorMatricula(105));
    }

    public void menu() {
        System.out.println("=============================");
        System.out.println("[1] - Cadastrar funcionário");
        System.out.println("[2] - Editar o nome de um funcionário");
        System.out.println("[3] - Editar o email de um funcionário");
        System.out.println("[4] - Cadastrar equipamento");
        System.out.println("[5] - Status de um equipamento");
        System.out.println("[6] - Alterar status de um equipamento");
        System.out.println("[7] - Buscar funcionário/equipamento");
        System.out.println("[8] - Registrar um pedido de manutenção");
        System.out.println("[9] - Atualizar um pedido de manutenção");
        System.out.println("[10] - Gerar relatório");
        System.out.println("[11] - Gerar histórico de manutenção");
        System.out.println("[12] - Acompanhar manutenções pendentes e atrasadas");
        System.out.println("[0] - SAIR");
    }

    /**
     * Solicita ao usuário o nome e o e-mail de um funcionário e tenta cadastrá-lo na equipe.
     *
     * O metodo solicita interativamente que o usuário insira o nome e o e-mail de um funcionário.
     * Em seguida, utiliza o metodo `cadastraFuncionario` da classe `Equipe` para realizar o
     * cadastro. Caso o cadastro seja bem-sucedido, é exibida uma mensagem indicando sucesso.
     * Caso contrário, uma mensagem de erro é exibida informando que o nome ou o e-mail é inválido.
     *
     * Pré-condições:
     * - O objeto `in` deve estar configurado para entrada de dados.
     * - O objeto `equipe` deve estar inicializado.
     *
     * Regras de validação:
     * - O nome deve ter mais de 3 caracteres.
     * - O e-mail deve ter mais de 5 caracteres.
     *
     * Mensagens exibidas ao usuário:
     * - Sucesso: "Funcionário cadastrado com sucesso".
     * - Erro: "Erro, nome ou email inválido".
     */
    public void addFuncionario() {
        String nome, email;
        System.out.println("=============================");
        System.out.println("Digite o nome do funcionário");
        nome = in.next();

        System.out.println("Digite o email do funcionário");
        email = in.next();

        if (equipe.cadastraFuncionario(nome, email))
            System.out.println("Funcionário cadastrado com sucesso");
        else
            System.out.println("Erro, nome ou email inválido");
    }

    /**
     * Permite alterar o nome de um funcionário cadastrado.
     *
     * O metodo solicita ao usuário que informe a matrícula do funcionário cujo nome
     * será alterado. Em seguida, solicita o novo nome e realiza a validação utilizando
     * o metodo `alteraNome` da classe `Equipe`.
     *
     * Caso o novo nome seja válido e a alteração bem-sucedida, uma mensagem de sucesso
     * é exibida. Caso contrário, informa o erro ao usuário.
     *
     * Condições:
     * - A matrícula informada deve corresponder a um funcionário existente.
     * - O novo nome deve ter mais de 3 caracteres, não ser nulo e não ser igual ao nome atual do funcionário.
     *
     * Mensagens exibidas ao usuário:
     * - Sucesso: "Nome alterado com sucesso".
     * - Erro: "Erro, nome inválido ou já cadastrado".
     *
     * Pré-condições:
     * - O objeto `equipe` deve estar inicializado.
     * - O objeto `in` deve estar configurado para entrada de dados.
     */
    public void alteraNome() {
        int matricula;
        Funcionario f;
        System.out.println("=============================");
        System.out.println("Digite a matrícula do cliente cujo nome deseja alterar:");
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

    /**
     * Permite alterar o e-mail de um funcionário existente.
     *
     * O metodo solicita ao usuário a matrícula do funcionário cujo e-mail será alterado,
     * e em seguida solicita o novo e-mail a ser atribuído. A alteração é realizada utilizando
     * a lógica implementada no metodo `equipe.alteraNome`, reutilizando o parâmetro para validação
     * e atualização do e-mail.
     *
     * Caso a alteração seja bem-sucedida, uma mensagem de sucesso é exibida ao usuário.
     * Caso contrário, uma mensagem de erro é exibida, indicando que o e-mail é inválido
     * ou já foi cadastrado.
     *
     * Pré-condições:
     * - O objeto `equipe` deve estar inicializado.
     * - O objeto `in` deve estar configurado para entrada de dados.
     * - A matrícula digitada pelo usuário deve corresponder a um funcionário existente.
     *
     * Mensagens exibidas ao usuário:
     * - Sucesso: "Email alterado com sucesso".
     * - Erro: "Erro, Email inválido ou já cadastrado".
     */
    public void alteraEmail() {
        int matricula;
        Funcionario f;
        System.out.println("=============================");
        System.out.println("Digite a matrícula do cliente cujo email deseja alterar:");
        matricula = in.nextInt();
        f = equipe.encontraFuncionarioPorMatricula(matricula);
        System.out.println("Digite o novo email do cliente:");
        String nome = in.next();
        if (equipe.alteraNome(f, nome)) {
            System.out.println("Email alterado com sucesso");
        } else {
            System.out.println("Erro, Email inválido ou já cadastrado");
        }
    }

    /**
     * Adiciona um novo equipamento ao sistema com base nas informações fornecidas pelo usuário.
     *
     * Este metodo pede ao usuário os detalhes do equipamento, incluindo nome, tipo, descrição,
     * valor de aquisição, e o responsável pelo equipamento. Utiliza o metodo `cadastraEquipamento`
     * para registrar essas informações no sistema.
     *
     * Processo interativo:
     * - Solicita o nome do equipamento.
     * - Solicita o tipo do equipamento (FIXO ou MOVEL).
     * - Solicita uma descrição para o equipamento.
     * - Solicita o valor de aquisição do equipamento.
     * - Solicita o nome ou e-mail do responsável pelo equipamento e exibe uma lista de resultados
     *   correspondentes com base na busca.
     * - Solicita ao usuário a escolha do responsável pelo equipamento a partir da lista exibida.
     *
     * Validação:
     * - O tipo de equipamento deve ser FIXO ou MOVEL, de acordo com a enumeração `Equipamento.Tipo`.
     *
     * Resultado:
     * - Se o equipamento for cadastrado com sucesso, exibe a mensagem "Equipamento cadastrado com sucesso."
     * - Caso ocorra erro no registro do equipamento, exibe a mensagem "Erro: Equipamento nao cadastrado."
     *
     * Dependências:
     * - Requer que o objeto `in` esteja configurado para entrada de dados.
     * - Requer que os objetos `equipe` e `equipamentos` estejam previamente inicializados.
     */
    public void addEquipamento() {
        String nome, descricao, pesquisaFuncionario;
        Equipamento.Tipo tipo;
        double valorAquisicao;
        Funcionario responsavel;
        int opcao;

        System.out.println("Digite o nome do equipamento");
        nome = in.next();
        System.out.println("Digite o tipo do equipamento (digite: FIXO ou MOVEL.)");
        tipo = Equipamento.Tipo.valueOf(in.next());
        System.out.println("Dê uma descrição do equipamento: ");
        descricao = in.next();
        System.out.println("Digite o valor do equipamento: ");
        valorAquisicao = in.nextDouble();
        System.out.println("Digite o nome ou email do responsável pelo equipamento: ");
        pesquisaFuncionario = in.next();
        System.out.println("Resultados da pesquisa: ");
        for (int i = 0; i < equipe.encontraFuncionario(pesquisaFuncionario).size(); i++) {
            System.out.println("\n" + "[" + i + "] " + "Nome: " + equipe.encontraFuncionario(pesquisaFuncionario).get(i).getNomeCompleto() + ", Email: " + equipe.encontraFuncionario(pesquisaFuncionario).get(i).getEmail());
        }
        System.out.println("\nEscolha o responsável pelo equipamento digitando o número a esquerda do funcionário desejado: ");
        opcao = in.nextInt();
        responsavel = equipe.encontraFuncionario(pesquisaFuncionario).get(opcao);

        if (equipamentos.cadastraEquipamento(nome, tipo, descricao, valorAquisicao, responsavel)) {
            System.out.println("Equipamento cadastrado com sucesso.");
        } else {
            System.out.println("Erro: Equipamento nao cadastrado.");
        }
    }

    /**
     * Monitora as manutenções pendentes e ativas (em andamento ou atrasadas) de equipamentos
     * registrados no sistema, exibindo informações detalhadas sobre cada manutenção.
     *
     * O metodo itera sobre a lista de equipamentos e suas respectivas manutenções, verificando se
     * elas estão em status pendente ou ativo. Com base no status, exibe as informações seguintes:
     *
     * - Nome do equipamento relacionado à manutenção.
     * - Descrição do problema reportado.
     * - Nome completo do responsável pela execução da manutenção.
     *
     * Além disso, avalia se as manutenções ativas estão atrasadas:
     * - Se o status for "Em andamento" e a data de retorno for nula, verifica se ultrapassou
     *   o limite de 7 dias desde a data de pedido.
     * - Classifica mantendo como "Atrasada" ou "Em andamento", baseado nesses critérios.
     *
     * Regras de status:
     * - Status 0: "Solicitada, aguardando atendimento".
     * - Status 1: "Em andamento" ou "Atrasada" caso aplicável.
     *
     * Pré-condições:
     * - A lista de equipamentos e suas manutenções deve estar previamente inicializada no sistema.
     *
     * Observação:
     * As exibições são realizadas diretamente no console utilizando `System.out`.
     */
    public void acompanharManutencoesPendentesEAtivas() {
        System.out.println("Acompanhamento de Manutenções Pendentes e Atrasadas:");
        for (Equipamento equipamento : equipamentos.getEquipamentos()) {
            for (Manutencao manutencao : equipamento.getManutencoes()) {
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
    }

    /**
     * Permite alterar o status de disponibilidade de um equipamento no sistema.
     *
     * Este metodo realiza um processo interativo para alteração do status de um equipamento,
     * solicitando informações ao usuário até que um equipamento válido seja encontrado e selecionado.
     * Ele permite alternar o status de disponibilidade entre "disponível" e "não disponível".
     *
     * Fluxo de execução:
     * - O usuário é solicitado a informar o nome ou descrição de um equipamento.
     * - É realizada a busca pelo equipamento na lista de equipamentos registrados.
     * - Caso nenhum equipamento seja encontrado, o usuário é informado e pode optar por cancelar o
     *   processo digitando "SAIR".
     * - Se um ou mais equipamentos forem encontrados, é exibida uma lista com os resultados para seleção.
     * - Após a seleção do equipamento, o sistema solicita a confirmação do usuário para alterar o status.
     * - Se confirmado, o status do equipamento selecionado é alterado com sucesso.
     *
     * Regras e validações:
     * - O usuário deve fornecer uma entrada válida correspondente ao nome ou descrição do equipamento.
     * - O metodo não continua se o usuário entrar com "SAIR" antes da seleção de um equipamento.
     * - A seleção de um equipamento deve ser feita a partir dos índices exibidos corretamente na lista.
     * - A alteração no status só ocorre após a confirmação explícita do usuário.
     *
     * Mensagens exibidas:
     * - "Digite o nome ou descrição do equipamento: " - Solicitação inicial ao usuário.
     * - "Erro: Equipamento não encontrado. Digite SAIR para cancelar alteração." - Quando nenhum
     *    equipamento é encontrado com os dados fornecidos.
     * - "Selecione o equipamento desejado: " - Quando múltiplos equipamentos são encontrados.
     * - "Tem certeza que deseja alterar o status do equipamento: [EQUIPAMENTO] [STATUS ANTIGO -> STATUS NOVO]" - Confirmação para alteração.
     * - "Equipamento alterado com sucesso." - Mensagem exibida após alteração bem-sucedida.
     *
     * Pré-condições:
     * - O objeto `equipamentos` deve estar inicializado e conter a lista de equipamentos registrados.
     * - O objeto `in` deve estar configurado corretamente para entrada de dados.
     */
    private void alteraStatusEquipamento() {
        ArrayList<Equipamento> resultado;
        String entrada = "";
        do {
            System.out.println("Digite o nome ou descrição do equipamento: ");
            entrada = in.next();
            resultado = equipamentos.encontraEquipamentos(entrada);
            if (resultado.isEmpty()) {
                System.out.println("Erro: Equipamento não encontrado. Digite SAIR para cancelar alteração");
            }
            if (entrada.equals("SAIR")) return;
        } while (resultado.isEmpty());

        System.out.println("Selecione o equipamento desejado: ");
        for (int i = 0; i < resultado.size(); i++) {
            System.out.println("[" + i + "] " + resultado.get(i).getNome() + " - " +
                    resultado.get(i).getResponsavelCompra().getNomeCompleto() + " - " +
                    (resultado.get(i).isDisponivel() ? "Disponível" : "Não disponível"));
        }
        int opcao = in.nextInt();
        System.out.println("Tem certeza que deseja alterar o status do equipamento: " + resultado.get(opcao).getNome() +
                (resultado.get(opcao).isDisponivel() ? " DISPONÍVEL -> INDISPONÍVEL" : " INDISPONÍVEL -> DISPONÍVEL"));
        System.out.println("[1] Sim");
        System.out.println("[2] Nao");
        int o = in.nextInt();
        if (o == 1) {
            resultado.get(opcao).setDisponivel(!resultado.get(opcao).isDisponivel());
            System.out.println("Equipamento alterado com sucesso");
        }
    }

    /**
     * Realiza busca integrada por funcionários e equipamentos no sistema com base em uma entrada de texto.
     *
     * Este metodo realiza uma pesquisa unificada que procura correspondências tanto na lista de funcionários
     * quanto na lista de equipamentos. A busca é case-insensitive e aceita correspondências parciais.
     *
     * Para funcionários encontrados, exibe:
     * - Informações básicas do funcionário
     * - Lista de equipamentos sob sua responsabilidade (se houver)
     *
     * Para equipamentos encontrados, exibe:
     * - Relatório detalhado do equipamento
     *
     * Se nenhum resultado for encontrado em ambas as listas, uma mensagem apropriada é exibida.
     *
     * Pré-condições:
     * - Os objetos `equipe` e `equipamentos` devem estar inicializados
     * - O objeto `in` deve estar configurado para entrada de dados
     *
     * Fluxo do processo:
     * 1. Solicita e captura a entrada do usuário
     * 2. Realiza busca em paralelo nas listas de funcionários e equipamentos
     * 3. Combina os resultados em uma única lista
     * 4. Exibe os resultados formatados de acordo com o tipo do objeto encontrado
     *
     * Mensagens ao usuário:
     * - "Digite a pesquisa aqui: " - Solicitação inicial
     * - "Nenhum resultado encontrado." - Quando não há correspondências
     * - "Resultados da pesquisa: " - Quando há pelo menos um resultado
     */
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
            System.out.println("Nenhum resultado encontrado");
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

    /**
     * Gera um relatório detalhado dos equipamentos cadastrados, exibindo informações importantes
     * sobre cada equipamento, incluindo nome, responsável pela compra e status das manutenções.
     *
     * O relatório apresenta:
     * - Nome do equipamento
     * - Responsável pela compra do equipamento
     * - Quantidade de manutenções concluídas
     * - Indicação caso o equipamento esteja em manutenção
     *
     * Caso não existam equipamentos cadastrados, uma mensagem indicativa será exibida.
     */
    public void gerarRelatorioEquipamentos() {
        ArrayList<Equipamento> listaEquipamentos = equipamentos.getEquipamentos();

        if (listaEquipamentos.isEmpty()) {
            System.out.println("Nenhum equipamento cadastrado");
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

    /**
     * Consulta o status de disponibilidade de um equipamento específico no sistema.
     *
     * Este metodo exibe uma lista de todos os equipamentos cadastrados com seus respectivos IDs
     * e permite que o usuário consulte o status de disponibilidade de um equipamento específico
     * através do seu ID.
     *
     * Fluxo do processo:
     * 1. Verifica se existem equipamentos cadastrados
     * 2. Exibe lista de equipamentos com seus IDs
     * 3. Solicita ao usuário o ID do equipamento desejado
     * 4. Busca o equipamento pelo ID informado
     * 5. Exibe o status de disponibilidade do equipamento
     *
     * Mensagens exibidas ao usuário:
     * - "Nenhum equipamento cadastrado." - Quando não há equipamentos no sistema
     * - "Equipamentos cadastrados:" - Seguido da lista de equipamentos
     * - "Digite o id do equipamento desejado: " - Solicitação de entrada
     * - "[Nome do equipamento]: Equipamento disponível/indisponível" - Status do equipamento
     * - "Equipamento não encontrado." - Quando o ID informado é inválido
     *
     * Pré-condições:
     * - O objeto `equipamentos` deve estar inicializado
     * - O objeto `in` deve estar configurado para entrada de dados
     */
    public void consultaStatusEquipamento() {
        ArrayList<Equipamento> listaEquipamentos = equipamentos.getEquipamentos();
        int id;

        if (listaEquipamentos.isEmpty()) {
            System.out.println("Nenhum equipamento cadastrado");
            return;
        } else {
            System.out.println("Equipamentos cadastrados:");
            for (Equipamento eq : listaEquipamentos) {
                System.out.println("- " + eq.getId() + " " + eq.getNome());
            }
        }

        System.out.println("Digite o id do equipamento desejado: ");
        id = in.nextInt();

        Equipamento e = null;

        for (Equipamento eq : listaEquipamentos) {
            if (eq.getId() == id) {
                e = eq;
                break;
            }
        }

        if (e != null) {
            if (e.isDisponivel()) {
                System.out.println(e.getNome() + ": Equipamento disponível");
            } else {
                System.out.println(e.getNome() + ": Equipamento indisponível");
            }
        } else {
            System.out.println("Equipamento não encontrado");
        }
    }

    /**
     * Registra um pedido de manutenção para um equipamento específico.
     *
     * Este metodo solicita ao usuário o ID do equipamento a ser mantido e uma descrição
     * do problema. Com base no ID, o equipamento correspondente é identificado e um pedido
     * de manutenção é agendado utilizando a descrição fornecida.
     *
     * Comportamento:
     * 1. O usuário insere o ID do equipamento.
     * 2. O equipamento é buscado pelo ID informado.
     * 3. O usuário fornece uma descrição do problema detectado.
     * 4. O equipamento é marcado como em manutenção com a descrição indicada.
     *
     * Requisitos:
     * - O ID deve corresponder a um equipamento existente nos registros.
     * - Deve ser fornecida uma descrição não vazia para o problema.
     *
     * Observação:
     * - O metodo requer que o fluxo de entrada padrão do sistema seja utilizado para interação
     *   com o usuário.
     */
    public void registraPedidoManutencao() {
        Equipamento e = null;
        String descProblema;
        int id;
        System.out.println("Digite o id do equipamento desejado: ");
        id = in.nextInt();
        e = equipamentos.buscarPorId(id);
        System.out.println("Dê uma descrição do problema: ");
        descProblema = in.next();
        equipamentos.agendarManutencao(e, descProblema);
    }

    /**
     * Exibe o histórico completo de manutenções para um equipamento específico.
     *
     * Este metodo solicita ao usuário o ID do equipamento e exibe todas as manutenções
     * registradas para ele, incluindo a data do pedido e a descrição do problema para
     * cada manutenção.
     *
     * Fluxo do processo:
     * 1. Solicita ao usuário o ID do equipamento
     * 2. Busca o equipamento pelo ID fornecido
     * 3. Se encontrado, exibe o histórico completo de manutenções
     * 4. Se não encontrado, exibe mensagem de erro
     *
     * Informações exibidas para cada manutenção:
     * - Data do pedido de manutenção
     * - Descrição do problema reportado
     *
     * Mensagens ao usuário:
     * - "Qual ID de equipamento a ser consultado?" - Solicitação inicial
     * - "Equipamento não encontrado na lista de equipamentos." - Quando ID é inválido
     *
     * Pré-condições:
     * - O objeto `equipamentos` deve estar inicializado
     * - O objeto `in` deve estar configurado para entrada de dados
     */

     private void atualizarPedidoManutencao() {
        System.out.println("Digite o ID do equipamento:");
        int id = in.nextInt();
        Equipamento equipamento = equipamentos.buscarPorId(id);
    
        if (equipamento == null) {
            System.out.println("Equipamento não encontrado.");
            return;
        }
    
        List<Manutencao> manutencoes = equipamento.getManutencoes();
        if (manutencoes.isEmpty()) {
            System.out.println("Este equipamento não possui manutenções registradas.");
            return;
        }
    
        System.out.println("Manutenções encontradas:");
        for (int i = 0; i < manutencoes.size(); i++) {
            Manutencao m = manutencoes.get(i);
            System.out.println("[" + i + "] " + m.getDescProblema() + " - Status: " + getStatusString(m.getStatus()));
        }
    
        System.out.println("Escolha a manutenção que deseja atualizar:");
        int indice = in.nextInt();
    
        if (indice < 0 || indice >= manutencoes.size()) {
            System.out.println("Índice inválido.");
            return;
        }
    
        Manutencao manutencaoSelecionada = manutencoes.get(indice);
        int statusAtual = manutencaoSelecionada.getStatus();
        int proximoStatus = statusAtual + 1;
    
        if (proximoStatus > 2) {
            System.out.println("Esta manutenção já foi concluída.");
            return;
        }
    
        String descSolucao = null;
        if (proximoStatus == 2) {
            System.out.println("Digite a descrição da solução aplicada:");
            in.nextLine();
            descSolucao = in.nextLine();
        }
    
        boolean sucesso = equipamentos.atualizaStatusManutencao(equipamento, manutencaoSelecionada, proximoStatus, descSolucao);
        if (sucesso) {
            System.out.println("Status atualizado com sucesso para: " + getStatusString(proximoStatus));
        } else {
            System.out.println("Erro ao atualizar o status. Verifique se a transição é válida.");
        }
    }
    
    // Método auxiliar para traduzir o status
    private String getStatusString(int status) {
        return switch (status) {
            case 0 -> "Solicitada";
            case 1 -> "Em andamento";
            case 2 -> "Finalizada";
            default -> "Desconhecido";
        };
    }
    public void exibirHistoricoManutencao() {
        System.out.println("Qual ID de equipamento a ser consultado?");
        int idEquipamento = in.nextInt();
        Equipamento equipamento = equipamentos.buscarPorId(idEquipamento);

        if (equipamento != null) {
            System.out.println("Histórico de Manutenções para o Equipamento: " + equipamento.getNome());
            for (Manutencao manutencao : equipamento.getManutencoes()) {
                System.out.println("Data do Pedido: " + manutencao.getDataPedido() + "\n" +
                        ", Descrição do Problema: " + manutencao.getDescProblema() + "\n");
            }
        } else {
            System.out.println("Equipamento não encontrado na lista de equipamentos");
        }
    }
}


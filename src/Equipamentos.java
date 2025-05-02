import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Equipamentos {
    private final ArrayList<Equipamento> equipamentos;

    public Equipamentos() {
        equipamentos = new ArrayList<>();
    }

    /**
     * Cadastra um novo equipamento com as informações fornecidas se todos os parâmetros forem válidos.
     *
     * @param nome o nome do equipamento a ser cadastrado
     * @param tipo o tipo do equipamento (MOVEL ou FIXO)
     * @param descricao uma descrição detalhada do equipamento
     * @param valorAquisicao o valor de aquisição do equipamento
     * @param responsavel o funcionário responsável pela aquisição do equipamento
     * @return true se o equipamento foi cadastrado com sucesso; false caso algum dos parâmetros for inválido
     */
    public boolean cadastraEquipamento(String nome, Equipamento.Tipo tipo, String descricao, double valorAquisicao, Funcionario responsavel) {
        if (nome != null && tipo != null && descricao != null && valorAquisicao != 0 && responsavel != null) {
            Equipamento equipamento = new Equipamento(nome, descricao, LocalDate.now(), valorAquisicao, responsavel, tipo);
            equipamentos.add(equipamento);
            return true;
        } else
            return false;
    }

    /**
     * Busca e retorna um equipamento com base no identificador fornecido.
     * Percorre a lista de equipamentos cadastrados e retorna o equipamento
     * correspondente ao ID especificado, caso exista.
     *
     * @param id o identificador do equipamento a ser buscado
     * @return o equipamento correspondente ao ID fornecido; null se nenhum equipamento for encontrado
     */
    public Equipamento buscarPorId(int id) {
        for (Equipamento equipamento : equipamentos) {
            if (equipamento.getId() == id) {
                return equipamento;
            }
        }
        return null;
    }

    /**
     * Altera a descrição de um equipamento, se o equipamento fornecido não for nulo.
     *
     * @param e o equipamento cuja descrição será alterada
     * @param novaDescricao a nova descrição que será atribuída ao equipamento
     * @return true se a descrição foi alterada com sucesso; false se o equipamento fornecido for nulo
     */
    public boolean alteraDescricao(Equipamento e, String novaDescricao) {
        if (e != null) {
            e.setDescricao(novaDescricao);
            return true;
        }
        return false;
    }

    /**
     * Atualiza o status de disponibilidade de um equipamento.
     *
     * @param e o equipamento a ter seu status alterado
     * @param status o novo status de disponibilidade (true = disponível, false = indisponível)
     * @return true se o status foi alterado com sucesso; false se o equipamento fornecido for nulo
     */
    public boolean setDisponivel(Equipamento e, boolean status) {
        if (e != null) {
            e.setDisponivel(status);
            return true;
        }
        return false;
    }

    /**
     * Agenda uma manutenção para o equipamento especificado, caso ele esteja disponível.
     * Uma nova manutenção é associada ao equipamento, sua disponibilidade é marcada como indisponível.
     *
     * @param e o equipamento que será agendado para manutenção. Deve ser não nulo e estar disponível.
     * @param descProblema a descrição do problema que precisa de manutenção. Deve ser não nula ou vazia.
     * @return true se a manutenção foi agendada com sucesso; false caso o equipamento seja nulo ou esteja indisponível.
     */
    public boolean agendarManutencao(Equipamento e, String descProblema) {
        if (e != null && e.isDisponivel()) {
            Manutencao manutencao = new Manutencao(e, descProblema);
            e.adicionarManutencao(manutencao);
            e.setDisponivel(false);
            return true;
        }
        return false;
    }

    /**
     * Atualiza o status de manutenção de um equipamento, dependendo das condições especificadas.
     * A mudança do status ocorre somente se o novo status for válido em relação ao status atual:
     * - Status 1: Indica que a manutenção foi iniciada.
     * - Status 2: Indica que a manutenção foi concluída, e o equipamento está disponível novamente.
     *
     * @param e o equipamento cuja manutenção será atualizada. Não pode ser nulo.
     * @param m o objeto representando a manutenção que será atualizada. Não pode ser nulo.
     * @param novoStatus o novo status a ser definido para a manutenção. Deve ser maior que o status atual para a atualização ocorrer.
     * @param descSolucao a descrição da solução aplicada na manutenção, utilizada ao concluir a manutenção. É ignorada para status 1.
     * @return true se a atualização de status foi realizada com sucesso; false se as condições para atualização não forem atendidas ou se os parâmetros fornecidos forem inválidos
     * .
     */
    public boolean atualizaStatusManutencao(Equipamento e, Manutencao m, int novoStatus, String descSolucao) {
        if (e == null || m == null) return false;

        int statusAtual = m.getStatus();

        if (novoStatus == statusAtual) return true;
        if (novoStatus < statusAtual) return false;

        switch (novoStatus) {
            case 1:
                if (statusAtual == 0) {
                    m.setDataManutencao(LocalDate.now());
                    m.setStatus(1);
                    return true;
                }
                break;
            case 2:
                if (statusAtual == 1) {
                    m.setDataRetorno(LocalDate.now());
                    m.setDescSolucao(descSolucao);
                    m.setStatus(2);
                    e.setDisponivel(true);
                    return true;
                }
                break;
        }
        return false;
    }

    /**
     * Retorna uma lista de registros de manutenção associados ao equipamento especificado.
     * Filtra as entradas de manutenção do equipamento informado e inclui apenas aquelas
     * onde o equipamento corresponde ao especificado.
     *
     * @param equipamento o equipamento cujos registros de manutenção serão recuperados. Não pode ser nulo.
     * @return uma lista de registros de manutenção relacionados ao equipamento especificado. Se o equipamento não tiver manutenções associadas, uma lista vazia é retornada.
     */
    public List<Manutencao> getManutencoesPorEquipamento(Equipamento equipamento) {
        List<Manutencao> lista = new ArrayList<>();
        for (Manutencao m : equipamento.getManutencoes()) {
            if (m.getEquipamento().equals(equipamento)) {
                lista.add(m);
            }
        }
        return lista;
    }

    /**
     * Gera um relatório contendo informações detalhadas sobre o equipamento fornecido.
     * Inclui o nome do equipamento, o responsável pela compra, a quantidade de manutenções,
     * e os detalhes de cada manutenção realizada, caso existam.
     *
     * @param e o equipamento para o qual o relatório será gerado. Não pode ser nulo.
     * @return uma string contendo o relatório detalhado do equipamento especificado.
     *         Caso o equipamento seja nulo, retorna "Equipamento nao encontrado".
     */
    public String geraRelatorio(Equipamento e) {
        if (e == null) {
            return "Equipamento nao encontrado";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(e.getNome()).append("\n");
        sb.append("Responsavel Compra: ").append(e.getResponsavelCompra().getNomeCompleto()).append("\n");
        sb.append("Manutencoes: ").append(e.getManutencoes().size()).append("\n");

        if (e.getManutencoes().isEmpty()) {
            sb.append("Equipamento nao possui manutencoes\n");
        } else {
            for (Manutencao m : e.getManutencoes()) {
                sb.append("- Problema: ").append(m.getDescProblema()).append(", ");
                sb.append("Responsavel: ").append(m.getResponsavel().getNomeCompleto()).append("\n ");
            }
        }
        return sb.toString();
    }

    /**
     * Gera o histórico detalhado de manutenções realizadas para um equipamento específico.
     * Retorna informações como o nome do equipamento, ID, tipo, e uma lista com os detalhes de cada manutenção.
     * Caso o equipamento seja nulo ou não tenha manutenções registradas, é retornada uma mensagem informativa.
     *
     * @param e o equipamento cujas informações de manutenção serão processadas. Não pode ser nulo.
     * @return uma string contendo o histórico de manutenções do equipamento, estruturado com detalhes de cada manutenção,
     *         ou uma mensagem informando que não há registros de manutenção.
     */
    public String geraHistoricoManutencao(Equipamento e) {
        if (e == null || e.getManutencoes().isEmpty()) {
            return "Nenhuma manutenção registrada para este equipamento.";
        }

        StringBuilder historico = new StringBuilder();
        historico.append("Histórico de Manutenções para o Equipamento: ").append(e.getNome()).append("\n");
        historico.append("ID: ").append(e.getId()).append("\n");
        historico.append("Tipo: ").append(e.getTipo()).append("\n\n");

        for (Manutencao m : e.getManutencoes()) {
            historico.append("Data do Pedido: ").append(m.getDataPedido()).append("\n");
            historico.append("Descrição do Problema: ").append(m.getDescProblema()).append("\n");
            historico.append("Responsável: ").append(m.getResponsavel().getNomeCompleto()).append("\n");
            historico.append("Data da Manutenção: ").append(m.getDataManutencao()).append("\n");
            historico.append("Data do Retorno: ").append(m.getDataRetorno()).append("\n");
            historico.append("Status: ").append(getStatusString(m.getStatus())).append("\n");
            historico.append("Solução: ").append(m.getDescSolucao()).append("\n");
            historico.append("----------------------------------------\n");
        }

        return historico.toString();
    }

    /**
     * Retorna uma cópia da lista de equipamentos cadastrados.
     * Uma cópia é retornada para preservar o encapsulamento e evitar
     * modificações diretas na lista original.
     *
     * @return uma cópia da lista de equipamentos cadastrados no sistema
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Equipamento> getEquipamentos() {
        return (ArrayList<Equipamento>) equipamentos.clone();
    }

    /**
     * Busca e retorna uma lista de equipamentos que possuem no nome ou na descrição
     * uma correspondência parcial com a entrada fornecida. A pesquisa é realizada de forma case-insensitive.
     *
     * @param entrada a string utilizada como critério de busca, que será comparada com os nomes e descrições dos equipamentos
     * @return uma lista de equipamentos que contêm a string de entrada no nome ou descrição. Retorna uma lista vazia se nenhum equipamento corresponder.
     */
    public ArrayList<Equipamento> encontraEquipamentos(String entrada) {
        ArrayList<Equipamento> saida = new ArrayList<>();
        for (Equipamento e : equipamentos) {
            String nome = e.getNome().toLowerCase();
            String descricao = e.getDescricao().toLowerCase();
            entrada = entrada.toLowerCase();
            if (nome.contains(entrada) || descricao.contains(entrada)) {
                saida.add(e);
            }
        }
        return saida;
    }

    /**
     * Retorna uma lista de equipamentos cujo responsável pela compra é o funcionário especificado.
     * Itera pela lista de equipamentos cadastrados e inclui na saída aqueles com o responsável correspondente.
     *
     * @param f o funcionário responsável pela aquisição dos equipamentos que deverão ser retornados
     * @return uma lista de equipamentos atribuídos ao funcionário especificado. Caso nenhum equipamento corresponda, retorna uma lista vazia.
     */
    public ArrayList<Equipamento> encontraEquipamentosPorResponsavel(Funcionario f) {
        ArrayList<Equipamento> saida = new ArrayList<>();
        for (Equipamento e : equipamentos) {
            if (e.getResponsavelCompra().equals(f)) {
                saida.add(e);
            }
        }
        return saida;
    }

    /**
     * Converte o código numérico do status de manutenção para sua representação textual.
     *
     * @param status o código numérico do status (0-3)
     * @return uma string descritiva do status da manutenção; Status Desconhecido se código não corresponder a nenhum status.
     */
    private String getStatusString(int status) {
        return switch (status) {
            case 0 -> "Manutenção Solicitada";
            case 1 -> "Manutenção em Andamento";
            case 2 -> "Manutenção Concluída com Sucesso";
            case 3 -> "Manutenção Cancelada";
            default -> "Status Desconhecido";
        };
    }
}
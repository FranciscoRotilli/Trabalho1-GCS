import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Equipamento {
    private static int contadorID = 1;
    private final int id;
    private final String nome;
    private final Tipo tipo;
    private final LocalDate dataAquisicao;
    private final double valorAquisicao;
    private final Funcionario responsavelCompra;
    private final List<Manutencao> manutencoes;
    private String descricao;
    private boolean disponivel;
    public Equipamento(String nome,
                       String descricao,
                       LocalDate dataAquisicao,
                       double valorAquisicao,
                       Funcionario responsavelCompra,
                       Tipo tipo) {
        // Validações básicas
        this.nome = Objects.requireNonNull(nome, "Nome não pode ser nulo");
        this.descricao = Objects.requireNonNull(descricao, "Descrição não pode ser nula");
        this.dataAquisicao = Objects.requireNonNull(dataAquisicao, "Data de aquisição não pode ser nula");
        this.responsavelCompra = Objects.requireNonNull(responsavelCompra, "Responsável pela compra não pode ser nulo");
        this.tipo = Objects.requireNonNull(tipo, "Tipo não pode ser nulo");

        if (valorAquisicao < 0) {
            throw new IllegalArgumentException("Valor de aquisição não pode ser negativo");
        }

        this.id = contadorID++;
        this.valorAquisicao = valorAquisicao;
        this.disponivel = true;
        this.manutencoes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = Objects.requireNonNull(descricao, "Descrição não pode ser nula");
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public double getValorAquisicao() {
        return valorAquisicao;
    }

    public Funcionario getResponsavelCompra() {
        return responsavelCompra;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean status) {
        this.disponivel = status;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public List<Manutencao> getManutencoes() {
        return Collections.unmodifiableList(manutencoes);
    }

    /**
     * Adiciona uma nova manutenção à lista de manutenções do equipamento.
     *
     * @param manutencao a instância de Manutencao que será adicionada. Não pode ser nula.
     *                   Uma exceção será lançada caso um objeto nulo seja fornecido.
     */
    public void adicionarManutencao(Manutencao manutencao) {
        Objects.requireNonNull(manutencao, "Manutenção não pode ser nula");
        this.manutencoes.add(manutencao);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Descrição: " + descricao + " | Data de Aquisição: " + dataAquisicao;
    }

    public enum Tipo {
        MOVEL,
        FIXO
    }
}	

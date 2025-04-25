import java.time.LocalDate;
import java.util.ArrayList;

public class Equipamento {
	public enum Tipo {
        MOVEL,
        FIXO
    }
	private static int contadorID = 1;

	private int id;
	private String nome;
	private Tipo tipo;
	private String descricao;
	private LocalDate dataAquisicao;
	private double valorAquisicao;
	private Funcionario responsavelCompra;
	private ArrayList<Manutencao> manutencoes;	
	private boolean disponivel;

	public Equipamento(String nome, 
					   String descricao,
					   LocalDate dataAquisicao,
					   double valorAquisicao,
					   Funcionario responsavelCompra,
					   Tipo tipo,
					   ArrayList<Manutencao> manutencoes) {
        this.id  = contadorID++;
        this.nome = nome;
        this.descricao = descricao;
        this.dataAquisicao = dataAquisicao;
        this.valorAquisicao = valorAquisicao;
        this.responsavelCompra = responsavelCompra;
        this.disponivel = true;
        this.tipo = tipo;
		this.manutencoes = manutencoes;
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
    
    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public double getValorAquisicao() {
        return valorAquisicao;
    }

    public Funcionario getResponsavel() {
        return responsavelCompra;
    }

    public boolean isDisponivel() {
        return disponivel;
    }   

    public Tipo getTipo() {
        return tipo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDisponivel (boolean status) {
        this.disponivel = status;
    }

	public ArrayList<Manutencao> getManutencoes() {
		return manutencoes;
	}

	public void setManutencoes(ArrayList<Manutencao> manutencoes) {
		this.manutencoes = manutencoes;
	}

	public void adicionarManutencao(Manutencao manutencao) {
		this.manutencoes.add(manutencao);
	}
}	

import java.util.Collection;

public class Equipamento {

	private int id;

	private String nome;

	private String tipo;

	private String descricao;

	private Date dataAquisicao;

	private double valorAquisicao;

	private Funcionario responsavelCompra;

	private ArrayList<Manutencao> manutencoes;

	private boolean status;

	private Funcionario funcionario;

	private Collection<Manutencao> manutencao;

	private Equipamentos equipamentos;

}

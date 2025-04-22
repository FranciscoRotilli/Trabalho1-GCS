import java.util.Collection;

public class Equipamentos {

	private ArrayList<Equipamento> equipamentos;

	private Collection<Equipamento> equipamento;

	public boolean cadastraEquipamento(String nome, String tipo, String descricao, double valorAquisicao, Funcionario responsavel) {
		return false;
	}

	public boolean alteraDescricao(Equipamento e, String novaDescricao) {
		return false;
	}

	public boolean alteraStatus(Equipamento e, boolean status) {
		return false;
	}

	public boolean pedeManutencao(Equipamento e, String descProblema, Funcionario responsavel) {
		return false;
	}

	public boolean avancaManutencao(Equipamento e, Manutencao m) {
		return false;
	}

	public String geraRelatorio(Equipamento e) {
		return null;
	}

	public Equipamentos encontraEquipamento(String entrada) {
		return null;
	}

}

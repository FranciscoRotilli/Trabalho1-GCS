import java.time.LocalDate;
import java.util.ArrayList;

public class Equipamentos {
	private ArrayList<Equipamento> equipamentos;

	public Equipamentos() {
        equipamentos = new ArrayList<>();
    }

	public void cadastraEquipamento(String nome, Equipamento.Tipo tipo, String descricao, double valorAquisicao, Funcionario responsavel) {
		Equipamento equipamento = new Equipamento(nome, descricao, LocalDate.now(), valorAquisicao, responsavel, tipo);
		equipamentos.add(equipamento);
	}

	public Equipamento buscarPorId(int id) {
        for (int i = 0; i < equipamentos.size(); i++){
            Equipamento equipamento = equipamentos.get(i);
            if (equipamento.getId() == id){
                return equipamento;
            }
        }
        return null;
    }

	public boolean alteraDescricao(Equipamento e, String novaDescricao) {
		if (e != null) {
			e.setDescricao(novaDescricao);
			return true;
		}
		return false;
	}

	public boolean setDisponivel(Equipamento e, boolean status) {
		if (e != null) {
			e.setDisponivel(status);
			return true;
		}
		return false;
	}

	public boolean pedeManutencao(Equipamento e, String descProblema, Funcionario responsavel) {
		// TODO Adicionar manutencao
		return true;
	}

	public boolean avancaManutencao(Equipamento e, Manutencao m) {
		// TODO Adicionar manutencao
		return true;
	}

	public String geraRelatorio(Equipamento e) {
		// TODO Complementar manutencao em andamento e concluidas
		return "Nome: " + e.getNome() + ", " 
				+ "Responsavel Compra: " + e.getResponsavel().getNomeCompleto() + ", " 
				+ "Manutencoes: " + e.getManutencoes().size();
	}
}
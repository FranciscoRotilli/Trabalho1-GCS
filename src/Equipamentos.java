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
		if (e == null && e.isDisponivel()) {
			Manutencao manutencao = new Manutencao(e, LocalDate.now(), descProblema, responsavel, null, null, "", 0);
			e.adicionarManutencao(manutencao);
			e.setDisponivel(false);
			return true;
		}
		return false;
	}

	public boolean avancaManutencao(Equipamento e, Manutencao m) {
		if (e == null && m != null) {
			if(m.getStatus() == 0) {
				m.setDataManutencao(LocalDate.now());
				m.setStatus(1);
				return true;
			}else if (m.getStatus() == 1) {
				m.setDataRetorno(LocalDate.now());
				m.setStatus(2);
				e.setDisponivel(true);
				return true;
			}
		}
		return false;
	}

	public String geraRelatorio(Equipamento e) {
		if (e == null) {
			return "Equipamento nao encontrado";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: " + e.getNome() + "\n");
		sb.append("Responsavel Compra: " + e.getResponsavel().getNomeCompleto() + "\n");
		sb.append("Manutencoes: " + e.getManutencoes().size() + "\n");

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
}
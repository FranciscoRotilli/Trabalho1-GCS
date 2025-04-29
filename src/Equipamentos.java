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
		for (int i = 0; i < equipamentos.size(); i++) {
			Equipamento equipamento = equipamentos.get(i);
			if (equipamento.getId() == id) {
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

	private String getStatusString(int status) {
		switch (status) {
			case 0: return "Manutenção Solicitada";
			case 1: return "Manutenção em Andamento";
			case 2: return "Manutenção Concluída com Sucesso";
			case 3: return "Manutenção Cancelada";
			default: return "Status Desconhecido";
		}
	}
}
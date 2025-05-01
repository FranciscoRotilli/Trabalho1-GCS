import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Equipamentos {
	private ArrayList<Equipamento> equipamentos;

	public Equipamentos() {
		equipamentos = new ArrayList<>();
	}

	public boolean cadastraEquipamento(String nome, Equipamento.Tipo tipo, String descricao, double valorAquisicao, Funcionario responsavel) {
		if(nome!=null && tipo!=null && descricao!=null && valorAquisicao!=0 && responsavel!=null) {
			Equipamento equipamento = new Equipamento(nome, descricao, LocalDate.now(), valorAquisicao, responsavel, tipo);
			equipamentos.add(equipamento);
			return true;
		}
		else
			return false;
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

	public boolean agendarManutencao(Equipamento e, String descProblema) {
		if (e != null && e.isDisponivel()) {
			Manutencao manutencao = new Manutencao(e, descProblema);
			e.adicionarManutencao(manutencao);
			e.setDisponivel(false);
			return true;
		}
		return false;
	}

	public boolean iniciaManutencao(Equipamento e, Manutencao manutencao) {
        if (e != null && manutencao != null && manutencao.getStatus() == 0) {
            manutencao.setDataManutencao(LocalDate.now());
            manutencao.setStatus(1);
            return true;
        }
        return false;
    }

	public boolean finalizaManutencao(Equipamento e, Manutencao manutencao, String descSolucao) {
		if (e != null && manutencao != null && manutencao.getStatus() == 1) {
			manutencao.setDescSolucao(descSolucao);
			manutencao.setDataRetorno(LocalDate.now());
			manutencao.setStatus(2);
			e.setDisponivel(true);
			return true;
		}
		return false;
	}

	public List<Manutencao> getManutencoesPorEquipamento(Equipamento equipamento) {
		List<Manutencao> lista = new ArrayList<>();
		for (Manutencao m : equipamento.getManutencoes()) {
			if (m.getEquipamento().equals(equipamento)) {
				lista.add(m);
			}
		}
		return lista;
	}

	public String geraRelatorio(Equipamento e) {
		if (e == null) {
			return "Equipamento nao encontrado";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: " + e.getNome() + "\n");
		sb.append("Responsavel Compra: " + e.getResponsavelCompra().getNomeCompleto() + "\n");
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

	public ArrayList<Equipamento> encontraEquipamentosPorResponsavel(Funcionario f) {
		ArrayList<Equipamento> saida = new ArrayList<>();
		for (Equipamento e : equipamentos) {
			if (e.getResponsavelCompra().equals(f)) {
				saida.add(e);
			}
		}
		return saida;
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
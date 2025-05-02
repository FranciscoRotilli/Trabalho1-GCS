import java.time.LocalDate;

public class Manutencao {
	private Equipamento equipamento;
	private LocalDate dataPedido;
	private String descProblema;
	private Funcionario responsavel;
	private LocalDate dataManutencao;
	private LocalDate dataRetorno;
	private String descSolucao;
	private int status;
	
	public Manutencao(Equipamento equipamento, String descProblema) {
        this.equipamento = equipamento;
        this.dataPedido = LocalDate.now();
        this.descProblema = descProblema;
        this.responsavel = null;
        this.dataManutencao = null;
        this.dataRetorno = null;
        this.descSolucao = null;
        this.status = 0;
	}
	
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public String getDescProblema() {
		return descProblema;
	}
	public void setDescProblema(String descProblema) {
		this.descProblema = descProblema;
	}
	public Funcionario getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}
	public LocalDate getDataManutencao() {
		return dataManutencao;
	}
	public void setDataManutencao(LocalDate dataManutencao) {
		this.dataManutencao = dataManutencao;
	}
	public LocalDate getDataRetorno() {
		return dataRetorno;
	}
	public void setDataRetorno(LocalDate dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
	public String getDescSolucao() {return descSolucao;}

	public void setDescSolucao(String descSolucao) {
		this.descSolucao = descSolucao;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public boolean isAtrasada() {
		if (status == 1 && dataRetorno == null) {  // Status 1 é "em andamento"
			return dataPedido.plusDays(7).isBefore(LocalDate.now());  // Atrasada após 7 dias
		}
		return false;
	}
}
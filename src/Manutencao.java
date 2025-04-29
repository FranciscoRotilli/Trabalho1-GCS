import java.time.LocalDate;

public class Manutencao {
	private Equipamento equipamento;
	private LocalDate dataPedido;
	private String descProblema;
	private Funcionario responsavel;
	private LocalDate dataManutencao;
	private LocalDate dataRetorno;
	private int descSolucao;
	private int status;
	
	public Manutencao(Equipamento equipamento, LocalDate dataPedido, String descProblema, Funcionario responsavel,
			LocalDate dataManutencao, LocalDate dataRetorno, int descSolucao, int status) {
		this.equipamento = equipamento;
		this.dataPedido = dataPedido;
		this.descProblema = descProblema;
		this.responsavel = responsavel;
		this.dataManutencao = dataManutencao;
		this.dataRetorno = dataRetorno;
		this.descSolucao = descSolucao;
		this.status = status;
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
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
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
	public int getDescSolucao() {
		return descSolucao;
	}
	public void setDescSolucao(int descSolucao) {
		this.descSolucao = descSolucao;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
import java.time.LocalDate;
import java.util.ArrayList;
public class Manutencoes {
    private ArrayList<Manutencao> manutencoes;
    
    public Manutencoes(){
        manutencoes = new ArrayList<>();
    }
    
    public void agendarManutencao(Equipamento equipamento, String descProblema, Funcionario responsavel){
        Manutencao manutencao = new Manutencao(equipamento, LocalDate.now(), descProblema, responsavel, null, null, 0, 0);
        manutencoes.add(manutencao);
    }

    public boolean iniciaManutencao(Manutencao manutencao){
        if (manutencao != null && manutencao.getStatus() == 0){
            manutencao.setDataManutencao(LocalDate.now());
            manutencao.setStatus(1);
            return true;
        }
        return false;
    }

    public boolean finalizaManutencao(Manutencao manutencao, int descSolucao){
        if (manutencao != null && manutencao.getStatus() == 1){
            manutencao.setDescSolucao(descSolucao);
            manutencao.setDataRetorno(LocalDate.now());
            manutencao.setStatus(2);
            manutencoes.remove(manutencao);
            return true;
        }
        return false;
    }

    public ArrayList<Manutencao> getManutencoesPorEquipamento(Equipamento equipamento){
        ArrayList<Manutencao> lista = new ArrayList<>();
        for (Manutencao m : manutencoes){
            if (m.getEquipamento().equals(equipamento)){
                lista.add(m);
            }
        }
        return lista;
    }
}

import java.util.ArrayList;

public class Equipe {
	private ArrayList<Funcionario> equipe;

	public Equipe(){
		equipe = new ArrayList<>();
	}
	/**
	 * Cadastra funcinarios novos
	 * @param nome nome completo do funcionario
	 * @param email email do funcionario
	 * @return true se nome e email nao forem null e menores que 3/5 chars; false
	 */
	public boolean cadastraFuncionario(String nome, String email) {
		if (nome != null && nome.length() > 3 && email != null && email.length() > 5) {
			Funcionario f = new Funcionario(nome, email);
			equipe.add(f);
			return true;
		}
		return false;
	}

	/**
	 * Altera o email de funcionario cadastrado
	 * @param f funcionario a ser alterado
	 * @param novoEmail email novo para o funcionario
	 * @return true se email novo nao for null ou menor que 5 chars e igual ao antigo; false
	 */
	public boolean alteraEmail(Funcionario f, String novoEmail) {
		if (novoEmail != null && novoEmail.length() > 5 && !(f.getEmail().equals(novoEmail))) {
			f.setEmail(novoEmail);
		}
		return false;
	}

	/**
	 * Altera o nome de funcionario cadastrado
	 * @param f funcionario a ser alterado
	 * @param novoNome novo nome compelto para o funcionario
	 * @return true se novo nome completo nao for null e menor que 3 chars e diferente do nome atual; false
	 */
	public boolean alteraNome(Funcionario f, String novoNome) {
		if (novoNome != null && novoNome.length() > 3 && !(f.getNomeCompleto().equals(novoNome))) {
			f.setNomeCompleto(novoNome);
			return true;
		}
		return false;
	}

	/**
	 * Encontra funcionarios pelo nome completo ou email; aceita pequisa parcial
	 * @param entrada valor informado pela pesquisa
	 * @return retorna um arraylist com os funcionarios correspondentes a entrada
	 */
	public ArrayList<Funcionario> encontraFuncionario(String entrada) {
		ArrayList<Funcionario> saida = new ArrayList<>();
		for (Funcionario f : equipe) {
			String nome = f.getNomeCompleto().toLowerCase();
			String email = f.getEmail().toLowerCase();
			entrada = entrada.toLowerCase();
			if (nome.contains(entrada) || email.contains(entrada)) {
				saida.add(f);
			}
		}
		return saida;
	}

	public Funcionario encontraFuncionarioPorMatricula(int matricula) {
		for (Funcionario f : equipe) {
			if (f.getMatricula() == matricula) {
				return f;
			}
		}
		return null;
	}
}

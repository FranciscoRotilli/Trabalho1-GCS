public class Funcionario {
    private static int proximaMatricula = 101;
    private final int matricula;
    private String nomeCompleto;
    private String email;

    public Funcionario(String nomeCompleto, String email) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.matricula = proximaMatricula++;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Funcionário: " + nomeCompleto + " | " +
                "Matrícula: " + matricula + " | " +
                "Email: " + email;
    }
}

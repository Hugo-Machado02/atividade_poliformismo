public abstract class Pessoa {
    private String nome;
    private String telefone;
    private String endereco;
    private int locacoes;

    //Construtor
    public Pessoa(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.locacoes = 0;
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(int locacao) {
        this.locacoes = locacao;
    }
}

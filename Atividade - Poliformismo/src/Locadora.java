import java.util.ArrayList;

public class Locadora {
    private String nome;
    private String endereco;
    private String telefone;
    private ArrayList<Veiculo> veiculos;
    private ArrayList<Pessoa> clientes;
    private ArrayList<Locacoes> locacoes;

    //Construtor
    public Locadora(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    //Getters e Setters
    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public ArrayList<Pessoa> getClientes() {
        return clientes;
    }

    public void setClientes(Pessoa cliente) {
        this.clientes.add(cliente);
    }

    public ArrayList<Locacoes> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(Locacoes locacao) {
        this.locacoes.add(locacao);
    }
}
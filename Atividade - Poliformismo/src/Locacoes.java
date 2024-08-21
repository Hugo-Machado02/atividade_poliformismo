public class Locacoes {
    private Pessoa cliente;
    private Veiculo veiculo;
    private String dataLocacao;
    private String dataDevolucao;
    private double valorTotal;
    private int renovacoes;
    private boolean devolvido;

    //Construtor
    public Locacoes(Pessoa cliente, Veiculo veiculo, String dataLocacao) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.veiculo.setLocado(true);
        this.dataLocacao = dataLocacao;
        dataDevolucao = "";
        this.valorTotal = 0;
        this.renovacoes = 0;
        this.devolvido = false;
    }

    //Metodos
    public void renovacaoVeiculo(){
        this.renovacoes++;
    }

    public boolean devolucaoVeiculo(String dataDevolucao){
        if(getDevolvido() == false){
            this.cliente.setLocacoes(this.cliente.getLocacoes()-1);
            double multa = this.veiculo.calculaMulta(getRenovacoes());
            this.valorTotal = multa + this.veiculo.getValorLocacao();
            this.dataDevolucao = dataDevolucao;
            this.devolvido = true;
            this.veiculo.setLocado(false);
            return true;
        }
        return false;
    }

    //Getters e Setters
    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public String getDataDevolucao() {
        if (this.dataDevolucao.equals("")) {
            return "Não Devolvido";
        }
        return this.dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getRenovacoes() {
        return renovacoes;
    }

    public void setRenovacoes() {
        this.renovacoes++;
    }

    public boolean getDevolvido() {
        return devolvido;
    }

    public void setDevolvido() {
        this.devolvido = true;
    }
}

public class VeiculoSuv extends Veiculo{
    private String tamanhoPortaMalas;
    private String tipoTracao;
    private String combustivel;

    //Construtor
    public VeiculoSuv(String marca, String modelo, String placa, int ano, double valorLocacao, double valorMulta, String tamanhoPortaMalas, String tipoTracao, String combustivel) {
        super(marca, modelo, placa, ano, valorLocacao, valorMulta);
        this.tamanhoPortaMalas = tamanhoPortaMalas;
        this.tipoTracao = tipoTracao;
        this.combustivel = combustivel;
    }

    //Getter e Setters
    public String getTamanhoPortaMalas() {
        return tamanhoPortaMalas;
    }

    public void setTamanhoPortaMalas(String tamanhoPortaMalas) {
        this.tamanhoPortaMalas = tamanhoPortaMalas;
    }

    public String getTipoTracao() {
        return tipoTracao;
    }

    public void setTipoTracao(String tipoTracao) {
        this.tipoTracao = tipoTracao;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }
}

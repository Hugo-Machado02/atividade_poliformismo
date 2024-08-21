public class VeiculoLuxo extends Veiculo{
    private int quantidadeAirbags;
    private String tamanhoPortaMalas;
    private boolean gps;

    //Contrutor
    public VeiculoLuxo(String marca, String modelo, String placa, int ano, double valorLocacao, double valorMulta, int quantidadeAirbags, String tamanhoPortaMalas, boolean gps) {
        super(marca, modelo, placa, ano, valorLocacao, valorMulta);
        this.quantidadeAirbags = quantidadeAirbags;
        this.tamanhoPortaMalas = tamanhoPortaMalas;
        this.gps = gps;
    }

    //metodos
    @Override
    public double calculaMulta(int renovacoes){
        if(renovacoes > 5){
            double result = getValorMulta() * renovacoes;
            return result;
        }
        return 0;
    }

    //Getter e Setters
    public int getQuantidadeAirbags() {
        return quantidadeAirbags;
    }

    public void setQuantidadeAirbags(int quantidadeAirbags) {
        this.quantidadeAirbags = quantidadeAirbags;
    }

    public String getTamanhoPortaMalas() {
        return tamanhoPortaMalas;
    }

    public void setTamanhoPortaMalas(String tamanhoPortaMalas) {
        this.tamanhoPortaMalas = tamanhoPortaMalas;
    }

    public boolean isGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }
}

public class VeiculoPopular extends Veiculo{
    private boolean arCondicionado;

    //Construtor
    public VeiculoPopular(String marca, String modelo, String placa, int ano, double valorLocacao, double valorMulta, boolean arCondicionado) {
        super(marca, modelo, placa, ano, valorLocacao, valorMulta);
        this.arCondicionado = arCondicionado;
    }

    //metodos
    @Override
    public double calculaMulta(int renovacoes){
        if(renovacoes > 1){
            double result = getValorMulta() * renovacoes;
            return result;
        }
        return 0;
    }

    //Getters e Setters
    public boolean getArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }
}

public class VeiculoPopular extends Veiculo{
    private boolean arCondicionado;

    //Construtor
    public VeiculoPopular(String marca, String modelo, String placa, int ano, double valorLocacao, double valorMulta, boolean arCondicionado) {
        super(marca, modelo, placa, ano, valorLocacao, valorMulta);
        this.arCondicionado = arCondicionado;
    }

    //Getters e Setters
    public boolean getArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }
}

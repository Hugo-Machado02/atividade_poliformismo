import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Instanciação da Locadora
        Locadora locadora = new Locadora("Mega Veiculos", "Avenida dos Josés, São Paulo - SP", "64 99354-9674");

        //Operações
        int operacao;
        do {
            System.out.println("\n\n============== Menu Principal ==============");
            System.out.println("1 - Cadastrar Clientes");
            System.out.println("2 - Cadastrar Veiculos");
            System.out.println("3 - Reservar Veiculos");
            System.out.println("4 - Finalizar Reserva");
            System.out.println("-------------------------------------------");
            System.out.print("Selecione uma Opção: ");
            operacao = scan.nextInt();
            System.out.println("============================================\n\n");

            switch(operacao){
                case 0:
                    System.out.println("Operação Finalizada");
                    break;
                case 1:
                    locadora.setClientes(cadastroCliente());
                    break;
                case 2:
                    locadora.setVeiculos(cadastroVeiculo());
                    System.out.println("Lista de Carros:" + locadora.getVeiculos());
                    break;
                case 3:
                    System.out.println("\n\n============= Realizar Reserva =============");
                    Pessoa cliente = validaPessoa(locadora.getClientes());
                    if(cliente == null){
                        continue;
                    }
                    Locacoes locacao = reservarVeiculo(cliente, locadora.getVeiculos());
                    locadora.setLocacoes(locacao);
                    System.out.println("Lista de Locacoes:" + locadora.getLocacoes());
                    System.out.println("============================================\n\n");
                    break;
                case 4:
                    Pessoa validaCliente = validaPessoa(locadora.getClientes());
                    Locacoes locaoces = verificaLocacao(locadora.getLocacoes(), validaCliente);
                    devolucaoVeiculo(locaoces, "01/01/2001");
                    break;
                default:
                    System.out.println("Seleção Invália, por favor, tente novamente!");
                    break;
            }
        }while(operacao != 0);
    }


    //============================ Funções ============================

    //Cadastro de Cliente
    public static Pessoa cadastroCliente(){
        Scanner scan = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n\n============ Cadastro de Cliente ===========");
            System.out.println("1 - Pessoa Fisica");
            System.out.println("2 - Pessoa Juridica");
            System.out.println("-------------------------------------------");
            System.out.printf("Selecione uma Opção: ");
            op = scan.nextInt();
            System.out.println("============================================\n\n");
        }
        while(op != 1 && op != 2);

        scan.nextLine();
        System.out.printf("Digite o Nome: ");
        String nomeCliente = scan.nextLine();
        System.out.printf("Digite o Telefone: ");
        String telefoneCliente = scan.nextLine();
        System.out.printf("Digite o endereco: ");
        String enderecoCliente = scan.nextLine();
        Pessoa pessoa;

        if(op == 1){
            System.out.printf("Digite o CPF: ");
            String cpfCliente = scan.nextLine();
            pessoa = new PessoaFisica(nomeCliente, telefoneCliente, enderecoCliente, cpfCliente);
        }
        else{
            System.out.printf("Digite o CNPJ: ");
            String cnpjCliente = scan.nextLine();
            System.out.printf("Digite o nome do Representante: ");
            String representanteCliente = scan.nextLine();
            pessoa = new PessoaJuridica(nomeCliente, telefoneCliente, enderecoCliente, cnpjCliente, representanteCliente);
        }
        return pessoa;
    }

    //Cadastro de Veiculos
    public static Veiculo cadastroVeiculo(){
        Scanner scan = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n\n============ Cadastro de Veiculos ============");
            System.out.println("1 - Cadastrar Veiculo Popular");
            System.out.println("2 - Cadastrar Veiculo SUV");
            System.out.println("3 - Cadastrar Veiculo de Luxo");
            System.out.println("-------------------------------------------");
            System.out.print("Selecione uma Opção: ");
            op = scan.nextInt();
            System.out.println("============================================\n\n");
        }
        while(op != 1 && op != 2 && op != 3);

        //Dados do Veículo
        scan.nextLine();
        System.out.printf("Digite a Marca: ");
        String marcaVeiculo = scan.nextLine();
        System.out.printf("Digite o Modelo: ");
        String modeloVeiculo = scan.nextLine();
        System.out.printf("Digite a Placa: ");
        String placaVeiculo = scan.nextLine();
        System.out.printf("Digite o Ano: ");
        int anoVeiculo = scan.nextInt();
        scan.nextLine();
        System.out.printf("Digite o Valor da Locação: ");
        double valLocacaoVeiculo = scan.nextDouble();
        System.out.printf("Digite o valor da Multa: ");
        double valMultaVeiculo = scan.nextDouble();

        Veiculo veiculo;

        if(op == 1){
            System.out.println("Possui Ar Condicionado?");
            boolean arCondicionado = validaBoolean();
            veiculo = new VeiculoPopular(marcaVeiculo, modeloVeiculo, placaVeiculo, anoVeiculo, valLocacaoVeiculo, valMultaVeiculo, arCondicionado);
        }
        else if(op == 2){
            System.out.printf("Digite o Tamanho do Porta-malas: ");
            scan.nextLine();
            String tamanhoPortaMalas = scan.nextLine();
            System.out.printf("Digite o tipo de Tracao: ");
            String tipoTracao = scan.nextLine();
            System.out.printf("Digite o Combustivel: ");
            String combustivel = scan.nextLine();
            veiculo = new VeiculoSuv(marcaVeiculo, modeloVeiculo, placaVeiculo, anoVeiculo, valLocacaoVeiculo, valMultaVeiculo, tamanhoPortaMalas, tipoTracao, combustivel);
        }
        else{
            System.out.printf("Digite a quantidade de Airbags: ");
            int qtdAirbags = scan.nextInt();
            scan.nextLine();
            System.out.printf("Digite o Tamanho do Porta-malas: ");
            String tamanhoPortaMalas = scan.nextLine();
            System.out.println("O carro possui GPS imbutido?");
            boolean gps = validaBoolean();
            veiculo = new VeiculoLuxo(marcaVeiculo, modeloVeiculo, placaVeiculo, anoVeiculo, valLocacaoVeiculo, valMultaVeiculo, qtdAirbags, tamanhoPortaMalas, gps);
        }
        return veiculo;
    }


    //Reserva de Veiculos
    public static Locacoes reservarVeiculo(Pessoa cliente, ArrayList<Veiculo> veiculos){
        Scanner scan = new Scanner(System.in);
        int op;

        System.out.println("\n\n======== Selecione o carro Desejado ========");
        for(int i=0; i < veiculos.size(); i++){
            if(veiculos.get(i).getLocado() == false){
                System.out.println(i+1 + "-> " + veiculos.get(i).getModelo() + " / " +  veiculos.get(i).getMarca());
            }
        }
        System.out.print("Selecione uma Opção: ");
        op = scan.nextInt();

        Locacoes locacao = new Locacoes(cliente, veiculos.get(op-1), "00/00/00");
        System.out.println("============================================\n\n");

        return locacao;

    }


    //Devolucao de Veiculos
    public static boolean devolucaoVeiculo(Locacoes locacao, String dataDevolucao){
        boolean entrega = locacao.devolucaoVeiculo(dataDevolucao);
        if(entrega == true){
            Veiculo veiculo = locacao.getVeiculo();
            System.out.println("Usuario: " + locacao.getCliente().getNome());
            System.out.println("Veiculo: " + veiculo.getModelo() + " - " + veiculo.getMarca() + " - " + veiculo.getPlaca());
            System.out.println("Valor Locacao: " + veiculo.getValorLocacao());
            System.out.println("Valor Multa: " + (locacao.getValorTotal() - veiculo.getValorLocacao()));
            System.out.println("Valor Total: " + (locacao.getValorTotal()));
            System.out.println("-> Entrega do Carro realizada com sucesso");
            return true;
        }
        return false;
    }


    //Verifica locacao
    public static Locacoes verificaLocacao(ArrayList<Locacoes> locacoes, Pessoa cliente){
        Scanner scan = new Scanner(System.in);
        int op = 0;

        do{
            System.out.println("\n\n=============================================");
            System.out.println("Olá "+ cliente.getNome() + ", Essas são suas locaoes pendentes");
            for(int i=0; i < locacoes.size(); i++){
                if(locacoes.get(i).getDevolvido() == false && locacoes.get(i).getCliente() == cliente){
                    Veiculo veiculo =  locacoes.get(i).getVeiculo();
                    System.out.println((i+1) + " - " + veiculo.getModelo() + " - " + veiculo.getMarca() + " - " + veiculo.getPlaca());
                }
            }
            System.out.println("Selecione uma opção para continuar ou digite 0 para sair");
            op = scan.nextInt();

            if(op != 0){
                return locacoes.get(op-1);
            }
            System.out.println("=============================================\n\n");
        }while(op != -1);
        return null;
    }


    //Realiza a validação dos clientes
    public static Pessoa validaPessoa(ArrayList<Pessoa> clientes){
        Scanner scan = new Scanner(System.in);
        boolean validacao = false;

        System.out.printf("1 - Digite o Numero de celular: ");
        do{
            String telefone = scan.nextLine();

            if(telefone.equals("-1")){
                validacao = true;
                continue;
            }

            for(int i=0; i < clientes.size(); i++){
                if(clientes.get(i).getTelefone().equals(telefone)){
                    return clientes.get(i);
                }
            }
            System.out.println("Cliente não encontrado!");
            System.out.printf("Tente Novamente. ou digite '-1' para sair: ");
        }while(validacao == false);
        return null;
    }

    //Realiza a validação dos valores booleanos
    public static boolean validaBoolean(){
        Scanner scan = new Scanner(System.in);

        int selecao;
        do {
            System.out.println("Selecione => 1 - sim || 2 - Não): ");
            selecao = scan.nextInt();

            if(selecao != 1 && selecao != 2){
                System.out.println("Opção inválida! Por favor, tente novamente");
            }
        }
        while(selecao != 1 && selecao != 2);

        if(selecao == 1){
            return true;
        }
        return false;
    }
}
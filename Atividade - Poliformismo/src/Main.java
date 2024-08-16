import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int operacao = 0;
        do {
            operacao = menuPrincipal();

            switch(operacao){
                case 0:
                    System.out.println("Operação Finalizada");
                    break;
                case 1:
                    System.out.println("Cadastrar novo Cliente");
                    break;
                case 2:
                    System.out.println("Cadastrar novo Veiculo");
                    break;
                case 3:
                    System.out.println("Cadastrar nova Locacao");
                    break;
                default:
                    System.out.println("Seleção Invália, por favor, tente novamente!");
                    break;
            }
        }while (operacao != 0);
    }

    public static int menuPrincipal(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n============== Menu Principal ==============");
        System.out.println("1 - Cadastrar Clientes");
        System.out.println("2 - Cadastrar Veiculos");
        System.out.println("3 - Realizar Reservas Clientes");
        System.out.println("-------------------------------------------");
        System.out.print("Selecione uma Opção: ");
        int op = scan.nextInt();
        System.out.println("============================================\n\n");

        return op;
    }
}
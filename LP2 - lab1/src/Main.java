import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Usuario user;
        Conta conta;
        Scanner input = new Scanner(System.in);
        int escolha;
        int escolha_banco;
        while(true){
            Banco.menu();
            escolha = input.nextInt();
            switch(escolha){
                case 0:
                    System.out.println("SAINDO DO APLICATIVO...");
                    return;
                case 1:
                    user = new Usuario();
                    Banco.add_usuario(user);
                    break;
                case 2:
                    conta = Banco.adicionar_conta();
                    break;
                case 3:
                    conta = Banco.login(Banco.get_lista_conta());
                    while(true){
                        if(conta != null){
                            Banco.menu_banco();
                            escolha_banco = input.nextInt();
                            switch(escolha_banco){
                                case 0:
                                    System.out.println("SAINDO DO BANCO...");
                                    return;
                                case 1:
                                    System.out.println("Saldo da conta: " + conta.get_saldo() + "R$");
                                    break;
                                case 2:
                                    Banco.fazer_saque(conta);
                                    break;
                                case 3:
                                    Banco.fazer_deposito(conta);
                                    break;
                                case 4:
                                    Banco.fazer_pix(conta);
                                    break;
                                case 5:
                                    System.out.println("Faça login com a nova conta: ");
                                    Conta aux = conta;
                                    conta = Banco.login(Banco.get_lista_conta());
                                    if(conta == null){
                                        conta = aux;
                                    }
                                    break;
                            }
                        }
                        else{
                            break;
                        }
                    }
            }
        }
    }
}
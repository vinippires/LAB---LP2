import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
    private static List<Conta> contas = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();

    public static void add_usuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public static List<Usuario> get_lista_usuario(){
        return usuarios;
    }

    public static void add_conta(Conta conta){
        contas.add(conta);
    }

    public static List<Conta> get_lista_conta(){
        return contas;
    }

    public static void menu(){
        System.out.println("\nMENU:");

        System.out.println("DIGITE 1 PARA CADASTRAR UM USUÁRIO");
        System.out.println("DIGITE 2 PARA CADASTRAR UMA CONTA");
        System.out.println("DIGITE 3 PARA ACESSAR O BANCO");
        System.out.println("DIGITE 0 PARA SAIR");
    }

    public static void menu_banco(){
        System.out.println("\nBem-Vindo ao banco top");

        System.out.println("DIGITE 1 PARA CONSULTAR SALDO");
        System.out.println("DIGITE 2 PARA REALIZAR UM SAQUE");
        System.out.println("DIGITE 3 PARA FAZER UM DEPOSITO");
        System.out.println("DIGITE 4 PARA FAZER UMA TRANSFERENCIA");
        System.out.println("DIGITE 5 PARA TROCAR DE CONTA");
        System.out.println("DIGITE 0 PARA SAIR");
    }

    public static Conta login(List<Conta> lista){
        System.out.print("Digite o id da sua conta: ");
        Scanner input = new Scanner(System.in);
        String id_do_cara = input.nextLine();

        for(int i = 0; i < lista.size(); i++){
            if(String.valueOf(lista.get(i).get_id()).equals(id_do_cara)){
                if(Banco.autenticacao(lista.get(i).get_usuario())){
                    System.out.println("login realizado! bem-vindo " + lista.get(i).get_nome());
                    return lista.get(i);
                }
                else{
                    return null;
                }
            }
        }
        System.out.println("Nao existe conta cadastrada com esse cpf.");
        return null;
    }

    public static boolean autenticacao(Usuario usuario){
        System.out.print("Digite sua senha: ");
        Scanner input = new Scanner(System.in);
        String suposta_senha = input.nextLine();

        if(usuario.get_senha().equals(suposta_senha)){
            return true;
        }
        else{
            System.out.println("Senha errada!");
            return false;
        }
    }

    public static Conta adicionar_conta(){
        List<Usuario> lista = Banco.get_lista_usuario();
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o cpf do usuario da conta: ");
        String m_cpf = input.nextLine();

        for(int i = 0; i < lista.size(); i++){

            if(lista.get(i).get_cpf().equals(m_cpf)){
                if(Banco.autenticacao(lista.get(i))){
                    Conta nova_conta;
                    nova_conta = new Conta(lista.get(i));
                    System.out.println("CONTA CRIADA COM SUCESSO!");
                    System.out.println();
                    Banco.add_conta(nova_conta);
                    nova_conta.designar_id(Banco.get_lista_conta().size());
                    System.out.println("O id dessa conta é " + nova_conta.get_id());
                    return nova_conta;
                }
            }
        }
        System.out.println("nao foi possivel criar uma nova conta. usuario nao cadastrado.");
        return null;
    }

    public static void fazer_saque(Conta conta){
        Scanner input = new Scanner(System.in);
        System.out.print("digite o valor a ser sacado: ");
        double dinheiro = input.nextDouble();
        conta.sacar(dinheiro);
    }

    public static void fazer_deposito(Conta conta){
        Scanner input = new Scanner(System.in);
        System.out.print("digite o valor a ser depositado: ");
        double dinheiro = input.nextDouble();
        conta.depositar(dinheiro);
    }

    public static Conta procurar_conta(String m_cpf){
        List<Conta> lista = Banco.get_lista_conta();
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).get_cpf().equals(m_cpf)){
                return lista.get(i);
            }
        }

        System.out.print("nao foi possivel achar conta com esse cpf");
        return null;
    }

    public static void fazer_pix(Conta pobre){

        Scanner input = new Scanner(System.in);
        System.out.print("Digite o cpf do usuario da conta a receber o pix: ");
        String m_cpf = input.nextLine();

        Conta favorecido = Banco.procurar_conta(m_cpf);
        if(favorecido != null){
            System.out.print("digite o valor do pix: ");
            double dinheiro = input.nextDouble();

            pobre.transferencia(favorecido, dinheiro);
        }
    }
}
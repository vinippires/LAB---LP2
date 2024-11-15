import java.util.Scanner;

public class Conta {

    private Usuario pessoa;
    private int id;
    private double saldo;

    public Conta(Usuario n_pessoa){
        this.pessoa = n_pessoa;
        this.saldo = 1000.00;
    }

    public double get_saldo(){
        return this.saldo;
    }

    public String get_nome(){
        return this.pessoa.get_nome();
    }

    public Usuario get_usuario(){
        return pessoa;
    }

    public String get_cpf(){
        return this.pessoa.get_cpf();
    }

    public void depositar(double dinheiro){
        if(dinheiro < 0){
            System.out.println("Tentativa de deposito falha.");
        }
        else{
            this.saldo = this.saldo + dinheiro;
        }
    }

    public void sacar(double dinheiro){
        if(dinheiro > this.saldo){
            System.out.println("Tentativa de saque falha. Saque maior que Saldo.");
        }
        else if(dinheiro < 0){
            System.out.println("Tentativa de saque falha.");
        }
        else{
            System.out.println("Saque efetuado com sucesso!");
            this.saldo = this.saldo - dinheiro;
        }
    }

    public void transferencia(Conta favorecido, double valor){
        if(this.get_saldo() >= valor && valor >= 0){
            favorecido.depositar(valor);
            this.sacar(valor);
            System.out.println("Transferencia efetuada com sucesso!");
        }
        else{
            System.out.println("Transferencia falha");
        }
    }

    public void designar_id(int numero){
        this.id = numero;
    }

    public int get_id(){
        return this.id;
    }
}

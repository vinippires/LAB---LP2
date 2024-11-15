import java.util.Scanner;

public class Usuario {

    private String nome;
    private String cpf;
    private String senha;

    public Usuario(){
        Scanner input = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String n_nome = input.nextLine();
        this.nome = n_nome;

        System.out.print("Digite seu cpf: ");
        String n_cpf = input.nextLine();
        this.cpf = n_cpf;

        System.out.print("Crie uma senha: ");
        String n_senha = input.nextLine();
        this.senha = n_senha;

        System.out.println("Usuario criado com sucesso!");
    }

    public void set_nome(String n_nome){
        this.nome = n_nome;
    }

    public void set_cpf(String n_cpf){
        this.cpf = n_cpf;
    }

    public void set_senha(String n_senha){
        this.senha = n_senha;
    }

    public String get_nome(){
        return this.nome;
    }

    public String get_cpf(){
        return this.cpf;
    }

    public String get_senha(){
        return this.senha;
    }
    
}

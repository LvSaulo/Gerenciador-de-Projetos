import java.util.Scanner;

public class Users {

    public int id;
    public String senha;
    public String name;
    public String ocupacao;

    public Users(int id, String name, String ocupacao, String senha) {
        this.id = id;
        this.senha = senha;
        this.name = name;
        this.ocupacao = ocupacao;
    }

    
    public void addUsers() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Digite seu id: ");
        this.id = input.nextInt();

        System.out.println("Digite sua senha: ");
        this.senha = input.next();

        System.out.println("Digite seu nome: ");
        this.name = input.next();

        System.out.println("Digite sua ocupação: ");
        this.ocupacao = input.next();

    }

    public void removeUsers() {
        this.id = -1;
        this.senha = null;
        this.name = null;
        this.ocupacao = null;

    }

    public void editUsers() {
        Scanner input = new Scanner(System.in);

        String edit;

        boolean i = true;
        while(i) {
            i = false;

            System.out.println("O que deseja editar: ");
            edit = input.next();

            if(edit.equalsIgnoreCase("id")) {
                System.out.println("\nDigite seu novo ID: ");
                this.id = input.nextInt();
            }
            else if(edit.equalsIgnoreCase("senha")) {
                System.out.println("\nDigite sua nova senha: ");
                this.senha = input.next();
            }
            else if(edit.equalsIgnoreCase("nome")) {
                System.out.println("\nDigite seu novo nome: ");
                this.name = input.next();
            }
            else if(edit.equalsIgnoreCase("ocupacao")) {
                System.out.println("\nDigite sua nova ocupacao: ");
                this.ocupacao = input.next();
            } else {
                System.out.println("\nDigite uma opção válida!\n");
                i = true;
            }
        } 
    }
}

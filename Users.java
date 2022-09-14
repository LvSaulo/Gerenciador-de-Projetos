import java.util.Scanner;



public class Users {

    public int id;
    public String senha;
    public String name;
    public String ocupacao;
    public double valor_bolsa;
    public double tempo_bolsa; // em horas

    public Users(int id, String name, String senha, Double valor_bolsa, Double tempo_bolsa) {
        this.id = id;
        this.senha = senha;
        this.name = name;
        this.valor_bolsa = valor_bolsa;
        this.tempo_bolsa = tempo_bolsa;
    }

    public int getID() {return this.id;}
    public String getSenha() {return this.senha;}
    public String getName() {return this.name;}
    public Double getValorBolsa() {return this.valor_bolsa;}

    public void addUsers() {
        setPassword();
        setName();
        setStatusUser();
        setValorBolsa();
        setTempoBolsa();
    }

    Scanner input = new Scanner(System.in);
    public void setPassword() {
        System.out.println("Digite sua senha: ");
        this.senha = input.next();
    }
    public void setName() {
        System.out.println("Digite seu nome: ");
        this.name = input.next();
    }
    public void setStatusUser() {
        System.out.println("Tipos de usuarios: Aluno, Professor, Pesquisador, Profissional, Tecnico.\n");
        System.out.println("Digite seu tipo de usuario: ");
        StatusUser status = StatusUser.valueOf(input.nextLine().toUpperCase());
    }
    public void setValorBolsa() {
        System.out.println("Digite o valor da bolsa: ");
        this.valor_bolsa = input.nextDouble();
    }
    public void setTempoBolsa() {
        System.out.println("Digite o tempo da bolsa: ");
        this.tempo_bolsa = input.nextDouble();
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
                StatusUser status = StatusUser.valueOf(input.nextLine().toUpperCase());
            } else {
                System.out.println("\nDigite uma opção válida!\n");
                i = true;
            }
        } 
    }
}

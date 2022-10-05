import java.util.Scanner;



public class Users {

    private int id;
    private String senha;
    private String name;
    private int cargo;
    private double valor_bolsa;
    private double tempo_bolsa; // em horas

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
        System.out.println("Tipos de usuarios:\n1 - Aluno\n2 - Professor\n3 - Pesquisador\n4 - Profissional\n5 - Tecnico.\n");

        System.out.println("Digite seu tipo de usuario: ");
        cargo = input.nextInt();

        if(cargo == 1) {StatusUser status = StatusUser.ALUNO;}
        else if(cargo == 2) {StatusUser status = StatusUser.PROFESSOR;}
        else if(cargo == 3) {StatusUser status = StatusUser.PESQUISADOR;}
        else if(cargo == 4) {StatusUser status = StatusUser.PROFISSIONAL;}
        else if(cargo == 5) {StatusUser status = StatusUser.TECNICO;}
        //
    }
    public void setValorBolsa() {
        System.out.println("Digite o valor da bolsa: ");
        this.valor_bolsa = input.nextDouble();
    }
    public void setTempoBolsa() {
        System.out.println("Digite o tempo da bolsa: ");
        this.tempo_bolsa = input.nextDouble();
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

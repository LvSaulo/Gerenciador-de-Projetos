package GerenciadorDeProjetos.ProjetoOO;
import java.util.Scanner;

public class Coordenador implements Users {

    public int id;
    public String email;
    public String senha;
    public String name;
    private int cargo;
    public StatusUser status;

    public Coordenador() {}

    public Coordenador(int id, String email, String name, String senha, StatusUser status) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.name = name;
        this.status = status;
    }

    @Override
    public int getID() {return this.id;}

    @Override
    public String getEmail() {return this.email;}

    @Override
    public String getPassword() {return this.senha;}

    @Override
    public String getName() {return this.name;}

    @Override
    public StatusUser getStatusUser() {return this.status;}



    Scanner input = new Scanner(System.in);

	public void setID() {
		System.out.println("Digite seu ID: ");
        this.id = input.nextInt();
	}

    public void setEmail() {
        System.out.println("Digite seu email: ");
        this.email = input.next();
    }

    public void setPassword() {
        System.out.println("Digite sua senha: ");
        this.senha = input.next();
    }

    public void setName() {
        System.out.println("Digite seu nome: ");
        this.name = input.next();
    }

    public void setStatusUser() {
        System.out.println(
                "Tipos de usuarios:\n1 - Aluno\n2 - Professor\n3 - Pesquisador\n4 - Profissional\n5 - Tecnico.\n");

        System.out.println("Digite seu tipo de usuario: ");
        cargo = input.nextInt();

        if (cargo == 1) {
            this.status = StatusUser.ALUNO;
        } else if (cargo == 2) {
            this.status = StatusUser.PROFESSOR;
        } else if (cargo == 3) {
            this.status = StatusUser.PESQUISADOR;
        } else if (cargo == 4) {
            this.status = StatusUser.PROFISSIONAL;
        } else if (cargo == 5) {
            this.status = StatusUser.TECNICO;
        }
        //
    }




    @Override
    public String printUserInfo() {
        return "Nome: " + this.name + "\nID: " + this.id + "\nCargo: " + this.status;
    }
    
}

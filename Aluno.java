package GerenciadorDeProjetos.ProjetoOO;
import java.util.Scanner;

public class Aluno implements User {

    public int id;
    public String email;
    public String senha;
    public String name;
    private int cargo;
    public StatusUser status;
    public int tempo_bolsa;
    private Double valor_bolsa;

    public Aluno() {

    }

    public Aluno(int id, String email, String name, String senha, StatusUser status, int tempo_bolsa, Double valor_bolsa) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.name = name;
        this.status = status;
        this.tempo_bolsa = tempo_bolsa;
        this.valor_bolsa = valor_bolsa;
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
    public int getTempoBolsa() {return this.tempo_bolsa;}
    public Double getValorBolsa() {return this.valor_bolsa;}

    Scanner input = new Scanner(System.in);

    public void setID() {
        this.id = GetInputs.getIntInput("Digite seu ID: ", "ERROR! O ID deve conter apenas números");
        if(this.id < 0) return;
	}

    @Override
    public void setEmail() {
        System.out.println("Digite seu email: ");
        this.email = GetInputs.getStringInput("Digite seu email: ", "ERROR! O ID deve conter apenas números");
        if(this.email == null) return;
    }

    public void setPassword() {
        this.senha = GetInputs.getStringInput("Digite sua senha: ", "ERROR! O ID deve conter apenas números");
        if(this.senha == null) return;
    }

    public void setName() {
        this.name = GetInputs.getStringInput("Digite seu nome: ", "ERROR! O ID deve conter apenas números");
        if(this.name == null) return;
    }

    public void setStatusUser() {
        System.out.println("Tipos de usuarios:\n1 - Aluno\n2 - Professor\n3 - Pesquisador\n4 - Profissional\n5 - Tecnico.\n");

        cargo = GetInputs.getIntInput("Digite sua opção: ", "ERROR! A opção deve ser um numero");
        if(cargo < 0) return;

        switch (cargo) {
            case 1:
                this.status = StatusUser.ALUNO;
                break;
            case 2:
                this.status = StatusUser.PROFESSOR;
                break;
            case 3:
                this.status = StatusUser.PESQUISADOR;
                break;
            case 4:
                this.status = StatusUser.PROFISSIONAL;
                break;
            case 5:
                this.status = StatusUser.TECNICO;
                break;
            default:
                return;
        }
    }

    public void setValorBolsa() {
        System.out.println("Digite o valor da bolsa: ");
        this.valor_bolsa = GetInputs.getDoubleInput("Digite o valor da bolsa: ", "ERROR! o valor da bolsa deve ser um numero");
        if(this.valor_bolsa == -1) return;

    }

    public void setTempoBolsa() {
        System.out.println("(em meses) Digite o tempo da bolsa: ");
        this.tempo_bolsa = GetInputs.getIntInput("Digite o tempo da bolsa: ", "ERROR! o tempo da bolsa deve ser um numero");
        if(this.tempo_bolsa == -1) return;
    }




    @Override
    public String printUserInfo() {
        return "Nome: " + this.name + "\nID: " + this.id + "\nCargo: " + this.status;
    }

    @Override
    public String toString() {
        return "Nome: " + this.name + "\nID: " + this.id + "\nCargo: " + this.status + "\nValor da bolsa: " + this.valor_bolsa + "\nTempo da bolsa: " + this.tempo_bolsa + " meses";
    }

}

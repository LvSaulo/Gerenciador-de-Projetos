package GerenciadorDeProjetos.ProjetoOO;

import java.util.Scanner;
import java.util.ArrayList;

public class Atividade implements InterPA {

    ArrayList<Users> users = new ArrayList<Users>();
    ArrayList<Users> users_atividade = new ArrayList<Users>();

    private String identificacao;
    private String descricao;
    private String data_i, hora_i, data_t, hora_t;
    private String responsavel;
    private String profissionais;
    private String[] tarefas_per_profissional;

    private int qntP = 1;
    private int tarefas;

    public Atividade(String identificacao, String descricao, String data_i, String data_t, String hora_i, String hora_t, String responsavel, String profissionais, String[] tarefas_per_profissional,
    ArrayList<Users> users) {
        this.identificacao = identificacao;
        this.descricao = descricao;
        this.data_i = data_i;
        this.hora_i = hora_i;
        this.data_t = data_t;
        this.hora_t = hora_t;
    }

    @Override
    public String getId() {return this.identificacao;}
    @Override
    public String getDesc() {return this.descricao;}
    @Override
    public String getDataI() {return this.data_i;}
    @Override
    public String getHoraI() {return this.hora_i;}
    @Override
    public String getDataT() {return this.data_t;}
    @Override
    public String getHoraT() { return this.hora_t;}

    @Override
    public void setId() {
        System.out.println("Identificação do projeto: ");
        this.identificacao = in.next();
    }

    Scanner in = new Scanner(System.in);

    @Override
    public void setDesc() {
        System.out.print("Descrição do projeto: ");
        this.descricao = in.next();
    }

    @Override
    public void setDataI() {
        System.out.print("Digite a data de inicio: ");
        this.data_i = in.next();
    }

    @Override
    public void setHoraI() {
        System.out.println("Digite a hora de inicio: ");
        this.hora_i = in.next();
    }

    @Override
    public void setDataT() {
        System.out.println("Digite a data de termino: ");
        this.data_t = in.next();
    }

    @Override
    public void setHoraT() {
        System.out.println("Digite a hora de termino: ");
        this.hora_t = in.next();
    }
    
    public void setResponsavel() {
        System.out.println("Digite o nome do responsavel da Atividade: ");
        this.responsavel = in.next();
    }

    public void setProfissional() {
        System.out.println("Digite o id do profissional: ");
        int id_profissional = in.nextInt();
        for (int i = 0; i < this.users.size(); i++) {
            if (id_profissional == this.users.get(i).getID()) {
                users_atividade.add(this.users.get(i));
                break;
            } else if (i == this.users.size() - 1) {
                System.out.println("Usuario não encontrado");
                break;
            }
        }

        System.out.println("Quantas atividades esse profissional vai exercer? ");
        tarefas = in.nextInt();

        taref(tarefas);
    }

    public void taref(int tarefas) {
        for (int j = 0; j < tarefas; j++) {
            System.out.printf("Digite o nome da atividade que o profissional %s vai fazer: ", users.get(j).getName());
            this.tarefas_per_profissional[j] = in.next();
        }
    }



    public String printAtividadeInfo() {
        return "Identificação: " + this.identificacao + "Descrição: " + this.descricao + "Data de inicio: "
                + this.data_i + "Hora de inicio: " + this.hora_i + "Data de término: " + this.data_t
                + "Hora de Término: " + this.hora_t + "Responsável: " + this.responsavel + "Profissionais: " + this.profissionais + "\nTarefas: " + this.tarefas_per_profissional;
    }
}

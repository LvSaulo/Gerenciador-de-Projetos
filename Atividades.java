import java.util.Scanner;
import java.util.ArrayList;

public class Atividades {

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

    public Atividades(String identificacao, String descricao, String data_i, String hora_i, String data_t,
            String hora_t, String responsavel, String profissionais, String[] tarefas_per_profissional, ArrayList<Users> users) {
        
        this.identificacao = identificacao;
        this.descricao = descricao;
        this.data_i = data_i;
        this.data_t = data_t;
        this.hora_i = hora_i;
        this.hora_t = hora_t;
        this.responsavel = responsavel;
        this.profissionais = profissionais;
        this.tarefas_per_profissional = tarefas_per_profissional;
        this.users = users;
    }

    public String getId() {return this.identificacao;}
    public String getDesc() {return this.descricao;}
    public String getDataI() {return this.data_i;}
    public String getHoraI() {return this.hora_i;}
    public String getDataT() {return this.data_t;}
    public String getHoraT() {return this.hora_t;}
    public String getResponsavel() {return this.responsavel;}
    public String getProfissional() {return this.profissionais;}
    public String[] getTarefas() {return tarefas_per_profissional;}


    Scanner in = new Scanner(System.in);
    
    public void desc() {
        System.out.print("Descrição da Atividade: ");
        this.descricao = in.next();
    }
    public void dataI() {
        System.out.print("Digite a data de inicio: ");
        this.data_i = in.next();
    }
    public void horaI() {
        System.out.println("Digite a hora de inicio: ");
        this.hora_i = in.next();
    }
    
    public void dataT() {
        System.out.println("Digite a data de termino: ");
        this.data_t = in.next();
    }
    public void horaT() {
        System.out.println("Digite a hora de termino: ");
        this.hora_t = in.next();
    }
    public void responsavelA() {
        System.out.println("Digite o nome do responsavel da Atividade: ");
        this.responsavel = in.next();
    }
    public void profissional() {
        System.out.println("Digite o id do profissional: ");
        int id_profissional = in.nextInt();
        for(int i = 0; i < this.users.size(); i++) {
            if(id_profissional == this.users.get(i).getID()) {
                users_atividade.add(this.users.get(i));
                break;
            }
            else if(i == this.users.size()-1) {
                System.out.println("Usuario não encontrado");
                break;
            }
        }

        System.out.println("Quantas atividades esse profissional vai exercer? ");
        tarefas = in.nextInt();

        taref(tarefas);
    }
    public void taref(int tarefas) {
        for(int j = 0; j < tarefas; j++) {
            System.out.printf("Digite o nome da atividade que o profissional %s vai fazer: ", users.get(j).getName());
            this.tarefas_per_profissional[j] = in.next();
        }
    }

    public void addAtividades() {
        Scanner in = new Scanner(System.in);

        System.out.println("Vamos começar a criação da Atividade!\n\n");

        desc();
        dataI();
        horaI();
        dataT();
        horaT();
        responsavelA();

        System.out.println("Quantos profissionais vão participar da atividade? ");
        qntP = in.nextInt(); // salva a quantidade de profissionais
        for(int i = 0; i < qntP; i++) {
            profissional();
        }
               
              

        /*for(int i = 0; i < qntP; i++) {}/* */      
    }
}

import java.util.Scanner;

public class Atividades {

    public String identificacao;
    public String descricao;
    public String data_i, hora_i, data_t, hora_t;
    public String responsavel;
    public String profissionais;
    public String[] tarefas_per_profissional;

    public int qntP;
    public int tarefas;

    public Atividades(String identificacao, String descricao, String data_i, String hora_i, String data_t,
            String hora_t, String responsavel, String profissionais, String[] tarefas_per_profissional) {
        
        this.identificacao = identificacao;
        this.descricao = descricao;
        this.data_i = data_i;
        this.data_t = data_t;
        this.hora_i = hora_i;
        this.hora_t = hora_t;
        this.responsavel = responsavel;
        this.profissionais = profissionais;
        this.tarefas_per_profissional = tarefas_per_profissional;
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
        System.out.println("Digite o nome do profissional: ");
        this.profissionais = in.next();

        System.out.println("Quantas atividades esse profissional vai exercer? ");
        tarefas = in.nextInt();

        taref(tarefas);
    }
    public void taref(int tarefas) {
        for(int j = 0; j < tarefas; j++) {
            System.out.printf("Digite o nome da atividade que o profissional %s vai fazer: ", this.profissionais);
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
        profissional();       
              
        /*System.out.println("Quantos profissionais vão participar do projeto? ");
        qntP = in.nextInt(); // salva a quantidade de profissionais */

        /*for(int i = 0; i < qntP; i++) {}/* */      
    }

    public void removeAtividades() {
        this.identificacao = null;
        this.descricao = null;
        this.data_i = null;
        this.data_t = null;
        this.hora_i = null;
        this.hora_t = null;
        this.profissionais = null;
        this.tarefas_per_profissional = null;
    }

    public void editAtividades() {
        
    }
}

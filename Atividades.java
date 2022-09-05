import java.util.Scanner;

public class Atividades {

    public String identificacao;
    public String descricao;
    public String data_i, hora_i, data_t, hora_t;
    public String responsavel;
    public String[] profissionais;
    public String[][] tarefas_per_profissional;

    public int qntP;
    public int[] tarefas;

    public Atividades(String identificacao, String descricao, String data_i, String hora_i, String data_t,
            String hora_t, String responsavel, String[] profissionais, String[][] tarefas_per_profissional) {
        
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

    public void addAtividades() {
        Scanner in = new Scanner(System.in);

        System.out.println("Vamos começar a criação da Atividade!\n\n");

        System.out.println("Digite a identificacao da Atividade: ");
        this.identificacao = in.next();

     /* for( ) { // checa todas as identificacoes existentes
            if(this.identificacao == ??) { // Ver se já existe alguma identificao para atividades igual
                System.out.println("\nEssa identificao já existe, digite uma nova: ");
                this.identificacao = in.next();
            }
        } */

        System.out.print("Descrição da Atividade: ");
        this.descricao = in.next();

        System.out.print("Digite a data de inicio: ");
        this.data_i = in.next();

        System.out.println("Digite a hora de inicio: ");
        this.hora_i = in.next();

        System.out.println("Digite a data de termino: ");
        this.data_t = in.next();

        System.out.println("Digite a hora de termino: ");
        this.hora_i = in.next();

        System.out.println("Digite o nome do responsavel da Atividade: ");
        this.responsavel = in.next();

        System.out.println("Quantos profissionais vão participar do projeto? ");
        qntP = in.nextInt(); // salva a quantidade de projetos

        for(int i = 0; i < qntP; i++) {
            System.out.println("Digite o nome do profissional: ");
            this.profissionais[i] = in.next();

            System.out.println("Quantas atividades esse profissional vai exercer? ");
            tarefas[i] = in.nextInt();

            for(int j = 0; j < tarefas[i]; j++) {
                System.out.printf("Digite o nome da atividade que o profissional %s vai fazer: ", this.profissionais[i]);
                this.tarefas_per_profissional[i][j] = in.next();
            }
        }
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

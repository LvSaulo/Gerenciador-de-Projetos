import java.util.Scanner;

public class Projetos {

    public String identificacao;
    public String descricao;
    public String data_i, hora_i, data_t, hora_t;
    public String[] profissionais;
    public String coordenador;
    public String[] atividades;
    public double[] valor_bolsa;
    public double tempo_bolsa;

    public int qntP; // Quantidade de profissionais
    public int qntA; // Quantidade de Atividades

    public Projetos(String identificacao, String descricao, String data_i, String data_t, String hora_i, String hora_t,
            String coordenador, String[] profissionais, String[] atividades, double[] valor_bolsa, double tempo_bolsa) {
        
        this.identificacao = identificacao;
        this.descricao = descricao;
        this.data_i = data_i;
        this.data_t = data_t;
        this.hora_i = hora_i;
        this.hora_t = hora_t;
        this.coordenador = coordenador;
        this.profissionais = profissionais;
        this.atividades = atividades;
        this.valor_bolsa = valor_bolsa;
        this.tempo_bolsa = tempo_bolsa;
    }

    public void addProjetos() {
        Scanner in = new Scanner(System.in);

        System.out.println("Vamos começar a criação do projeto!\n\n");

        System.out.println("Digite a identificacao do projeto: ");
        this.identificacao = in.next();

     /* for( ) { // checa todas as identificacoes existentes
            if(this.identificacao == ??) { // Ver se já existe alguma identificao para projetos igual
                System.out.println("\nEssa identificao já existe, digite uma nova: ");
                this.identificacao = in.next();
            }
        } */

        System.out.print("Descrição do projeto: ");
        this.descricao = in.next();

        System.out.print("Digite a data de inicio: ");
        this.data_i = in.next();

        System.out.println("Digite a hora de inicio: ");
        this.hora_i = in.next();

        System.out.println("Digite a data de termino: ");
        this.data_t = in.next();
;
        System.out.println("Digite a hora de termino: ");
        this.hora_i = in.next();

        System.out.println("Digite o nome do coordenador do projeto: ");
        this.coordenador = in.next();

        System.out.println("Quantos profissionais vão participar do projeto? ");
        qntP = in.nextInt(); // salva a quantidade de projetos

        for(int i = 0; i < qntP; i++) {
            System.out.println("Digite o nome do profissional: ");
            this.profissionais[i] = in.next();
        }

        System.out.println("Quantas atividades serão feitas? ");
        qntA = in.nextInt(); 

        for(int i = 0; i < qntA; i++) {
            System.out.println("Digite o nome da atividade: ");
            this.atividades[i] = in.next();
        }

        for(int i = 0; i < qntP; i++) {
            System.out.printf("Digite o valor da bolsa do profissional %s: ", this.profissionais[i]);
            this.valor_bolsa[i] = in.nextDouble();
        }

        System.out.println("digite o tempo da bolsa: ");
        this.tempo_bolsa = in.nextDouble();
    }

    public void removeProjetos() {
        this.identificacao = null;
        this.descricao = null;
        this.data_i = null;
        this.data_t = null;
        this.hora_i = null;
        this.hora_t = null;
        this.coordenador = null;
        this.profissionais = null;
        this.atividades = null;
        this.valor_bolsa = null;
        this.tempo_bolsa = -1;
    }

    public void editPojetos() {
        Scanner in = new Scanner(System.in);

        String edit;

        boolean i = true;
        while (i) {
            i = false;

            System.out.println("O que deseja editar: ");
            edit = in.next();

            if(edit.equalsIgnoreCase("identificacao")) {
                System.out.println("Digite a nova identificacao do projeto: ");
                this.identificacao = in.next();
            }
            else if(edit.equalsIgnoreCase("descricao")) {
                System.out.println("Digite a nova descricao do projeto: ");
                this.descricao = in.next();
            }
            else if(edit.equalsIgnoreCase("data de inicio")) {
                System.out.println("Digite a nova data de inicio do projeto: ");
                this.data_i = in.next();
            }
            else if(edit.equalsIgnoreCase("hora de inicio")) {
                System.out.println("Digite a nova hora de inicio do projeto: ");
                this.hora_i = in.next();
            }
            else if(edit.equalsIgnoreCase("data de termino")) {
                System.out.println("Digite a nova data de termino do projeto: ");
                this.data_t = in.next();
            }
            else if(edit.equalsIgnoreCase("hora de termino")) {
                System.out.println("Digite a nova hora de termino do projeto: ");
                this.hora_t = in.next();
            }
            else if(edit.equalsIgnoreCase("coordenador")) {
                System.out.println("Digite o novo coordenador do projeto: ");
                this.data_i = in.next();
            }
            else if(edit.equalsIgnoreCase("profissionais")) {
                System.out.println("Digite 1 para adicionar um novo profissional, 2 para excluir um profissional e 3 para editar um profissional: ");
                int editP = in.nextInt();
                if(editP == 1) {
                    qntP++;
                    System.out.println("Digite o nome do profissional: ");
                    this.profissionais[qntP-1] = in.next();
                }
                else if(editP == 2) {
                    System.out.println("Qual o nome do profissional que deseja remover: ");
                    String name_removeP = in.next();
                    for(int j = 0; j < qntP; j++) {
                        if(name_removeP.equals(this.profissionais[j])) {
                            this.profissionais[j] = null;
                            qntP--;
                        }
                    }
                }
                else if(editP == 3) {
                    System.out.println("Qual o nome do profissional que deseja editar: ");
                    String name_editP = in.next();
                    for(int j = 0; j < qntP; j++) {
                        if(name_editP.equals(this.profissionais[j])) {
                            System.out.println("Digite o novo nome do profissional: ");
                            this.profissionais[j] = in.next();
                        }
                    }
                }   
            }
            else if(edit.equalsIgnoreCase("atividades")) {
                System.out.println("Digite 1 para adicionar uma nova atividade, 2 para excluir uma atividade e 3 para editar uma atividade: ");
                int editA = in.nextInt();
                if(editA == 1) {
                    qntA++;
                    System.out.println("Digite o nome da atividade: ");
                    this.atividades[qntA-1] = in.next();
                }
                else if(editA == 2) {
                    System.out.println("Qual o nome da atividade que deseja remover: ");
                    String name_removeA = in.next();
                    for(int j = 0; j < qntA; j++) {
                        if(name_removeA.equals(this.atividades[j])) {
                            atividades[j] = null;
                            qntA--;
                        }
                    }
                }
                else if(editA == 3) {
                    System.out.println("Qual o nome da atividade que deseja editar: ");
                    String name_editA = in.next();
                    for(int j = 0; j < qntA; j++) {
                        if(name_editA.equals(this.atividades[j])) {
                            System.out.println("Digite o novo nome da atividade: ");
                            this.atividades[j] = in.next();
                        }
                    }
                }
            }
            else if(edit.equalsIgnoreCase("valor da bolsa")) {
                System.out.println("De qual profissional deseja editar o valor da bolsa? ");
                String edit_valor_bolsa_name = in.next(); // guarda o nome do profissional pra ter o valor da bolsa editado
                for (int j = 0; j < this.profissionais.length; j++) {
                    if(edit_valor_bolsa_name == this.profissionais[j]) {
                        System.out.println("Digite o novo valor da bolsa: ");
                        this.valor_bolsa[j] = in.nextDouble();
                    }
                }
            }
            else if(edit.equalsIgnoreCase("tempo da bolsa")) {
                System.out.println("Digite o novo tempo da bolsa(em horas): ");
                this.tempo_bolsa = in.nextDouble();
            } else {
                System.out.println("\nDigite uma opção válida!\n");
                i = true;
            }
        }
    }
}

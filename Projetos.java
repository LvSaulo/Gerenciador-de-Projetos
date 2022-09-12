import java.util.Scanner;
import java.util.ArrayList;

public class Projetos {

    ArrayList<Atividades> atividades = new ArrayList<Atividades>(); 

    public String identificacao;
    public String descricao;
    public String data_i, hora_i, data_t, hora_t;
    public String[] profissionais;
    public String coordenador;
    public double[] valor_bolsa;
    public double tempo_bolsa;
    public int stt;

    public int qntP; // Quantidade de profissionais
    public int qntA; // Quantidade de Atividades

    public Projetos(String identificacao, String descricao, String data_i, String data_t, String hora_i, String hora_t,
            String coordenador, String[] profissionais) {
        
        this.identificacao = identificacao;
        this.descricao = descricao;
        this.data_i = data_i;
        this.data_t = data_t;
        this.hora_i = hora_i;
        this.hora_t = hora_t;
        this.coordenador = coordenador;
        this.profissionais = profissionais;
        this.atividades = atividades;
        this.stt = -1;
    }

    public int getStatusProjeto() {return stt;}
    public String getId() {return this.identificacao;}
    public String getDescricao() {return this.descricao;}
    public String getDataI() {return this.data_i;}
    public String getHoraI() {return this.hora_i;}
    public String getDataT() {return this.data_t;}
    public String getHoraT() {return this.hora_t;}
    public String getCoord() {return this.coordenador;}
    public String[] getProfissional() {return this.profissionais;}
    

    public void statusProjeto() {
        Scanner in = new Scanner(System.in);
        System.out.println("0 - EM CRIACAO\n1 - EM ANDAMENTO\n2 - CONCLUIDO");
        System.out.println("Digite o novo status do Projeto: ");
        this.stt = in.nextInt();

        if(this.stt == 0) System.out.println("Em criação!");
        else if(this.stt == 1) System.out.println("Em andamento!");
        else if(this.stt == 2) System.out.println("Concluido!");
    }


    public void addAt() {
        Scanner in = new Scanner(System.in);

        System.out.println("Digite a idetenficacao da atividade: ");
        String id_at = in.next();

        for(int i = 0; i < atividades.size(); i++) {
            if(id_at == atividades.get(i).getId()) {
                System.out.println("Essa identificacao já existe para outro projeto\nTente novamente: ");
                id_at = in.next();
                i = 0;
            }
        }
        System.out.println("Quantos profissionais vão participar do projeto? ");
        qntP = in.nextInt(); // salva a quantidade de profissionais

        String[] at_profissionais = {"a"};
        String[] tarefas = {"g"};
        Atividades newAtividade = new Atividades(id_at, "a", "b", "2", "data_t", "hora_t", "responsavel", "at_profissionais", tarefas);
        newAtividade.addAtividades();
    }

    Scanner in = new Scanner(System.in);

    public void desc() {
        System.out.print("Descrição do projeto: ");
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
    public void coord() {
        System.out.println("Digite o nome do coordenador do projeto: ");
        this.coordenador = in.next();
    }
    public void profissional(int qnt) {
        for(int i = 0; i < qntP; i++) {
            System.out.println("Digite o nome do profissional: ");
            this.profissionais[i] = in.next();
        }
    }
    public void editProfissional() {

    }

    public void addProjetos() {
        

        System.out.println("Vamos começar a criação do projeto!\n\n");

        desc();
        dataI();
        horaI();
        dataT();
        horaT();
        coord();

        System.out.println("Quantos profissionais vão participar do projeto? ");
        qntP = in.nextInt(); // salva a quantidade de projetos
        profissional(qntP);


        addAt();

        /*for(int i = 0; i < qntP; i++) {
            System.out.printf("Digite o valor da bolsa do profissional %s: ", this.profissionais[i]);
            this.valor_bolsa[i] = in.nextDouble();
        }

        System.out.println("digite o tempo da bolsa: ");
        this.tempo_bolsa = in.nextDouble(); */
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

            /*if(edit.equalsIgnoreCase("identificacao")) {
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
            } */
            /*else*/ if(edit.equalsIgnoreCase("atividades")) {
                System.out.println("Digite 1 para adicionar uma nova atividade, 2 para excluir uma atividade e 3 para editar uma atividade: ");
                int editA = in.nextInt();
                if(editA == 1) {
                    addAt();
                    
                }
                else if(editA == 2) {
                    System.out.println("Qual a identifcacao da atividade que deseja remover: ");
                    String name_removeA = in.next();
                    for(int j = 0; j < atividades.size(); j++) {
                        if(atividades.get(j).getId().equals(name_removeA)) {
                            atividades.remove(j);
                            qntA--;
                        }
                    }
                }
                else if(editA == 3) {
                    System.out.println("Qual a identificao da atividade que deseja editar: ");
                    String name_editA = in.next();
                    for(int j = 0; j < atividades.size(); j++) {
                        if(atividades.get(j).getId().equals(name_editA)) {
                            System.out.println("O que deseja editar?");
                            System.out.println("1 para descrição\n2 para data de inicio\n3 para hora de inicio\n4 para data de termino\n5 para hora de termino\6 para responsavel\n7 para profissional\n");
                            int decide = in.nextInt();
                            if(decide == 1) {
                                atividades.get(j).desc();
                            }
                            else if(decide == 2) {
                                
                            }
                            else if(decide == 3) {
                                
                            }
                            else if(decide == 4) {
                                
                            }
                            else if(decide == 5) {
                                
                            }
                            else if(decide == 6) {
                                
                            }
                            else if(decide == 7) {
                                
                            }
                        }
                        else if(j == atividades.size()-1) {
                            System.out.println("Identificação não encontrada");
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

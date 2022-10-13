package GerenciadorDeProjetos.ProjetoOO;

import java.util.Scanner;
import java.util.ArrayList;

public class Projeto implements InterPA {

    ArrayList<Atividade> atividades = new ArrayList<Atividade>();
    ArrayList<Users> users = new ArrayList<Users>();
    ArrayList<Users> users_projeto = new ArrayList<Users>();
    ArrayList<Users> users_intercambio = new ArrayList<Users>();
    ArrayList<Users> users_associados = new ArrayList<Users>();

    private String identificacao;
    private String descricao;
    private String data_i, hora_i, data_t, hora_t;
    public String coordenador;
    private int stt;
    private int qntP;
    private int qntA;

    public Projeto(String identificacao, String descricao, String data_i, String data_t, String hora_i, String hora_t,
    String coordenador, ArrayList<Users> users) {
        this.identificacao = identificacao;
        this.descricao = descricao;
        this.data_i = data_i;
        this.hora_i = hora_i;
        this.data_t = data_t;
        this.hora_t = hora_t;
        this.coordenador = coordenador;
        this.atividades = atividades;
        this.stt = -1;
        this.users = users;
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
    public String getHoraT() {return this.hora_t;}
    public String getCoord() {return this.coordenador;}

    Scanner in = new Scanner(System.in);

    @Override
    public void setId() {
        System.out.println("Identificação do projeto: ");
        this.identificacao = in.next();
    }

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
    
    public void setCoord() {
        System.out.println("Digite o nome do coordenador do projeto: ");
        this.coordenador = in.next();
    }

    public void setProfissional(int qnt) {
        for(int i = 0; i < qntP; i++) {
            System.out.println("Digite o id do profissional: ");
            int id_user = in.nextInt();
            for(int j = 0; j < this.users.size(); j++) {
                if(id_user == this.users.get(j).getID()) {
                    users_projeto.add(this.users.get(j));
                    break;
                }
                else if(j == this.users.size()-1) {
                    System.out.println("Esse usuario não existe!");
                    break;
                }
            }    
        }
    }
    public void editProfissional() {
        int opt_edit_profiss = in.nextInt();
        if(opt_edit_profiss == 1) {setProfissional(1);}
        else if(opt_edit_profiss == 2) {
            removeProfissional();
        }
        else if(opt_edit_profiss == 3) {

        }
    }
    public void removeProfissional() {
        System.out.println("Digite o ID do usuario que deseja remover: ");
        int id_profissional_remover = in.nextInt();
        for(int i = 0; i < users_projeto.size(); i++) {
            if(id_profissional_remover == users_projeto.get(i).getID()) {
                users_projeto.remove(i);
                break;
            }
            else if(i == users_projeto.size()-1) {
                System.out.println("Esse usuario não existe!");
                break;
            }
        }
    }


    public void setAtividades() {
        System.out.println("Digite a idetenficacao da atividade: ");
        String id_at = in.next();
        
        if (atividades.size() == 0) {
            System.out.println("Quantos profissionais vão participar do projeto? ");
            qntP = in.nextInt(); // salva a quantidade de profissionais

            String[] tarefas = { "g" };
            Atividade newAtividade = new Atividade(id_at, "a", "b", "2", "data_t", "hora_t", "responsavel",
                    "at_profissionais", tarefas, users_projeto);
            newAtividade.setDesc();
            newAtividade.setDataI();
            newAtividade.setHoraI();
            newAtividade.setDataT();
            newAtividade.setHoraT();
            newAtividade.setResponsavel();

            System.out.println("Quantos profissionais vão participar da atividade? ");
            qntP = in.nextInt(); // salva a quantidade de profissionais
            for (int j = 0; j < qntP; j++) {
                newAtividade.setProfissional();
            }
            atividades.add(newAtividade);
        } else {
            for(int i = 0; i < atividades.size(); i++) {
                if(id_at == atividades.get(i).getId()) {
                    System.out.println("Essa identificacao já existe para outro projeto\nTente novamente: ");
                    id_at = in.next();
                    i = 0;
                }
                else if(atividades.size()-1 == i) {
                    System.out.println("Quantos profissionais vão participar do projeto? ");
                    qntP = in.nextInt(); // salva a quantidade de profissionais
    
                    String[] tarefas = {"g"};
                    Atividade newAtividade = new Atividade(id_at, "a", "b", "2", "data_t", "hora_t", "responsavel", "at_profissionais", tarefas, users_projeto);
                    newAtividade.setDesc();
                    newAtividade.setDataI();
                    newAtividade.setHoraI();
                    newAtividade.setDataT();
                    newAtividade.setHoraT();
                    newAtividade.setResponsavel();
    
                    System.out.println("Quantos profissionais vão participar da atividade? ");
                    qntP = in.nextInt(); // salva a quantidade de profissionais
                    for (int j = 0; j < qntP; j++) {
                        newAtividade.setProfissional();
                    }
                    atividades.add(newAtividade);
                }
            }
        }
    }
    public void editAtividades() {
        System.out.println("Digite 1 para adicionar uma nova atividade, 2 para excluir uma atividade e 3 para editar uma atividade: ");
        int editA = in.nextInt();
        if(editA == 1) {
            setAtividades(); 
        }
        else if(editA == 2) {
            System.out.println("Qual a identifcacao da atividade que deseja remover: ");
            String id_removeA = in.next();
            for(int j = 0; j < atividades.size(); j++) {
                if(atividades.get(j).getId().equals(id_removeA)) {
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
                    System.out.println("1 para descrição\n2 para data de inicio\n3 para hora de inicio\n4 para data de termino\n5 para hora de termino\6 para responsavel\n7 para profissional\n");
                    System.out.println("O que deseja editar? ");
                    int decide = in.nextInt();
                    if(decide == 1) {
                        atividades.get(j).setDesc();
                        break;
                    }
                    else if(decide == 2) {
                        atividades.get(j).setDataI();
                        break;
                    }
                    else if(decide == 3) {
                        atividades.get(j).setHoraI();
                        break;
                    }
                    else if(decide == 4) {
                        atividades.get(j).setDataT();
                        break;
                    }
                    else if(decide == 5) {
                        atividades.get(j).setHoraT();
                        break;
                    }
                    else if(decide == 6) {
                        atividades.get(j).setResponsavel();
                        break;
                    }
                    else if(decide == 7) {
                        atividades.get(j).setProfissional();
                        break;
                    }
                }
                else if(j == atividades.size()-1) {
                    System.out.println("Identificação não encontrada");
                    break;
                }
            }
        }
    }




    public void associarUser() {
        System.out.println("Digite o ID do usuario que deseja associar: ");
        int id_user_associar = in.nextInt();
        for(int i = 0; i < users.size(); i++) {
            if(id_user_associar == users.get(i).getID()) {
                users_intercambio.add(users.get(i));
            }
        }
    }

    public void intercambiar() {
        System.out.println("Digite o ID do usuário que deseja intercambiar");
        int id_user_inter = in.nextInt();
        for(int i = 0; i < this.users.size(); i++) {
            if(id_user_inter == this.users.get(i).getID()) {
                for(int j = 0; j < users_projeto.size(); j++) {
                    if(id_user_inter == users_projeto.get(j).getID()) {
                        System.out.println("Esse usuario já faz parte do projeto");
                        break;
                    }
                    else if(j == users_projeto.size()-1) {
                        users_intercambio.add(this.users.get(i));
                        users_projeto.add(this.users.get(i));
                    }
                }
            }
            else if(i == users.size()-1) {
                System.out.println("Usuario não encontrado");
            }
        }
    }

    public void statusProjeto() {   
        System.out.println("0 - EM CRIACAO\n1 - EM ANDAMENTO\n2 - CONCLUIDO");
        System.out.println("Digite o novo status do Projeto: ");
        this.stt = in.nextInt();

        if(this.stt == 0) System.out.println("Em criação!");
        else if(this.stt == 1) System.out.println("Em andamento!");
        else if(this.stt == 2) System.out.println("Concluido!");
    }


    public void consultarAtividade() {
        System.out.println("Digite o ID da atividade a ser consultada: ");
        String id_atividade = in.next();

        for(int i = 0; i < atividades.size(); i++) {
            if(atividades.get(i).getId().equals(id_atividade)) {
                System.out.println(atividades.get(i).printAtividadeInfo());
                break;
            }
            else if(atividades.size()-1 == i) {
                System.out.println("Atividade não encontrada.");
                break;
            }
        }
    }
    public void printAtividadesInfo() {
        for(int i = 0; i < atividades.size(); i++) {
            System.out.println(atividades.get(i).printAtividadeInfo());
        }
    }

    public String printProjetoInfo() {
        return "Identificação: " + this.identificacao + "Descrição: " + this.descricao + "Data de inicio: "
        + this.data_i + "Hora de inicio: " + this.hora_i + "Data de término: " + this.data_t
        + "Hora de Término: " + this.hora_t + "Coordenador: " + this.coordenador + "Profissionais: ";
    }
}

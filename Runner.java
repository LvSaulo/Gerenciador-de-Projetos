import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    ArrayList<Users> users = new ArrayList<Users>();
    ArrayList<Projetos> projetos = new ArrayList<Projetos>();
    ArrayList<Atividades> atividades = new ArrayList<Atividades>();
    int count_users = 0;

    Users loginUser;

    public Runner() {
        this.run();
    }

    public void run() {
        openLogin();
    }

    public void openLogin() {
        System.out.println("\nBem vindo ao Gerenciador de Projetos!\n");
        
        Scanner in = new Scanner(System.in);

        int opc = 9;
        while(opc != 0) {
            System.out.println("Digite (1) para logar como usuario\n");
            System.out.println("Digite (2) para criar um usuario\n");
            System.out.println("Digite (3) se esqueceu a senha do usuario\n");
            System.out.println("Digite (0) para sair do programa");
            System.out.println("Digite sua escolha: ");
            opc = in.nextInt();

            if(opc == 1) {
                System.out.println("Digite o id do usuario: ");
                int login = in.nextInt();

                for(int i = 0; i < users.size(); i++) {


                    if(users.get(i).getID() == login) {
                        System.out.printf("Digite a senha do usuario \"%d\": ", login);
                        String password = in.next();

                        if(users.get(i).getSenha().equals(password)) {
                            System.out.printf("LOGADO! Olá %s\n", users.get(i).getName());
                            loginUser = users.get(i);
                            menu();
                        }
                    }
                    else if(i == users.size()-1) {
                        System.out.println("Usuário não encontrado!\n");        
                    }

                }

            }
            else if(opc == 2) {
                System.out.println("Digite seu id: ");
                int id = in.nextInt();

                if(users.size() == 0) {
                    Users newUser = new Users(id, "nome", "senha");
                    newUser.addUsers(); 
                    users.add(newUser);
                    count_users++;
                    break;
                }
                else {
                    for(int i = 0; i < users.size(); i++) {
                        if(id == users.get(i).getID()) {
                            System.out.println("Esse ID já existe\nTente digitar outro ID: ");
                            id = in.nextInt();
                            i = 0;
                            break;
                        }
                        else if(i == users.size()-1) {
                            Users newUser = new Users(id, "nome", "senha");
                            newUser.addUsers(); 
                            users.add(newUser);
                            count_users++;
                            break;
                        }
                    }    
                }
            }
            else if(opc == 3) {
                System.out.println("Digite seu id: ");
                int check_id = in.nextInt();
                
                for(int i = 0; i < users.size(); i++) {
                    if(check_id == users.get(i).getID()) {
                        users.get(i).setPassword();
                        break;
                    }
                    else if(i == users.size()-1) {
                        System.out.println("Usuario não encontrado");
                        break;
                    }
                }  
            }
            else if(opc == 0) {
                return;
            }
        }
    }

    public void menu() {
        System.out.println("Digite 1 para criar um projeto.");
        System.out.println("Digite 2 para remover um projeto.");
        System.out.println("Digite 3 para exibir relatório dos projetos.");
        System.out.println("Digite 4 para intercambiar um usuário para um projeto.");
        System.out.println("Digite 5 para alterar o valor ou o tempo da bolsa de um usuário.");
        System.out.println("Digite 6 para editar um projeto a partir de um ID.");
        System.out.println("Digite 7 para associar um usuario a algum projeto.");
        System.out.println("Digite 8 para alterar o status de um projeto.");
        System.out.println("Digite 9 para consultar por usuário.");
        System.out.println("Digite 10 para consultar por ID de projeto.");
        System.out.println("Digite 11 para consultar por atividade.");
        System.out.println("Digite 12 para undo.");
        System.out.println("Digite 13 para redo.");
        System.out.println("Digite 0 para sair do programa.");

        mannager();
    }

    public void mannager() {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite sua opção: ");
        int decide = in.nextInt();

        if(decide  == 1) {
            System.out.println("Digite a identificacao do seu novo projeto: ");
            String id = in.next();

            for(int i = 0; i < projetos.size(); i++) {
                if(id == projetos.get(i).getId()) {
                    System.out.println("Esse Identificacao pertence a outro projeto!\nTente digitar outra: ");
                    id = in.next();
                    i = 0;
                    break;
                }
                else if(i == projetos.size()) {
                    Projetos newProjeto = new Projetos(id, "desc", "1", "3", "41", "32", "coord", users);
                    newProjeto.addProjetos();
                    projetos.add(newProjeto);
                    break;
                }
            }
            
        }
        else if(decide == 2) {
            System.out.println("Digite a identificacao do projeto que deseja remover: ");
            String id = in.next();

            for(int i = 0; i < projetos.size(); i++) {
                if(projetos.get(i).getId().equals(id)) {
                    projetos.remove(i);
                    break;
                }
                else if(i == projetos.size()-1) {
                    System.out.println("Não existe projeto com essa identificação!\\nTente novamente: ");
                    id = in.next();
                    i = 0;
                }
            }
        }
        else if(decide == 3) {
            System.out.println("\nRELATORIO DE PROJETOS!\n\n");
            for (int i = 0; i < projetos.size(); i++) {
                System.out.println(projetos.get(i).printProjetosInfo());
            }
            for(int i = 0; i < atividades.size(); i++) {
                System.out.println(atividades.get(i).printAtividadesInfo());
            }
        }
        else if(decide == 4) {
            System.out.println("Digite o ID do projeto que deseja associar: ");
            String id_projeto_intercambiar = in.next();
            for(int i = 0; i < projetos.size(); i++) {
                if(id_projeto_intercambiar.equals(projetos.get(i).getId())) {
                    projetos.get(i).intercambiar();
                    break;
                }
                else if(i == projetos.size()-1) {
                    System.out.println("Projeto não encontrado!");
                    break;
                }
            }

        }
        else if(decide == 5) {
            System.out.println("Digite o ID do usuario que deseja atribuir o valor da bolsa: ");
            int id_user_bolsa = in.nextInt();

            for(int i = 0; i < users.size(); i++) {
                if(id_user_bolsa == users.get(i).getID()) {
                    System.out.println("Digite (1) para alterar o valor e (2) para alterar o tempo: ");
                    int opt = in.nextInt();
                    if(opt == 1) {
                        users.get(i).setValorBolsa();
                        break;
                    }
                    else if(opt == 2) {
                        users.get(i).setTempoBolsa();
                        break;
                    }
                    
                } else if(i == users.size()-1) {
                    System.out.println("Usuario não encontrado!");
                    break;
                }
            }
        }
        else if (decide == 6) {
            System.out.println("Digite o ID do projeto que deseja editar: ");
            String id_edit_projeto = in.next();

            String edit;

            for (int j = 0; j < projetos.size(); j++) {
                if (projetos.get(j).getId().equalsIgnoreCase(id_edit_projeto)) {
                    boolean i = true;
                    while (i) {
                        i = false;

                        System.out.println("O que deseja editar: ");
                        edit = in.next();
                        if (edit.equalsIgnoreCase("identificacao")) {
                           // System.out.println("Digite a nova identificacao do projeto: ");
                            projetos.get(j).ident();

                        } else if (edit.equalsIgnoreCase("descricao")) {
                            System.out.println("Digite a nova descricao do projeto: ");
                            projetos.get(j).desc();
                        } 
                        else if (edit.equalsIgnoreCase("data de inicio")) {
                            System.out.println("Digite a nova data de inicio do projeto: ");
                            projetos.get(j).dataI();
                        } 
                        else if (edit.equalsIgnoreCase("hora de inicio")) {
                            System.out.println("Digite a nova hora de inicio do projeto: ");
                            projetos.get(j).horaI();
                        } 
                        else if (edit.equalsIgnoreCase("data de termino")) {
                            System.out.println("Digite a nova data de termino do projeto: ");
                            projetos.get(j).dataT();
                        } 
                        else if (edit.equalsIgnoreCase("hora de termino")) {
                            System.out.println("Digite a nova hora de termino do projeto: ");
                            projetos.get(j).horaT();
                        } 
                        else if (edit.equalsIgnoreCase("coordenador")) {
                            System.out.println("Digite o novo coordenador do projeto: ");
                            projetos.get(j).coord();
                        } 
                        else if (edit.equalsIgnoreCase("profissionais")) {
                            System.out.println(
                                    "Digite 1 para adicionar um novo profissional, 2 para excluir um profissional e 3 para editar um profissional: ");
                                    projetos.get(j).editProfissional();
                            
                        } else {
                            System.out.println("\nDigite uma opção válida!\n");
                            // i = true;
                        }
                    }
                }
            }
        }
        else if(decide == 7) {
            System.out.println("Digite o id do projeto que deseja associar: ");
            String projeto_asso = in.next();

            for(int i = 0; i < projetos.size(); i++) {
                if(projetos.get(i).getId().equals(projeto_asso)) {
                    projetos.get(i).associarUser();
                    break;
                }
                else if(i == projetos.size()-1) {
                    System.out.println("Projeto não encontrado!");
                    break;
                }
            }
            
        }
        else if(decide == 8) {

            if(loginUser.getStatusUser() == StatusUser.PROFESSOR || loginUser.getStatusUser() == StatusUser.PESQUISADOR) {
                System.out.println("Digite o ID do projeto para alterar o status: ");
                String idProjeto = in.next();
            
                for(int i = 0; i < projetos.size(); i++) {
                    if(idProjeto == projetos.get(i).getId()) {
                        projetos.get(i).statusProjeto();
                    }
                }
            } else System.out.println("Você não tem permissão para alterar o Status do projeto!\n");
            
        }
        else if(decide == 9) {
            System.out.println("Digite o ID do Usuario a ser consultado: ");
            int consultar_user = in.nextInt();

            for(int i = 0; i < users.size(); i++) {
                if(users.get(i).getID() == consultar_user) {
                    System.out.println(users.get(i).printUsersInfo());
                    break;
                }
                else if(users.size()-1 == i) {
                    System.out.println("Usuario não encotrado! ID errado!");
                }
            }
        }
        else if(decide == 10) {
            System.out.println("Digite o ID do projeto a ser consultado: ");
            String consultar_projeto = in.next();

            for(int i = 0; i < projetos.size(); i++) {
                if(projetos.get(i).getId().equalsIgnoreCase(consultar_projeto)) {
                    System.out.println(projetos.get(i).printProjetosInfo());
                    break;
                }
                else if(projetos.size()-1 == i) {
                    System.out.println("Projeto não encotrado! ID errado!");
                }
            }
        }
        else if(decide == 11) {
            System.out.println("Digite o ID da atividade a ser consultada: ");
            String consultar_atividade = in.next();

            for(int i = 0; i < atividades.size(); i++) {
                if(atividades.get(i).getId().equalsIgnoreCase(consultar_atividade)) {
                    System.out.println(atividades.get(i).printAtividadesInfo());
                    break;
                }
                else if(projetos.size()-1 == i) {
                    System.out.println("Atividade não encotrada! ID errado!");
                }
            }
        }
        else if(decide == 12) {
            
        }
        else if(decide == 13) {
            
            
        }
        else if(decide == 0) {
            return;
        }    
    }

    public Users getUsers(int count_users) {
      return users.get(count_users);  
    }
}

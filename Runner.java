package GerenciadorDeProjetos.ProjetoOO;

import java.util.Scanner;
import java.util.ArrayList;

public class Runner {
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    ArrayList<Coordenador> coordenadores = new ArrayList<Coordenador>();
    ArrayList<Projeto> projetos = new ArrayList<Projeto>();
    ArrayList<Atividade> atividades = new ArrayList<Atividade>();

    int count_users = 0;
    private int cargo;
    public StatusUser status;
    public User loginUser;

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
        while (opc != 0) {
            System.out.println("Digite (1) para logar como usuario\n");
            System.out.println("Digite (2) para criar um usuario\n");
            System.out.println("Digite (3) se esqueceu a senha do usuario\n");
            System.out.println("Digite (0) para sair do programa");

            opc = GetInputs.getIntInput("Digite sua escolha: ", "Erro! Apenas números são permitidos");
            if (opc < 0) {
                return;
            }

            switch (opc) {
                case 1:
                    System.out.println("A entrada deve ter apenas números\n");
                    int login = GetInputs.getIntInput("Digite o id do usuário: ", "O ID deve conter apenas números");
                    if (login < 0) {
                        return;
                    }
                    // if(GetInputs.getNullPointer(null, null))
                    for (int i = 0; i < users.size(); i++) {
                        if (users.get(i).getID() == login) {
                            System.out.printf("Digite a senha do usuario \"%d\": ", login);
                            String password = in.next();

                            if (users.get(i).getPassword().equals(password)) {
                                System.out.printf("LOGADO! Olá %s\n", users.get(i).getName());
                                loginUser = users.get(i);
                                menu();
                            }
                        } else if (i == users.size() - 1) {
                            System.out.println("Usuário não encontrado!\n");
                        }
                    }
                    break;
                case 2:
                    System.out.println(
                            "Tipos de usuarios:\n1 - Aluno\n2 - Professor\n3 - Pesquisador\n4 - Profissional\n5 - Tecnico.\n");
                    System.out.println("Qual seu tipo de cargo? ");
                    System.out.println("A entrada deve ter apenas números\n");
                    int cargo = GetInputs.getIntInput("Digite o id do usuário: ", "O ID deve conter apenas números");
                    if (cargo < 0) {
                        return;
                    }

                    System.out.println("A entrada deve ter apenas números\n");
                    int id = GetInputs.getIntInput("Digite o id do usuário: ", "O ID deve conter apenas números");
                    if (id < 0) {
                        return;
                    }

                    if (users.size() == 0) {

                        if (cargo == 1 || cargo == 4 || cargo == 5) {
                            status = StatusUser.ALUNO;
                            Aluno newUser = new Aluno(id, null, "nome", "senha", status, 0, 0.0);
                            newUser.setEmail();
                            newUser.setPassword();
                            newUser.setName();
                            newUser.setTempoBolsa();
                            newUser.setValorBolsa();

                            alunos.add(newUser);
                            users.add(newUser);
                        } else if (cargo == 2 || cargo == 3) {
                            Coordenador newUser;
                            if (cargo == 2) {
                                status = StatusUser.PROFESSOR;
                                newUser = new Professor(id, null, null, null, status);
                                newUser.setEmail();
                                newUser.setPassword();
                                newUser.setName();
                            } else {
                                status = StatusUser.PESQUISADOR;
                                newUser = new Professor(id, null, null, null, status);
                                newUser.setEmail();
                                newUser.setPassword();
                                newUser.setName();
                            }
                            coordenadores.add(newUser);
                            users.add(newUser);
                        }
                        count_users++;
                        break;
                    } else {
                        for (int i = 0; i < users.size(); i++) {
                            if (id == users.get(i).getID()) {
                                System.out.println("A entrada deve ter apenas números\n");
                                id = GetInputs.getIntInput("Digite o id do usuário: ",
                                        "O ID deve conter apenas números");
                                if (id < 0) {
                                    return;
                                }
                                i = 0;
                                break;
                            } else if (i == users.size() - 1) {
                                if (cargo == 1 || cargo == 4 || cargo == 5) {
                                    status = StatusUser.ALUNO;
                                    Aluno newUser = new Aluno(id, null, "nome", "senha", status, 0, 0.0);
                                    newUser.setEmail();
                                    newUser.setPassword();
                                    newUser.setName();
                                    newUser.setTempoBolsa();
                                    newUser.setValorBolsa();

                                    alunos.add(newUser);
                                    users.add(newUser);
                                } else if (cargo == 2 || cargo == 3) {
                                    Coordenador newUser;
                                    if (cargo == 2) {
                                        status = StatusUser.PROFESSOR;
                                        newUser = new Professor(id, null, null, null, status);
                                        newUser.setEmail();
                                        newUser.setPassword();
                                        newUser.setName();
                                    } else {
                                        status = StatusUser.PESQUISADOR;
                                        newUser = new Professor(id, null, null, null, status);
                                        newUser.setEmail();
                                        newUser.setPassword();
                                        newUser.setName();
                                    }
                                    coordenadores.add(newUser);
                                    users.add(newUser);
                                }
                                count_users++;
                                break;
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("A entrada deve ter apenas números\n");
                    int check_id = GetInputs.getIntInput("Digite o id do usuário: ", "O ID deve conter apenas números");
                    if (check_id < 0) {
                        return;
                    }

                    for (int i = 0; i < users.size(); i++) {
                        if (check_id == users.get(i).getID()) {
                            String check_email = GetInputs.getStringInput("Digite seu email: ",
                                    "Email digitado de maneira não permitida");
                            if (check_email == null) {
                                return;
                            } else if (users.get(i).getEmail().equals(check_email)) {
                                users.get(i).setPassword();
                            } else {
                                System.out.println("Email errado!");
                            }

                            break;
                        } else if (i == users.size() - 1) {
                            System.out.println("Usuario não encontrado");
                            break;
                        }
                    }
                    break;

                case 0:
                    return;
                default:
                    break;
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
        System.out.println("Digite 12 para acessar atividades.");
        System.out.println("Digite 13 para undo.");
        System.out.println("Digite 14 para redo.");
        System.out.println("Digite 0 para sair do programa.");

        mannager();
    }

    public void mannager() {
        Scanner in = new Scanner(System.in);
        System.out.println("Apenas números são aceitos como entrada\n");
        int decide = GetInputs.getIntInput("Digite sua opção: ", "A sua opção deve ser um numero!");

        if (decide < 0) {
            return;
        }
        switch (decide) {
            case 1:
                if (loginUser.getStatusUser() == StatusUser.PROFESSOR
                        || loginUser.getStatusUser() == StatusUser.PESQUISADOR) {

                    int id = GetInputs.getIntInput("Digite a identificacao do seu novo projeto: ",
                            "O ID deve conter apenas números");
                    if (id < 0) {
                        return;
                    }

                    if (projetos.size() == 0) {
                        Projeto newProjeto = new Projeto(id, "desc", "1", "3", "41", "32", "coord", users);
                        newProjeto.setDesc();
                        newProjeto.setDataI();
                        newProjeto.setHoraI();
                        newProjeto.setDataT();
                        newProjeto.setHoraT();
                        newProjeto.setCoord();
                        newProjeto.setAtividades();

                        projetos.add(newProjeto);
                    } else {
                        for (int i = 0; i < projetos.size(); i++) {
                            if (id == projetos.get(i).getId()) {
                                System.out.println("Esse Identificacao pertence a outro projeto!\n");
                                id = GetInputs.getIntInput("Digite a identificacao do seu novo projeto: ",
                                        "O ID deve conter apenas números");
                                if (id < 0) {
                                    return;
                                }
                                i = 0;
                            } else if (i == projetos.size() - 1) {
                                Projeto newProjeto = new Projeto(id, "desc", "1", "3", "41", "32", "coord", users);
                                newProjeto.setDesc();
                                newProjeto.setDataI();
                                newProjeto.setHoraI();
                                newProjeto.setDataT();
                                newProjeto.setHoraT();
                                newProjeto.setCoord();
                                newProjeto.setAtividades();

                                projetos.add(newProjeto);
                                break;
                            }
                        }
                    }
                } else {
                    System.out.println("Você não tem permissão para criar um projeto.");
                }
                break;
            case 2:
                if (loginUser.getStatusUser() == StatusUser.PROFESSOR
                        || loginUser.getStatusUser() == StatusUser.PESQUISADOR) {
                    int id = GetInputs.getIntInput("Digite a identificacao do projeto que deseja remover: ",
                            "O ID deve conter apenas números");
                    if (id < 0) {
                        return;
                    }

                    for (int i = 0; i < projetos.size(); i++) {
                        if (projetos.get(i).getId() == id) {
                            projetos.remove(i);
                            break;
                        } else if (i == projetos.size() - 1) {
                            System.out.println("Não existe projeto com essa identificação!\nTente novamente!");
                            id = GetInputs.getIntInput("Digite a identificacao do projeto que deseja remover: ",
                                    "O ID deve conter apenas números");
                            if (id < 0) {
                                return;
                            }
                            i = 0;
                        }
                    }
                } else {
                    System.out.println("Você não tem permissão para remover um projeto.");
                }
                break;
            case 3:
                System.out.println("\nRELATORIO DE PROJETOS!\n\n");

                for (int i = 0; i < projetos.size(); i++) {
                    System.out.println(projetos.get(i));
                    projetos.get(i).printAtividadesInfo();
                }
                break;
            case 4:
                int id_projeto_intercambiar = GetInputs.getIntInput(
                        "Digite o ID do projeto para qual o aluno deve ser intercambiado: ",
                        "O ID deve conter apenas números");
                if (id_projeto_intercambiar < 0) {
                    return;
                }

                for (int i = 0; i < projetos.size(); i++) {
                    if (id_projeto_intercambiar == projetos.get(i).getId()) {
                        projetos.get(i).intercambiar();
                        break;
                    } else if (i == projetos.size() - 1) {
                        System.out.println("Projeto não encontrado!");
                        break;
                    }
                }

                break;
            case 5:
                int id_user_bolsa = GetInputs.getIntInput("Digite o ID do usuario que deseja modificar a bolsa: ",
                        "O ID deve conter apenas números");
                if (id_user_bolsa < 0) {
                    return;
                }

                for (int i = 0; i < users.size(); i++) {
                    if (id_user_bolsa == users.get(i).getID()) {
                        if (users.get(i) instanceof Aluno) {
                            int opt = GetInputs.getIntInput(
                                    "Digite (1) para alterar o valor ou (2) para alterar o tempo: ",
                                    "O ID deve conter apenas números");
                            if (opt < 0) {
                                return;
                            } else if (opt == 1) {
                                alunos.get(i).setValorBolsa();
                                break;
                            } else if (opt == 2) {
                                alunos.get(i).setTempoBolsa();
                                break;
                            }
                        } else {
                            System.out.println("Esse usuário não possui bolsa.");
                        }
                    } else if (i == users.size() - 1) {
                        System.out.println("Usuario não encontrado!");
                        break;
                    }
                }
                break;
            case 6:
                if (loginUser instanceof Coordenador) {
                    int id_edit_projeto = GetInputs.getIntInput("Digite o ID do projeto que deseja editar: ",
                            "O ID deve conter apenas números");
                    if (id_edit_projeto < 0) {
                        return;
                    }

                    int edit;

                    for (int j = 0; j < projetos.size(); j++) {
                        if (projetos.get(j).getId() == (id_edit_projeto)) {
                            boolean i = true;
                            while (i) {
                                i = false;
                                System.out.println(
                                        "1 - IDENTIFICAÇÃO\n2 - DESCRIÇÃO\n3 - DATA DE INICIO\n4 - HORA DE INICIO\n5 - DATA DE TERMINO\n6 - HORA DE TERMINO\n7 - COORDENADOR\n8 - PROFISSIONAIS");
                                edit = GetInputs.getIntInput("O que deseja editar: ", "Você deve digitar um número para escolher sua opção");
                                if(edit < 0) return;

                                switch (edit) {
                                    case 1:
                                        System.out.println("Digite a nova identificacao do projeto: ");
                                        projetos.get(j).setId();
                                        break;
                                    case 2:
                                        System.out.println("Digite a nova descricao do projeto: ");
                                        projetos.get(j).setDesc();
                                        break;
                                    case 3:
                                        System.out.println("Digite a nova data de inicio do projeto: ");
                                        projetos.get(j).setDataI();
                                        break;
                                    case 4:
                                        System.out.println("Digite a nova hora de inicio do projeto: ");
                                        projetos.get(j).setHoraI();
                                        break;
                                    case 5:
                                        System.out.println("Digite a nova data de termino do projeto: ");
                                        projetos.get(j).setDataT();
                                        break;
                                    case 6:
                                        System.out.println("Digite a nova hora de termino do projeto: ");
                                        projetos.get(j).setHoraT();
                                        break;
                                    case 7:
                                        System.out.println("Digite o novo coordenador do projeto: ");
                                        projetos.get(j).setCoord();
                                        break;
                                    case 8:
                                        System.out.println("Digite 1 para adicionar um novo profissional, 2 para excluir um profissional e 3 para editar um profissional: ");
                                        projetos.get(j).editProfissional();
                                        break;
                                    
                                    default:
                                        System.out.println("\nDigite uma opção válida!\n");
                                        i = true;
                                        break;
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("Você não tem permissão para editar um projeto.");
                }
                break;
            case 7:
                int projeto_asso = GetInputs.getIntInput("Digite o id do projeto que deseja associar: ", "ERROR! o ID do projeto deve conter apenas números");
                if(projeto_asso < 0) return;

                for (int i = 0; i < projetos.size(); i++) {
                    if (projetos.get(i).getId() == (projeto_asso)) {
                        projetos.get(i).associarUser();
                        break;
                    } else if (i == projetos.size() - 1) {
                        System.out.println("Projeto não encontrado!");
                        break;
                    }
                }
                break;
            case 8:
                if (loginUser instanceof Coordenador) {
                    System.out.println("Digite o ID do projeto para alterar o status: ");
                    int idProjeto = in.nextInt();

                    for (int i = 0; i < projetos.size(); i++) {
                        if (idProjeto == projetos.get(i).getId()) {
                            projetos.get(i).statusProjeto();
                            break;
                        } else if (projetos.size() - 1 == i) {
                            System.out.println("Projeto não encontrado.");
                        }
                    }
                } else
                    System.out.println("Você não tem permissão para alterar o Status do projeto!\n");
                break;
            case 9:
                int consultar_user = GetInputs.getIntInput("Digite o ID do Usuario a ser consultado: ", "ERROR! o ID do projeto deve conter apenas números");
                if(consultar_user < 0) return;

                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getID() == consultar_user) {
                        System.out.println(users.get(i));
                        break;
                    } else if (users.size() - 1 == i) {
                        System.out.println("Usuario não encotrado! ID errado!");
                    }
                }
                break;
            case 10:
                System.out.println();
                int consultar_projeto = GetInputs.getIntInput("Digite o ID do projeto a ser consultado: ", "ERROR! o ID do projeto deve conter apenas números");
                if(consultar_projeto < 0) return;

                for (int i = 0; i < projetos.size(); i++) {
                    if (projetos.get(i).getId() == consultar_projeto) {
                        System.out.println(projetos.get(i));
                        break;
                    } else if (projetos.size() - 1 == i) {
                        System.out.println("Projeto não encotrado! ID errado!");
                    }
                }
                break;
            case 11:
                System.out.println();
                int id_projeto = GetInputs.getIntInput("Digite o ID do projeto que contem a atividade a ser consultada: ", "ERROR! o ID do projeto deve conter apenas números");
                if(id_projeto < 0) return;

                for (int i = 0; i < projetos.size(); i++) {
                    if (projetos.get(i).getId() == id_projeto) {
                        projetos.get(i).consultarAtividade();
                        break;
                    } else if (projetos.size() - 1 == i) {
                        System.out.println("Projeto não encotrado! ID errado!");
                    }
                }
                break;
            case 12:
                id_projeto = GetInputs.getIntInput("Digite o ID do projeto que contém atividades que deseja acessar: ", "ERROR! o ID do projeto deve conter apenas números");
                if(id_projeto < 0) return;

                for (int i = 0; i < projetos.size(); i++) {
                    if (projetos.get(i).getId() == id_projeto) {
                        projetos.get(i).editAtividades();
                        break;
                    } else if (projetos.size() - 1 == i) {
                        System.out.println("Projeto não encontrado.");
                        break;
                    }
                }
                break;
            case 13:
                break;
            case 14:
                break;
            case 0:
                return;
            default:
                System.out.println("Essa opção não existe!");
                break;
        }
    }
}
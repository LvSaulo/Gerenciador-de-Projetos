import java.util.Scanner;
import java.util.ArrayList;
              

public class GerenciarProjetos {
    public static void main(String[] args) {
        ArrayList<Users> users = new ArrayList<Users>();


        Scanner input = new Scanner(System.in);
        System.out.println("Bem vindo ao Gerenciador de Projetos!\n");

        System.out.println("Digite (1) para entrar com id e senha ou (2) para criar usuário: ");
        int decisao_user = input.nextInt();
        if(decisao_user == 1) {
            
        }
        else if(decisao_user == 2) {
            Users newUser = new Users(0, "nome", "ocupacao", "senha");
            newUser.addUsers();
            users.add(newUser);
            System.out.println(users);
        }

        Users newUser = new Users(0, "nome", "ocupacao", "senha");

        System.out.println("O que deseja fazer?\n");
        System.out.println("Digite (1) para adicionar usuários\nDigite (2) para adicionar ou remover um Projeto");

        
    }
}

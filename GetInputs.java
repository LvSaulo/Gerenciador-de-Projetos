package GerenciadorDeProjetos.ProjetoOO;
import java.util.Scanner;

abstract public class GetInputs {
    public static int getIntInput(String label, String errorMessage) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println(label);

            return in.nextInt();
        } catch (NumberFormatException e) {
            System.err.println(errorMessage);
        }
        return -1;
    }
    public static int getNullPointer(String label, String errorMessage) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println(label);

            return in.nextInt();
        } catch (NullPointerException e) {
            System.err.println(errorMessage);
        }
        return -1;
    }
    public static String getStringInput(String label, String errorMessage) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println(label);

            return in.next();
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println(errorMessage);
        }
        return null;
    }

}

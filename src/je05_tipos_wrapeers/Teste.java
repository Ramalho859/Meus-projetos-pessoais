package je05_tipos_wrapeers;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("qual o nome do aluno?:");
        String nome = scanner.nextLine();
       // System.out.println(nome); vou usar no final

        System.out.println("Digite a sua nota 1:");
        int n1 = scanner.nextInt();

        System.out.println("Digite a sua nota 2:");
        int n2 = scanner.nextInt();

        System.out.println("Digite a sua nota 3:");
        int n3 = scanner.nextInt();

        int i = n1 + n2 + n3;
        int f = i/3;

        if(f>=7) System.out.println("esse alunno passou com a media " + f +" nome do aluno  "+nome);
        else if (f<6) {
            System.out.println("Esse aluno nao passou de ano com essa media "+f);
            System.out.println("nome do aluno  "+nome);
        } else if (f==0) {
            System.out.println("Voce e uma mula "+f);
            System.out.println("nome do aluno  "+nome);
        }

    }
}

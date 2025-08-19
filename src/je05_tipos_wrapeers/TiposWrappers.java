package je05_tipos_wrapeers;
import java.util.Scanner;
public class TiposWrappers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha pendente

        System.out.print("Digite sua cidade: ");
        String cidade = scanner.nextLine();

        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Cidade: " + cidade);

        scanner.close(); // Fechar o scanner quando não for mais usado
    }
    }


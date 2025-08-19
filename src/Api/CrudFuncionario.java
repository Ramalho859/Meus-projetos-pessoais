package Api;

import java.util.ArrayList;
import java.util.Scanner;

public class CrudFuncionario {
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int contadorId = 1;

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("""
                    1 - Cadastarr funcionarios
                    2 - Listar funcionários
                    3 - Atualizar Funcionarios
                    4 - Remover funcionarios
                    Escolha uma opção:""");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 3 -> atualizar();
                case 4 -> remover();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void cadastrar() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Salário: ");
        double salario = scanner.nextDouble();

        Funcionario f = new Funcionario(contadorId++, nome, cargo, salario);
        funcionarios.add(f);
        System.out.println("✅ Funcionário cadastrado com sucesso!");
    }

    private static void listar() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            System.out.println("\n--- Lista de Funcionários ---");
            for (Funcionario f : funcionarios) {
                System.out.println(f);
            }
        }
    }

    private static void atualizar() {
        System.out.print("Digite o ID do funcionário que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Funcionario f : funcionarios) {
            if (f.getId() == id) {
                System.out.print("Novo nome: ");
                f.setNome(scanner.nextLine());
                System.out.print("Novo cargo: ");
                f.setCargo(scanner.nextLine());
                System.out.print("Novo salário: ");
                f.setSalario(scanner.nextDouble());
                System.out.println("✅ Funcionário atualizado!");
                return;
            }
        }
        System.out.println("❌ Funcionário não encontrado!");
    }

    private static void remover() {
        System.out.print("Digite o ID do funcionário que deseja remover: ");
        int id = scanner.nextInt();

        boolean removido = funcionarios.removeIf(f -> f.getId() == id);
        if (removido) {
            System.out.println("✅ Funcionário removido com sucesso!");
        } else {
            System.out.println("❌ Funcionário não encontrado!");
        }
    }
}


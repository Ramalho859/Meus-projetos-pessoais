package je06_operadores;

import java.util.Scanner;

public class MaquinadeCartao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int saldo = 100;
        System.out.println("Site para maquininha");
        System.out.println("Escolha uma opçao");
        System.out.println("Seu saldo atual e:"+saldo);
        System.out.println("Para debito digite 1:");
        System.out.println("Para credito digite 2:");
        int opc = scanner.nextInt();

        switch (opc) {  //Execute caso tal variavel seja conrespondente com o que sera pedido no caso (sempre colocar o break)
            case 1:
                System.out.println("Comprar no debito");
                System.out.println("Digite o preço do produto");
                int preco = scanner.nextInt();
                int i = saldo-preco ;
                System.out.println("seu saldo atual e: " +i);
                break;

            case 2:
                System.out.println("Comprar no credito");
                System.out.println("Digite o preço do produto");
                int preco2 = scanner.nextInt();
                System.out.println("quer parcelar em quantas vezes");
                int parcela = scanner.nextInt();
                int i1 = saldo - preco2;
                int i2 = i1 / parcela ;
                System.out.println("vc pagara isso por mes: "+i2);
                System.out.println("seu saldo autal sera: "+i1);
                break;
        }
    }
}
// ctrl + alt + l   Arruma a identaçao
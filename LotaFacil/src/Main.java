import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");


        for (int i = 1; i <= 5; i++) {

            System.out.println("i = " + i);
        }
    }
}

class LotafacilMenu {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Random aleatorio = new Random();

        int opcao;

        do {

            System.out.println("**************************");
            System.out.println("Menu LOTOFÁCIL:");
            System.out.println("1) Apostar de 0 a 100");
            System.out.println("2) Apostar de A à Z");
            System.out.println("3) Apostar em par ou ímpar");
            System.out.println("0) Sair");
            System.out.println("**************************");


            System.out.print("Escolha uma opção: ");
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Você escolheu apostar de 0 a 100.");
                    int numeroSorteado = aleatorio.nextInt(101);
                    System.out.print("Digite um número entre 0 e 100: ");
                    int numeroEscolhido = ler.nextInt();

                    if (numeroEscolhido >= 0 && numeroEscolhido <= 100) {
                        System.out.println("Número sorteado: " + numeroSorteado);
                        if (numeroEscolhido == numeroSorteado) {
                            System.out.println("Parabéns! Você ganhou R$ 1.000,00 reais.");
                        } else {
                            System.out.println("Que pena! O número sorteado foi:" + numeroSorteado);
                        }
                    } else {
                        System.out.println("Aposta inválida.");
                    }
                    break;

                case 2:

                    System.out.println("Você escolheu apostar de A à Z.");
                    try {
                        System.out.print("Digite uma letra de A a Z: ");
                        int entrada = System.in.read();

                        char letraApostada = Character.toUpperCase((char) entrada);

                        if (Character.isLetter(letraApostada) && letraApostada >= 'A' && letraApostada <= 'Z') {
                            char letraPremiada = 'J';

                            if (letraApostada == letraPremiada) {
                                System.out.println("Você ganhou R$ 500,00 reais!");
                            } else {
                                System.out.println("Que pena! A letra sorteada foi: " + letraPremiada + ".");
                            }
                        } else {
                            System.out.println("Aposta inválida.");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();

                        break;
                    }
                case 3:
                    System.out.println("Você escolheu apostar em par ou ímpar.");

                        ler = new Scanner(System.in);

                        System.out.print("Digite um número inteiro: ");
                        int numero = ler.nextInt();

                        if (numero % 2 == 0) {
                            System.out.println("Você ganhou R$ 100,00 reais.");
                        } else {
                            System.out.println("Que pena! O número digitado é ímpar e a premiação foi para números pares.");
                        }
                        break;
                case 0:
                    System.out.println("Saindo do programa. Obrigado por jogar!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 0);

        ler.close();
    }
}
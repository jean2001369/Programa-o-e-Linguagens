import java.io.IOException;

public class ProgramacaoLi {
    public static void main(String[]args) throws IOException {
        System.out.println("Olá, mundo!");

        char ch;
        ch = 'X';
        System.out.println("ch containers" + ch);
        ch++;
        System.out.println("ch is now" + ch);
        ch = 90;
        System.out.println("ch is now" + ch);
        byte tipoByte = 127;
        short tipoShort = 32767;
        char tipoChar = 'C';
        float tipoFloat = 2.6f;
        double tipoDouble = 3.59;
        int tipoInt = 2147483647;
        long tipoLong = 9223372036854775807L;
        boolean tipoBooleano = true;
        System.out.println("valor do tipoByte" + tipoByte);
        System.out.println("valor do tipoByte" + tipoShort);
        System.out.println("valor do tipoByte" + tipoChar);
        System.out.println("valor do tipoByte" + tipoFloat);
        System.out.println("valor do tipoByte" + tipoDouble);
        System.out.println("valor do tipoByte" +tipoInt);
        System.out.println("valor do tipoByte" + tipoLong);
        System.out.println("valor do tipoByte" + tipoBooleano);

        // Demonstração de valores Booleanos.
        boolean b;
        b = false;
        // Bollean b = false

        System.out.println("b is" + b);
        // if (b == true)
        b = true;
        System.out.println("b is" + b);
        // Um valor bolleano pode controlar a instrução if
        if (b) System.out.println("This executed.");
        // o resultado da um operador relacional é um valor bolleano
        b = false;
        if (b) System.out.println("This is not executed.");
        System.out.println("18 > 9 is " + (18 > 9));
        // Demonstra o escopo de bloco
        int n; // conhecida pelo código dentro de main
        n = 10;{ // inicio novo escopo
            if (n == 10) ; // conhecida apenas nesse bloco
            // tanto m quanto n são conhecidas aqui.
            int m = 20;
            System.out.println("n and n:" + m + " " + n);
            m = n * 2;

            // n = 100; // Erro! n são conhecidos aqui
            // m ainda é conhecida aqui.
            System.out.println("m is" + m);
        }

        //Demonstra a tempo de vida uma variavel
        for (int i = 0; i < 3; i++){
            int j = -1; // y sera inicializada sempre que entrarmos no b
            System.out.println("j is:" + j); // essa linha sempre exibe
            System.out.println("j is:" + i);

        }
        int iresult, irem;
        double dresult, drem;
        iresult = 10 / 3;
        irem = 10 % 3;
        dresult = 10.0 / 3.0;
        drem = 10.0 % 3.0;
        System.out.println("\nResult and remainder of 10 / 3:" + iresult + " " + irem);
        System.out.println("\nResult and remainder of 10.0 / 3.0:" + dresult + " " + drem);
        int i, j; boolean b1, b2;
        i = 10;
        j = 11;
        if (i < j) System.out.println("\ni < j");
        if (i <= j) System.out.println("\ni <= j");
        if (i != j) System.out.println("\ni != j");
        if (i == j) System.out.println("this won't existe");
        if (i == j) System.out.println("this won't existe");
        if (i >= j) System.out.println("this won't existe");
        if (i > j) System.out.println("this won't existe");

        b1 = true;
        b2 = false;
        if(b1 & b2)
            System.out.println("this won't execute");
        if(!(b1 & b2)) System.out.println("! (b1 & b2) is true");
        if(b1 | b2) System.out.println("b1 | b2 is true");
        if(b1 ^ b2) System.out.println("b1 ^ b2 is true");

        // Pré-incremento (++x):
        int x = 5; int resultado = ++x; // Pré-incremento: incrementa x antes de usá-lo em qualquer operação
        System.out.println("resultado: " + resultado); // Output: resultado: 6

        // Pós-incremento (x++)
        x = 5;
        resultado = x++; // Pós-incremento: usa o valor atual de x e depois o incrementa
        System.out.println("\nx: " + x); // Output: x: 6 (incrementado após a atribuição)
        System.out.println("resultado: " + resultado); // Output: resultado: 5 (valor antes do incremento)
    }


}

package T01;

import java.io.IOException;
import java.util.Scanner;

public class EJ03_Principal {

  public static void main(
      String[] args) {

    Scanner scanner = new Scanner(System.in);
    EJ03_Sumador sumador = new EJ03_Sumador();

    while (true) {
      System.out.print("Introduce el primer número: ");
      int primerNum = scanner.nextInt();
      System.out.print("Introduce el segundo número: ");
      int segundoNum = scanner.nextInt();

      if (primerNum == 0 && segundoNum == 0) {
        System.out.println("FIN");
        break;
      }

      int resultadoSuma = sumador.sumar(primerNum, segundoNum);
      System.out.println("La suma es " + resultadoSuma);
    }
    scanner.close();
  }
}

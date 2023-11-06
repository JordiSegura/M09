package T02;

import java.util.Random;
import java.util.Scanner;

public class EJ02 {

  public static void main(
      String[] args) {

    int filas = 20;
    int columnas = 10;
    int[][] matriz = new int[filas][columnas];
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    for (int i = 0; i < filas; i++) {
      for (int j = 0; j < columnas; j++) {
        matriz[i][j] = random.nextInt(100);
      }
    }

    System.out.println("Matriz generada:");
    for (int i = 0; i < filas; i++) {
      for (int j = 0; j < columnas; j++) {
        System.out.print(matriz[i][j] + "\t");
      }
      System.out.println();
    }

    System.out.print("Escribe el número a buscar (0-99): ");
    int numeroBuscado = scanner.nextInt();

    for (int i = 0; i < columnas; i++) {
      final int columna = i;
      Thread thread = new Thread(() -> {
        for (int j = 0; j < filas; j++) {
          if (matriz[j][columna] == numeroBuscado) {
            long threadId = Thread.currentThread().getId();
            System.out.println("Hilo: " + threadId + " Posición: Fila[" + j + "] Columna [" + columna + "]");
            return;
          }
        }
      });
      thread.start();
    }

    scanner.close();
  }
}

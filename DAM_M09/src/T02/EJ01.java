package T02;

import java.util.Random;

// Ejercicio 1
public class EJ01 implements Runnable {
    private int[][] matriz;
    private int columna;

    public EJ01(int[][] matriz, int columna) {
        this.matriz = matriz;
        this.columna = columna;
    }

    public void run() {
        Random random = new Random();
        for (int i = 0; i < matriz.length; i++) {
            matriz[i][columna] = random.nextInt(100) + 1;
        }
    }

    public static void main(String[] args) {
        int filas = 25;
        int columnas = 10;
        int[][] matriz = new int[filas][columnas];
        Thread[] threads = new Thread[columnas];

        for (int i = 0; i < columnas; i++) {
            threads[i] = new Thread(new EJ01(matriz, i));
            threads[i].start();
        }

        for (int i = 0; i < columnas; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

package T02;

public class EJ03 {

    private static int total = 0;

    public static void main(String[] args) {
        System.out.println("Valor Inicial " + total);

        // Crear 20 hilos
        for (int i = 1; i <= 20; i++) {
            final int hiloNumero = i;
            Thread thread = new Thread(() -> {
                int numero = (int) (Math.random() * 21) - 10;

                if (numero > 0) {
                    System.out.println("hilo " + hiloNumero + ": valor " + numero + " -> total " + (total + numero));
                    total += numero;
                } else {
                    while (total + numero < 0) {
                        System.out.println("hilo " + hiloNumero + ": valor " + numero + " -> duermo");
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("hilo " + hiloNumero + ": valor " + numero + " -> total " + (total + numero));
                    total += numero;
                }
            });
            thread.start();
        }
    }
}

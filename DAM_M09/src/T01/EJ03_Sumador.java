package T01;

import java.util.Scanner;

public class EJ03_Sumador {
  
  public int sumar(int num1, int num2) {
    int resultado = 0;
    for (int i = num1; i <= num2; i++) {
        resultado += i;
    }
    return resultado;
}
}

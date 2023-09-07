
package com.mycompany.retokata2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Principal {
public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------");
        System.out.println("-BIENVENIDOS AL RETO_KATA-");
        System.out.println("--------------------------");
        System.out.println("Presiona 1 para ejecutar el desafío 1");
        System.out.println("Presiona 2 para ejecutar el desafío 2");
        System.out.println("Presiona 3 para ejecutar el desafío 3");

        int eleccion = scanner.nextInt();

        switch (eleccion) {
            case 1:
                // Crear la lista y definir el valor de S
                List<Integer> listaDesafioUno = Arrays.asList(60, 6, 5, 4, 3, 2, 7, 7, 29, 1);
                int S = 2;
                // Llamar al método desafioUno
                desafioUno(listaDesafioUno, S);
                break;
            case 2:
                S = 2;
                int[] arrayPrueba = {1, 2, 3, 5, 6, 8, 9};
                desafioDos(arrayPrueba, S);
                break;
            case 3:
                int[] monedas = {5, 7, 1, 1, 2, 3, 22};  // ejemplo de entrada
                int resultado = desafioTres(monedas);
                System.out.println("El mínimo cambio que no se puede hacer es: " + resultado);
                break;
            default:
                System.out.println("Opción inválida. Saliendo.");
                break;
        }
        scanner.close(); 
    }

    public static void desafioUno(List<Integer> lista, int S) {
        System.out.println("Dado un número S y una lista de números,eliminar los DIGITOS que son mayores o iguales a S y traer una nueva lista");
        System.out.println("Lista inicial : " + lista);
        List<Integer> nuevaLista = new ArrayList<>();

        // Paso 1: Recorrer la lista y convertir cada número a su representación de cadena de caracteres (String).
        for (int numero : lista) {
            String numeroComoCadena = Integer.toString(numero);
            System.out.println("***************** numero: " + numeroComoCadena);

            // Utilizamos un bucle for para recorrer cada dígito del número.
            for (char digitoComoChar : numeroComoCadena.toCharArray()) {
                int digito = Character.getNumericValue(digitoComoChar); // Convertir el caracter a un dígito numérico
                System.out.println("digito: " + digito);
                // Eliminamos los dígitos que son mayores o iguales a S.
                // Si el dígito es menor que S, lo añadimos a la nueva lista.
                if (digito < S) {
                    System.out.println("como " + digito + " NO es >= " + S + ", agregarlo a la lista final");
                    nuevaLista.add(digito);
                } else {
                    System.out.println("como " + digito + "  es >= " + S + ", omitirlo");
                }
            }
        }
        System.out.println("Lista final: " + nuevaLista);
        // Paso 3: Invertir la lista
        List<Integer> listaInvertida = new ArrayList<>();
        for (int i = nuevaLista.size() - 1; i >= 0; i--) {
            listaInvertida.add(nuevaLista.get(i));
        }
        // Imprimir la lista invertida
        System.out.println("Lista final invertida: " + listaInvertida);
    }

    public static void desafioDos(int[] array, int S) {
        System.out.println("  ESTA EN EL DESAFIO # 2");
        int SS = S * S;
        System.out.println("elevar al cuadrado cada número de una lista ordenada ascendentemente y regresar una lista en orden descendente, siempre y cuando el cuadrado sea <= " + SS);

        ArrayList<Integer> resultado = new ArrayList<>();
        int izquierda = 0, derecha = array.length - 1;
System.out.println("Lista inicial: "+Arrays.toString(array));
        while (izquierda <= derecha) {
            System.out.println("\n mientras posición " + izquierda + " sea <= posición " + derecha);

            int cuadradoIzq = array[izquierda] * array[izquierda];
            int cuadradoDer = array[derecha] * array[derecha];

            System.out.println("*****numero posición izquierda " + array[izquierda]);
            System.out.println("*****numero posición derecha " + array[derecha]);
            System.out.println("cuadrado del numero posición izquierda " + cuadradoIzq);
            System.out.println("cuadrado del numero posición derecha " + cuadradoDer);

            if (cuadradoIzq > cuadradoDer) {
                System.out.println("cuadrado izquierda: " + cuadradoIzq + " > a cuadrado derecha: " + cuadradoDer);

                if (cuadradoIzq <= SS) {
                    System.out.println("cuadrado izquierda: " + cuadradoIzq + " <= al cuadrado de S: " + SS);
                    resultado.add(0, cuadradoIzq);
                    System.out.println("SE AGREGA " + cuadradoIzq + " en la primer posición de la lista final");
                } else {
                    System.out.println("como cuadrado izquierda: " + cuadradoIzq + "  > al cuadrado de S: " + SS + ". NO HACER NADA");
                }

                izquierda++;
            } else {
                System.out.println("cuadrado izquierda: " + cuadradoIzq + " < a cuadrado derecha: " + cuadradoDer);

                if (cuadradoDer <= SS) {
                    System.out.println("cuadrado derecha: " + cuadradoDer + " <= al cuadrado de S: " + SS);
                    resultado.add(0, cuadradoDer);
                    System.out.println("SE AGREGA " + cuadradoDer + " en la primer posición de la lista final");
                } else {
                    System.out.println("como cuadrado derecha: " + cuadradoDer + "  > al cuadrado de S: " + SS + ". NO HACER NADA");
                }

                derecha--;
            }
        }

        System.out.println("\n Lista final : " + resultado);
    }

    public static int desafioTres(int[] monedas) {
        System.out.println(" ESTA EN EL DESAFIO # 3");
        System.out.println("Dado un conjunto de monedas de diferente valor, encontrar el cambio mínimo que NO se puede obtener");
        System.out.println("monedas: " + Arrays.toString(monedas));
        // Ordenamos las monedas en orden ascendente para considerar las más pequeñas primero
        Arrays.sort(monedas);
        System.out.println("monedas ordenadas: " + Arrays.toString(monedas));
        // Inicializamos minimaCombinacionNoPosible a 1, que es el mínimo cambio que no podemos hacer al principio
        int minimaCombinacionNoPosible = 1;
        System.out.println("minimaCombinacionNoPosible " + minimaCombinacionNoPosible);
        // Iteramos a través de cada moneda en la matriz ordenada
        for (int moneda : monedas) {
            System.out.println("\n*********** moneda: " + moneda);
            // Si la moneda actual es menor o igual a minimaCombinacionNoPosible,
            // significa que ahora podemos hacer el cambio para minimaCombinacionNoPosible y debemos actualizarlo.
            if (moneda <= minimaCombinacionNoPosible) {
                System.out.println("como moneda " + moneda + " es <= a minimaCombinacionNoPosible " + minimaCombinacionNoPosible);
                minimaCombinacionNoPosible += moneda;
                System.out.println("sumamos la moneda " + moneda + " a la minimaCombinacionNoPosible " + minimaCombinacionNoPosible + ", dando como resultado: " + minimaCombinacionNoPosible);
            } // Si la moneda actual es mayor que minimaCombinacionNoPosible,
            // entonces aún no podemos hacer el cambio para minimaCombinacionNoPosible y deberíamos salir del bucle.
            else {
                break;
            }
        }
        // Retornamos el valor de minimaCombinacionNoPosible que es el mínimo cambio que no podemos hacer
        return minimaCombinacionNoPosible;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiradamoneda;

import java.util.Scanner;

/**
 *
 * @author Emilio
 */
public class extraer {

    public static class TiradaMoneda {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            // TODO code application logic here
            //las variables resultadoPrimeraMoneda y resultadoSegundaMoneda servirán para guardar el resultado de la tirada de dos monedas
            int resultadoPrimeraMoneda;
            int resultadoSegundaMoneda;
            int cuentaCaras = 0;
            int cuentaCruces = 0;
            int numeroTotalTiradas;
            //las variables contador1 y contador2 servirán para guardar el número de caras y cruces dobles consecutivas
            int contador1 = 0;
            int contador2 = 0;
            int maximoCarasRepetidasConsecutivas = 0;
            int maximoCrucesRepetidasConsecutivas = 0;
            boolean esCruzDoble = false;
            boolean esCaraDoble = false;
            String tirada1;
            String tirada2;
            Scanner teclado = new Scanner(System.in);
            do {
                System.out.print("Introduce el n\u00famero de veces que se van a lanzar las monedas (max 50): ");
                numeroTotalTiradas = teclado.nextInt();
            } while (numeroTotalTiradas < 1 || numeroTotalTiradas > 50);
            for (int i = 0; i < numeroTotalTiradas; i++) {
                resultadoPrimeraMoneda = (int) (Math.random() * 2);
                resultadoSegundaMoneda = (int) (Math.random() * 2);
                if (resultadoPrimeraMoneda == 0) {
                    cuentaCaras++;
                    tirada1 = "cara";
                } else {
                    cuentaCruces++;
                    tirada1 = "cruz";
                }
                if (resultadoSegundaMoneda == 0) {
                    cuentaCaras++;
                    tirada2 = "cara";
                } else {
                    cuentaCruces++;
                    tirada2 = "cruz";
                }
                System.out.println("Moneda 1: " + tirada1 + ", Moneda 2: " + tirada2);
                if (resultadoPrimeraMoneda == resultadoSegundaMoneda) {
                    if (resultadoPrimeraMoneda == 0) {
                        esCaraDoble = true;
                        esCruzDoble = false;
                    } else {
                        esCaraDoble = false;
                        esCruzDoble = true;
                    }
                } else {
                    esCaraDoble = false;
                    esCruzDoble = false;
                }
                if (esCaraDoble) {
                    contador1++;
                    if (contador1 > maximoCarasRepetidasConsecutivas) {
                        maximoCarasRepetidasConsecutivas = contador1;
                    }
                } else {
                    contador1 = 0;
                }
                if (esCruzDoble) {
                    contador2++;
                    if (contador2 > maximoCrucesRepetidasConsecutivas) {
                        maximoCrucesRepetidasConsecutivas = contador2;
                    }
                } else {
                    contador2 = 0;
                }
            }
            imprime(cuentaCaras, cuentaCruces, maximoCarasRepetidasConsecutivas, maximoCrucesRepetidasConsecutivas);
        }

        /**
         *
         * @param cuentaCaras the value of cuentaCaras
         * @param cuentaCruces the value of cuentaCruces
         * @param maximoCarasRepetidasConsecutivas the value of maximoCarasRepetidasConsecutivas
         * @param maximoCrucesRepetidasConsecutivas the value of maximoCrucesRepetidasConsecutivas
         */
        public static void imprime(int cuentaCaras, int cuentaCruces, int maximoCarasRepetidasConsecutivas, int maximoCrucesRepetidasConsecutivas) {
            System.out.println("Caras: " + cuentaCaras + ", Cruces: " + cuentaCruces);
            System.out.println("Maximo de caras dobles consecutivas: " + maximoCarasRepetidasConsecutivas);
            System.out.println("Maximo de cruces dobles consecutivas: " + maximoCrucesRepetidasConsecutivas);
        }
    }
    
}

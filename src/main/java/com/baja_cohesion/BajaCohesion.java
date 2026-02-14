package com.baja_cohesion;

public class BajaCohesion {

    public void procesar() {
        double pesoKg = 70;
        double alturaM = 1.75;

        double imc = pesoKg / (alturaM * alturaM);

        System.out.println("IMC: " + imc);

        if (imc < 18.5) {
            System.out.println("Clasificación: Bajo peso");
        } else if (imc < 25) {
            System.out.println("Clasificación: Normal");
        } else if (imc < 30) {
            System.out.println("Clasificación: Sobrepeso");
        } else {
            System.out.println("Clasificación: Obesidad");
        }
    }

    public static void main(String[] args) {
        new BajaCohesion().procesar();
    }
}
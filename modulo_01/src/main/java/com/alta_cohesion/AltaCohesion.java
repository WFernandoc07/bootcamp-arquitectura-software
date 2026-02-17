package com.alta_cohesion;

public class AltaCohesion {

    // Lógica de negocio
    static class Inventario {
        public int entrada(int stockActual, int cantidad) {

            return stockActual + cantidad;
        }

        public int salida(int stockActual, int cantidad) {

            return stockActual - cantidad;
        }
    }

    // Interacción con el usuario
    static class InterfazUsuario {
        public void mostrarStock(int stock) {

            System.out.println("El stock actual es: " + stock);
        }

        public void validarStock(int stock) {
            if (stock < 0) {
                System.out.println("Stock inválido: no puede ser negativo.");
            } else if (stock == 0) {
                System.out.println("Stock en cero.");
            } else {
                System.out.println("Stock disponible.");
            }
        }
    }

    static class ProgramaAltaCohesion {
        public void procesar() {
            Inventario inventario = new Inventario();
            InterfazUsuario interfaz = new InterfazUsuario();

            int stock = 10;
            stock = inventario.entrada(stock, 5);
            stock = inventario.salida(stock, 3);

            interfaz.mostrarStock(stock);
            interfaz.validarStock(stock);
        }
    }

    // Procesar programa
    public static void main(String[] args) {
        ProgramaAltaCohesion programa = new ProgramaAltaCohesion();
        programa.procesar();
    }
}
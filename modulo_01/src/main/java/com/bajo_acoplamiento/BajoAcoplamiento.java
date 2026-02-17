package com.bajo_acoplamiento;

public class BajoAcoplamiento {

    // 1) Abstracción
    interface InventarioRepo {
        int obtenerStock(String codigo);
        void guardarStock(String codigo, int nuevoStock);
    }

    // 2) Implementación concreta (en memoria)
    static class InventarioMemoria implements InventarioRepo {
        private int stockP001 = 22;

        @Override
        public int obtenerStock(String codigo) {
            return stockP001;
        }

        @Override
        public void guardarStock(String codigo, int nuevoStock) {
            stockP001 = nuevoStock;
        }
    }

    // 3) Servicio (lógica)
    static class ServicioInventario {
        private final InventarioRepo repo;

        public ServicioInventario(InventarioRepo repo) {
            this.repo = repo;
        }

        public void entrada(String codigo, int cantidad) {
            int stock = repo.obtenerStock(codigo);
            repo.guardarStock(codigo, stock + cantidad);
        }

        public void salida(String codigo, int cantidad) {
            int stock = repo.obtenerStock(codigo);
            repo.guardarStock(codigo, stock - cantidad);
        }

        public int verStock(String codigo) {
            return repo.obtenerStock(codigo);
        }
    }

    //
    public static void main(String[] args) {
        InventarioRepo repo = new InventarioMemoria();
        ServicioInventario servicio = new ServicioInventario(repo);

        servicio.entrada("P001", 5);
        servicio.salida("P001", 3);

        System.out.println("Stock final P001: " + servicio.verStock("P001"));
    }
}
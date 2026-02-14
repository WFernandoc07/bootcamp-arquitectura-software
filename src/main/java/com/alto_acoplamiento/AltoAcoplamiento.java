package com.alto_acoplamiento;

public class AltoAcoplamiento {

    interface InventarioRepo {
        int get();
        void set(int n);
    }

    static class RepoMemoria implements InventarioRepo {
        private int stock = 10;
        public int get() {
            return stock; }
        public void set(int n) {
            stock = n;
        }
    }

    static class ServicioInventario {
        private final InventarioRepo repo;
        public ServicioInventario(InventarioRepo repo) {
            this.repo = repo;
        }

        public void entrada(int cant) { repo.set(repo.get() + cant); }
        public void salida(int cant)  { repo.set(repo.get() - cant); }
    }

    public static void main(String[] args) {
        InventarioRepo repo = new RepoMemoria();      // inyección
        ServicioInventario s = new ServicioInventario(repo);

        s.entrada(5);
        s.salida(3);

        System.out.println("Stock final: " + repo.get());
    }
}
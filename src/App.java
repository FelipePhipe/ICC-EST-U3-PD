public class App {
    public static void main(String[] args) throws Exception {
        runEjerciciosPD();
    }

    private static void runEjerciciosPD() {
        System.out.println("Felipe Parra");
        EjerciciosPD ejerciciosPD = new EjerciciosPD();

        System.out.println("Fibonacci recursivo");
        long start = System.nanoTime();
        long resultado = ejerciciosPD.getFibonaci(30);
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Resultado = " + resultado + " en tiempo = " + duration + " ns");

        System.out.println("Fibonacci recursivo con Caching");
        start = System.currentTimeMillis();
        resultado = ejerciciosPD.getFibonaciPD(50);
        end = System.currentTimeMillis();
        duration = end - start;
        System.out.println("Resultado = " + resultado + " en tiempo = " + duration + " ns");
    }
}

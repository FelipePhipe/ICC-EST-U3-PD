public class EjerciciosPD {

    public long getFibonaci(long n) {
        if (n <= 1) return n;
        return getFibonaci(n - 1) + getFibonaci(n - 2);
    }


    public long getFibonaciPD(int n) {
        long[] cache = new long[n + 1];


        for (int i = 0; i <= n; i++) {
            cache[i] = -1;
        }

        return getFibonaciPD(n, cache);
    }

    private long getFibonaciPD(int n, long[] cache) {
        if (n <= 1) return n;

        if (cache[n] != -1) {
            return cache[n];
        }

        cache[n] = getFibonaciPD(n - 1, cache) + getFibonaciPD(n - 2, cache);
        return cache[n];
    }
}

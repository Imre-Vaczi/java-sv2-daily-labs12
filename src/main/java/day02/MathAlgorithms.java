package day02;

public class MathAlgorithms {

    public int lko(int a, int b) {
        int bigger = Math.max(a, b);
        int smaller = Math.min(a, b);

        if (smaller % bigger == 0) {
            return smaller;
        }

        for (int i = smaller /2; i > 1; i--) {
            if (smaller % i == 0 & bigger % i == 0) {
                return i;
            }
        }
        return -1;
    }
}

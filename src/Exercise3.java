public class Exercise3 {

    public static void main(String[] args) {
        int n = 12600;
        primeFactors(n);
    }

    public static int[] primeFactors(int n) {
        int[] temp = new int[n];
        int count = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                temp[count] = i;
                count++;
                n = n / i;
            }
        }
        int[] fixed = new int[count];
        for (int k = 0; k < count; k++)
            fixed[k] = temp[k];

        return fixed;
    }
}
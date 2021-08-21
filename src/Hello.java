public class Hello {
    public static void main(String[] args) {
        int ans = getSolution(8);
        System.out.println(ans);
    }

    public static int getSolution(int n) {
        if (n < 1) {
            return 0;
        }

        int[] record = new int[n];
        return process(0, n, record);
    }

    public static int process(int i, int n, int[] record) {
        if (i == n) {
            return 1;
        }

        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(i, j, record)) {
                record[i] = j;
                res += process(i + 1, n, record);
            }
        }

        return res;
    }

    public static boolean isValid(int i, int j, int[] record) {
        if (i == 0) {
            return true;
        }

        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(j - record[k]) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }
}

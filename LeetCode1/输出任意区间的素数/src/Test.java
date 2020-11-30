public class Test {
    public static void printPrimeNum(int num1,int num2) {
        for (int i = num1; i <= num2; i++) {
            if (i == 0) {
                System.out.println(i);
            }
            int j = 2;
            for (; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (j > Math.sqrt(i)) {
                System.out.println(i);
            }
        }
    }
}

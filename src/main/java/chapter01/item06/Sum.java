package chapter01.item06;

/**
 * item06. 불필요한 객체 생성을 피하라.
 * 3) 오토박싱
 */
public class Sum {
    private static long sum() {
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i; // sum이 Long인 경우 i 에서 오토박싱이 계속 일어나서 속도가 느리게 된다.
        }
        return sum;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        long x = sum();
        long end = System.nanoTime();

        System.out.println(((end - start) / 1_000_000.) + "ms.");
        System.out.println("x = " + x);
    }
}

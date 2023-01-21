package chapter01.item07.reference;

import java.lang.ref.SoftReference;

/**
 * item07. 다 쓴 객체 참졸를 해제하라.
 * 완벽공략 - WeakHashMap
 */
public class SoftReferenceExample {

    public static void main(String[] args) throws InterruptedException {
        Object strong = new Object();
        SoftReference<Object> soft = new SoftReference<>(strong);
        strong = null;

        System.gc();
        Thread.sleep(3000L);

        // softReference도 GC의 대상이 되기는 하지만..
        // 메모리가 부족할 때 제거하기 때문에 지금은 사라지지 않을 것이다. (메모리가 지금은 충분하기 때문)
        System.out.println(soft.get());
    }
}

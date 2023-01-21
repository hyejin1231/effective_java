package chapter01.item07.reference;

import java.lang.ref.WeakReference;

public class WeakReferenceExample {
    public static void main(String[] args) throws InterruptedException {
        Object strong = new Object();
        WeakReference<Object> weak = new WeakReference<>(strong);
        strong = null;

        System.gc();
        Thread.sleep(3000L);

        // WeakReference는 제거된다. (soft보다 약하게 참조하는 상태이기 때문에)
        System.out.println("weak.get() = " + weak.get());
    }
}

package chapter01.item07.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceExample {
    public static void main(String[] args) throws InterruptedException {
        BigObject strong = new BigObject();
        ReferenceQueue<BigObject> rq = new ReferenceQueue<>();

        BigObjectReference<BigObject> phantom = new BigObjectReference(strong, rq); // 자원 반납으로 활용하고 싶을 때
//        PhantomReference<BigObject> phantom = new PhantomReference<>(strong,rq);
        strong = null;

        System.gc();
        Thread.sleep(3000L);

        // 사라지지는 않고 queue에 들어간다.
        System.out.println("phantom.isEnqueued() = " + phantom.isEnqueued());

        Reference<? extends BigObject> reference = rq.poll();
        BigObjectReference bigObjectCleaner = (BigObjectReference) reference;
        bigObjectCleaner.cleanUp(); // 자원 반납 메서드 실행
        reference.clear(); // 이렇게 하면 최종적으로 사라진다.

    }
}

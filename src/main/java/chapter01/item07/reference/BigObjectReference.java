package chapter01.item07.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 자원을 반납하고 싶은 용도로 사용할 때
 */
public class BigObjectReference<BigObject> extends PhantomReference<BigObject> {

    /**
     * Creates a new phantom reference that refers to the given object and
     * is registered with the given queue.
     *
     * <p> It is possible to create a phantom reference with a {@code null}
     * queue, but such a reference is completely useless: Its {@code get}
     * method will always return {@code null} and, since it does not have a queue,
     * it will never be enqueued.
     *
     * @param referent the object the new phantom reference will refer to
     * @param q        the queue with which the reference is to be registered,
     *                 or {@code null} if registration is not required
     */
    public BigObjectReference(BigObject referent, ReferenceQueue<? super BigObject> q) {
        super(referent, q);
    }

    // 임의로 만든 것 (여기서 자원 반납을 하겠다~)
    public void cleanUp() {
        System.out.println("clean up!!");
    }
}

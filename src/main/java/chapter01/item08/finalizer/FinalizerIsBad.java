package chapter01.item08.finalizer;

/**
 * item08. finalizer와 cleaner 사용을 피하라.
 */
public class FinalizerIsBad {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("");
    }
}

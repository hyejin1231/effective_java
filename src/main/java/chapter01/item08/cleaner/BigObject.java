package chapter01.item08.cleaner;

import java.util.List;

/**
 * item08. finalizer 와 cleaner 사용을 피하라.
 */
public class BigObject {
    private List<Object> resources;

    public BigObject(List<Object> resources) {
        this.resources = resources;
    }

    // 정리 작업 수행하는 Runnable 클래스
    public static class ResourceCleaner implements Runnable {
        private List<Object> resourceToClean;

        public ResourceCleaner(List<Object> resourceToClean) {
            this.resourceToClean = resourceToClean;
        }

        @Override
        public void run() {
            resourceToClean = null;
            System.out.println("cleaned up.");
        }
    }

}

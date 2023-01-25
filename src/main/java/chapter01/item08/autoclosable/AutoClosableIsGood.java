package chapter01.item08.autoclosable;

import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * item08. finalizer 와 cleaner 사용을 피하라.
 */
public class AutoClosableIsGood implements AutoCloseable{
    private BufferedInputStream inputStream;

    @Override
    public void close(){
        // idempotent 해야 한다.(몇번을 호출하더라도 동일한 결과가 수행되어야 한다.) AutoClosable 은 권장, Closeable 필수
        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("failed to close " + inputStream);
        }
    }
}

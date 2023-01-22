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
        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("failed to close " + inputStream);
        }
    }
}

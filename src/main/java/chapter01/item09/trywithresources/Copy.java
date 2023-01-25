package chapter01.item09.trywithresources;

import java.io.*;

/**
 * item09: try-finally 보다는 try-with-resources 를 사용하라.
 */
public class Copy {
    private static final int BUFFER_SIZE = 8 * 1024;

    // try-with-resources는 복수의 자원을 처리할 때 코드가 더 간결하다.
    static void copy(String src, String dst) throws IOException {

        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)
        ) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String src = args[0];
        String dst = args[1];
        copy(src, dst);
    }
}


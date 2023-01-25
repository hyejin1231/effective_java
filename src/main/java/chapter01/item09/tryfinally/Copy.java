package chapter01.item09.tryfinally;

import java.io.*;

/**
 * item09. try-finally보다 try-with-resources를 사용하라.
 */
public class Copy {

    private static final int BUFFER_SIZE = 8 * 1024;

    // 자원이 둘 이상이면 try-finally 방식은 코드가 너무 지저분해진다.
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0) {
                    out.write(buf, 0, n);
                }
            }finally {
                out.close();
            }
        }finally {
            in.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String src = args[0];
        String dst = args[1];
        copy(src, dst);
    }
}

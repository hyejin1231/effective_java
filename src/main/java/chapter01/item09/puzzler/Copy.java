package chapter01.item09.puzzler;

import java.io.*;

/**
 * item09. try-finally 보다는 try-with-resources를 사용하라.
 * 자바 Puzzler 책을 언급한 예외 처리 코드의 실수
 */
public class Copy {

    private static final int BUFFER_SIZE = 8 * 1024;

    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                // 안전하지 않는가? 이렇게 하면 되는거 아닌가?
                // No, 다른 예외가 발생하면 끝나버림,,
            }

            try {
                in.close();
            } catch (IOException e) {
                // 안전하지 않는가? 이렇게 하면 되는거 아닌가?
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String src = args[0];
        String dst = args[1];
        copy(src, dst);
    }
}

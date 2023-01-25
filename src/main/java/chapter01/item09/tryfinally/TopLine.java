package chapter01.item09.tryfinally;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * item09. try-finally 보다 try-with-resources 를 사용하라.
 */
public class TopLine {
    // try-finally: 더 이상 자원을 회수하는 최선의 방책이 아니다!!
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        }finally {
            br.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String path = args[0];
        System.out.println(firstLineOfFile(path));
    }
}

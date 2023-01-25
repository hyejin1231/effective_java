package chapter01.item09.suppress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * item09. try-finally 보다 try-with-resources 를 사용하라.
 */
public class TopLine {
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BadBufferedReader(new FileReader(path));
        // try-finally는 맨 마지막에 발생한 예외만 보인다는 단점이 있다.
        // 첫번째 예외가 중요한데 다른 예외들은 보이지 않는 것이 단점..!!
        try {
            return br.readLine();
        }finally {
            br.close();
        }

    }

    public static void main(String[] args) throws IOException{
        System.out.println(firstLineOfFile("book.obj"));
    }
}


package chapter01.item09.suppress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * item09. try-finally 보다 try-with-resources를 사용하라.
 */
public class TopLineWithTryWithResources {

    // try-with-resources 는 예외를 모두 보여준다.
    static String firstLineOfFile(String path) throws IOException {
        try (BufferedReader bufferedReader = new BadBufferedReader(new FileReader(path))){
            return bufferedReader.readLine();
        }
    }

    public static void main(String[] args) throws IOException{
        System.out.println(firstLineOfFile("book.obj"));
    }
}

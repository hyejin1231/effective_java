package chapter01.item04;

import java.util.StringTokenizer;

public class Main04 {

    public static void main(String[] args) {
        String hello = UtilityClass.hello();

        StringTokenizer stringTokenizer = new StringTokenizer("Ditto OMG Attention HypeBoy Cookie Hurt");

        while (stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
        }
    }
}

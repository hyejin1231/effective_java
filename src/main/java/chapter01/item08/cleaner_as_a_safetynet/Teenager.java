package chapter01.item08.cleaner_as_a_safetynet;

// cleaner 안전망을 갖춘 자원을 제대로 활용하지 못하는 클라이언트
public class Teenager {
    public static void main(String[] args) {
        new Room(99);
        System.out.println("Peace out");


        System.gc();
    }
}

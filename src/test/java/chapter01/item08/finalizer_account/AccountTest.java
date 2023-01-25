package chapter01.item08.finalizer_account;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void 일반_계정() {
        Account account = new Account("hyejin");
        account.transfer(BigDecimal.valueOf(10.4), "hello");
    }

    @Test
    void aaa_계정() {
        Account account = new Account("aaa");
        account.transfer(BigDecimal.valueOf(10.4), "hello~");
    }

    @Test
    void broken_aaa_계정() throws InterruptedException {
        Account account = null;
        try {
            account = new BrokenAccount("aaa");
        } catch (Exception e) {
            System.out.println("이러면???");
        }
        System.gc();
        Thread.sleep(3000L); // gc하기 위한 시간
    }

}
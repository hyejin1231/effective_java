package chapter01.item08.finalizer_account;

import java.math.BigDecimal;

/**
 * item08. finalizer 와 cleaner 사용을 피하라.
 * 완벽공략 - finalizer 공격
 */
public class BrokenAccount extends Account {

    public BrokenAccount(String accountId) {
        super(accountId);
    }

//    @Override
//    protected void finalize() throws Throwable {
//        this.transfer(BigDecimal.valueOf(100), "hyejin");
//    }
}

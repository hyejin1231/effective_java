package chapter01.item08.finalizer_account;

import java.math.BigDecimal;

/**
 * item08. finalizer와 cleaner 사용을 피하라.
 * 완벽공략 - finalizer 공격
 */
public class Account {
    private String accountId;

    public Account(String accountId) {
        this.accountId = accountId;

        if (accountId.equals("aaa")) {
            throw new IllegalArgumentException("aaa의 계정을 막습니다.");
        }
    }

    public void transfer(BigDecimal amount, String to) {
        System.out.printf("transfer %f from %s to %s", amount, accountId, to);
    }

    @Override
    protected  final void finalize() throws Throwable {
        // 오버라이딩을 허용하지 않도록 막아둠
    }
}

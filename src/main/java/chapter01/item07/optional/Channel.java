package chapter01.item07.optional;

import java.util.Optional;

/**
 * item07. 다 쓴 객체 참조를 해제하라.
 * 완벽공략 - NullPointerException
 */
public class Channel {
    private int numOfSubscribers;

    public MemberShip defaultMemberShip() {
        if (this.numOfSubscribers < 2000) {
            return null;
        }else {
            return new MemberShip();
        }
    }

    // npe 대안: Optional을 리턴한다.
    // Optional은 리턴할 때 주로 사용하는걸 권장한다.
    public Optional<MemberShip> optionalMemberShip() {
        if (this.numOfSubscribers < 2000) {
            return Optional.empty();
        }else {
            return Optional.of(new MemberShip());
        }
    }
}

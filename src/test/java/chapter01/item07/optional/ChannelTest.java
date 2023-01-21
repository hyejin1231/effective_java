package chapter01.item07.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ChannelTest {

    @Test
    void npe() {
        Channel channel = new Channel();
        MemberShip memberShip = channel.defaultMemberShip();
        if (memberShip != null) {
            memberShip.equals(new MemberShip()); // npe 발생 시점
        }

        Optional<MemberShip> optionalMemberShip = channel.optionalMemberShip();
        optionalMemberShip.ifPresent(MemberShip::hello);
    }

}
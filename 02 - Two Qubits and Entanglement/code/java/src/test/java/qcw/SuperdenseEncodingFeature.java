package qcw;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SuperdenseEncodingFeature {

    @Test
    void transmit_ascii_character_h() {
        QubitSource eve = new QubitSource(new Random(1));

        // Eve prepares 4 2-qubit pairs in Bell state
        Stream<Qupair> qupairs = Stream.generate(eve::prepareBellState).limit(4L);

        // Alice, given just the first qubit in each pair, encodes ASCII character 'H' => 01 00 10 00 => X I Z I
        SuperdenseEncoder alice = new SuperdenseEncoder(qupairs.map(Qupair::first));
        alice.encode('H');

        // Bob, given the recombined pairs, recovers the information sent by Alice
        SuperdenseDecoder bob = new SuperdenseDecoder();
        assertThat(bob.decode(qupairs)).isEqualTo('H');
    }
}

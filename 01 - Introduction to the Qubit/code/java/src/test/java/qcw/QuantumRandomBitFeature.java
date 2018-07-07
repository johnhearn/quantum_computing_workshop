package qcw;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class QuantumRandomBitFeature {

    @Test
    void quantum_random_bit_generator() {
        QubitSource qubitSource = new QubitSource(new Random(1));
        assertThat(Stream.generate(qubitSource::prepareFalse)
                .limit(100L)
                .map(Qubit::halfNot)
                .filter(Qubit::measure)
                .count()).isBetween(48L, 52L); // ~50% False ~50% True
    }
}

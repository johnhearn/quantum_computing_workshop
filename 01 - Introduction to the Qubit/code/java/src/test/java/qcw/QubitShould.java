package qcw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class QubitShould {

    private static final Random RANDOM = new Random(1L);
    private Stream<Qubit> qubitStream;

    @BeforeEach
    void setUp() {
        qubitStream = Stream.generate(() -> new Qubit(RANDOM))
                .limit(100L);
    }

    @Test
    void default_to_false_state() {
        assertThat(qubitStream
                .filter(Qubit::measure)
                .count()).isEqualTo(0L);
    }

    @Test
    void apply_not_gate_to_false_state_to_produce_true_state() {
        assertThat(qubitStream
                .map(Qubit::not)
                .filter(Qubit::measure)
                .count()).isEqualTo(100L);
    }

    @Test
    void apply_half_not_gate_to_false_state_produces_plus_state() {
        assertThat(qubitStream
                .map(Qubit::halfNot)
                .filter(Qubit::measure)
                .count()).isBetween(48L, 52L);
    }

}

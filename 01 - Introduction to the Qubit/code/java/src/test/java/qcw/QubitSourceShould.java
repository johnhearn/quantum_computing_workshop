package qcw;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class QubitSourceShould {
    @Test
    void create_qubits() {
        QubitSource qubitSource = new QubitSource(new Random());
        assertThat(Stream.generate(qubitSource::prepareUp)
                .limit(100L)
                .filter(Qubit::measure)
                .count()).isEqualTo(0L);
    }
}

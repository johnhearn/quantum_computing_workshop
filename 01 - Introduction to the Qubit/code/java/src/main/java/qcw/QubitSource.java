package qcw;

import java.util.Random;

class QubitSource {
    private final Random random;

    QubitSource(Random random) {
        this.random = random;
    }

    Qubit prepareUp() {
        return new Qubit(random);
    }
}
